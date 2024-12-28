package jaiz.jaizmod.entity.bandit;

import jaiz.jaizmod.item.ModItems;
import jaiz.jaizmod.sound.ModSounds;
import jaiz.jaizmod.util.ModLootTables;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.brain.task.LookTargetUtil;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BanditEntity extends HostileEntity {


    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(BanditEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private int peacefulTime = 0;

    public AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public AnimationState tradeAnimationState = new AnimationState();
    public int tradeAnimationTimeout = 0;

    public BanditEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 16;
    }

    private RegistryKey<LootTable> getBanditLootTable() {
        return ModLootTables.BANDIT_TRADES_GAMEPLAY;
    }

    private List<ItemStack> getBanditTrades(BanditEntity bandit, ServerWorld serverWorld) {
            LootTable lootTable = serverWorld.getServer().getReloadableRegistries().getLootTable(getBanditLootTable());
            LootContextParameterSet lootContextParameterSet = new LootContextParameterSet.Builder(serverWorld)
                    .add(LootContextParameters.ORIGIN, bandit.getPos())
                    .add(LootContextParameters.THIS_ENTITY, bandit)
                    .build(LootContextTypes.GIFT);
            return lootTable.generateLoot(lootContextParameterSet);
    }

    private void TradingItemDropper(BanditEntity bandit, LivingEntity recipient) {
        for (int i = 0; i < bandit.getRandom().nextInt(9) + 3; i++) {
            bandit.getWorld().addParticle(ParticleTypes.HAPPY_VILLAGER,
                    bandit.getParticleX(1.2),
                    bandit.getRandomBodyY(),
                    bandit.getParticleZ(1.2), 0.0, 0.0, 0.0);
        }
        bandit.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 0.7F, (bandit.random.nextFloat() - bandit.random.nextFloat()) * 0.2F + 1.0F);


        if (getWorld() instanceof ServerWorld serverWorld) {
            for (ItemStack itemStack : this.getBanditTrades(bandit, serverWorld)) {
                LookTargetUtil.give(bandit, itemStack, recipient.getPos());
            }
        }
    }

    @Override
    public void checkDespawn() {
        if (this.getWorld().getDifficulty() == Difficulty.PEACEFUL && this.isDisallowedInPeaceful()) {
            this.discard();
            return;
        }
        this.despawnCounter = 0;
    }

    private void setupAnimationStates() {

        if (this.tradeAnimationTimeout == 0) {
            tradeAnimationState.stop();
        } else {
            --this.tradeAnimationTimeout;
        }

        if(this.isAttacking()  && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 20;
            attackAnimationState.start(this.age);
        } else {
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()) {
            attackAnimationState.stop();
        }

    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        if(peacefulTime <= 0){
        if (itemStack.isOf(ModItems.RARE_SPICES)) {
            peacefulTime =this.random.nextInt(1200) + 900;
            this.tradeAnimationState.start(this.age);
            this.tradeAnimationTimeout = 8;
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            this.playSound(ModSounds.BANDIT_TRADE,1.0f, 1.0f);
            this.TradingItemDropper(this, this.getEntityWorld().getClosestPlayer(this, 32));
            return ActionResult.success(this.getWorld().isClient);
            }
            else {
            return ActionResult.FAIL;
            }
        }
        else if (itemStack.isOf(ModItems.RARE_SPICES)){
            this.playSound(ModSounds.BANDIT_TRADE_FAIL,1.0f, 1.0f);
            for (int i = 0; i < this.getRandom().nextInt(9) + 3; i++) {
                this.getWorld().addParticle(ParticleTypes.ANGRY_VILLAGER,
                        this.getParticleX(1.2),
                        this.getRandomBodyY(),
                        this.getParticleZ(1.2), 0.0, 0.0, 0.0);
            }
            return ActionResult.success(this.getWorld().isClient);
        }
        return ActionResult.FAIL;
    }

    @Override
    public void tick() {
        super.tick();
        peacefulTime--;

        if (this.getTarget() != null) {
            if (this.getTarget().isPlayer() && isPeaceful()) {
                this.setTarget(null);
            }
        }

        if (this.getWorld().isClient()) {
            setupAnimationStates();
        }
    }


    @Override
    protected void initGoals() {
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(1, new BanditEntity.FleeGoal<>(this, PlayerEntity.class, 12.0F, 1.4, 1.6));
        this.goalSelector.add(2, new BanditAttackGoal(this, 1d, false));
        this.targetSelector.add(4, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new RevengeGoal(this));
        this.targetSelector.add(6, new ActiveTargetGoal<>(this, PillagerEntity.class, true));
        this.targetSelector.add(6, new ActiveTargetGoal<>(this, EvokerEntity.class, true));
        this.targetSelector.add(6, new ActiveTargetGoal<>(this, VindicatorEntity.class, true));
        this.targetSelector.add(6, new ActiveTargetGoal<>(this, VexEntity.class, true));
        this.targetSelector.add(6, new ActiveTargetGoal<>(this, SnowGolemEntity.class, true));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0));
    }

    static class FleeGoal<T extends LivingEntity> extends FleeEntityGoal<T> {
        private final BanditEntity bandit;

        public FleeGoal(BanditEntity bandit, Class<T> fleeFromType, float distance, double slowSpeed, double fastSpeed) {
            super(bandit, fleeFromType, distance, slowSpeed, fastSpeed);
            this.bandit = bandit;
        }

        @Override
        public boolean canStart() {
            if(bandit.getTarget() != null){
            return bandit.getTarget().getMainHandStack().isOf(ModItems.MACUAHUITL)
                    && bandit.getTarget().isUsingItem()
                    && bandit.getTarget().getOffHandStack().isOf(Items.SHIELD)
                    && super.canStart();
            }
            return false;
        }
    }


    public static DefaultAttributeContainer.Builder createBanditAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25f)
                .add(EntityAttributes.GENERIC_ARMOR, 0.3f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.5f)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 2.5);
    }

    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    @Override
    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }

    public boolean isPeaceful() {
        return peacefulTime >= 0;
    }


    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, nbt.getInt("Variant"));
    }

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(DATA_ID_TYPE_VARIANT, 0);
        builder.add(ATTACKING, false);
    }

    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(BanditEntity.class, TrackedDataHandlerRegistry.INTEGER);

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        BanditVariant variant = Util.getRandom(BanditVariant.values(), this.random);
        setVariant(variant);
        this.initEquipment(random, difficulty);
        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    public Object getVariant() {
        return BanditVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(BanditVariant variant) {
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }




    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.BANDIT_IDLE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.BANDIT_DAMAGE;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.BANDIT_DEATH;
    }

    @Override
    protected void initEquipment(Random random, LocalDifficulty localDifficulty) {
        super.initEquipment(random, localDifficulty);
        if (random.nextFloat() < (this.getWorld().getDifficulty() == Difficulty.HARD ? 0.09F : 0.05F)) {
            int i = random.nextInt(60);
            if (i < 3) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
            } else if(i < 6) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SHOVEL));
            } else if(i < 9) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.OBSIDIAN_DAGGER));
            }else if(i < 12) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_AXE));
            }else if(i < 15) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.OBSIDIAN_SWORD));
            }else if(i < 18) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.SHARP_WEDGE_OBSIDIAN_SWORD));
            }else if(i < 21) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.WEDGE_OBSIDIAN_DAGGER));
            }else if(i < 24) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.WEDGE_OBSIDIAN_SWORD));
            }else if(i < 27) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD));
            }else if(i < 30) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.SHARP_OBSIDIAN_DAGGER));
            }else if(i < 33) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.SHARP_OBSIDIAN_SWORD));
            }else if(i < 36) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.SHARP_REGULAR_OBSIDIAN_SWORD));
            }else if(i < 37) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.MACUAHUITL));
            }else if(i < 40) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
            }else if(i < 43) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_AXE));
            }else if(i < 46) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SHOVEL));
            }else if(i < 48) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.EMERALD));
            }else if(i < 49) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND));
            }else if(i == 50) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.ANCIENT_HORN));
            }else if(i == 51) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.AIR_HORN));
            }else if(i == 52) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.AMETHYST_HORN));
            }else {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.RARE_SPICES));
            }
        }
    }

    @Override
    protected void dropEquipment(ServerWorld world, DamageSource source, boolean causedByPlayer) {
        super.dropEquipment(world, source, causedByPlayer);
    }

}
