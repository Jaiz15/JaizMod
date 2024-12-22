package jaiz.jaizmod.entity.bandit;

import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.item.ModItems;
import jaiz.jaizmod.sound.ModSounds;
import jaiz.jaizmod.util.ModLootTables;
import net.minecraft.block.Block;
import net.minecraft.block.entity.VaultBlockEntity;
import net.minecraft.command.argument.EntityAnchorArgumentType;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.brain.task.LookTargetUtil;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class BanditEntity extends HostileEntity {

    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(BanditEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public int peacefulTime = 0;

    public AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public BanditEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 16;
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
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(20);
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
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


    private List<ItemStack> getBanditTrades(BanditEntity bandit) {
        LootTable lootTable = bandit.getWorld().getServer().getReloadableRegistries().getLootTable(getBanditLootTable());
        LootContextParameterSet lootContextParameterSet = new LootContextParameterSet.Builder((ServerWorld)bandit.getWorld())
                .add(LootContextParameters.ORIGIN, bandit.getPos())
                .add(LootContextParameters.THIS_ENTITY, bandit)
                .build(LootContextTypes.BARTER);
        return lootTable.generateLoot(lootContextParameterSet);
    }

    private RegistryKey<LootTable> getBanditLootTable() {
        return ModLootTables.BANDIT_TRADES_GAMEPLAY;
    }

    private void TradingItemDropper(BanditEntity bandit, LivingEntity recipient) {
        for (int i = 0; i < this.getRandom().nextInt(9) + 3; i++) {
            this.getWorld().addParticle(ParticleTypes.HAPPY_VILLAGER,
                    this.getParticleX(1.2),
                    this.getRandomBodyY(),
                    this.getParticleZ(1.2), 0.0, 0.0, 0.0);
        }
        this.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
        for (ItemStack itemStack : this.getBanditTrades(bandit)) {
            LookTargetUtil.give(bandit, itemStack, recipient.getPos());
        }
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        if(peacefulTime <= 0){
        if (itemStack.isOf(ModItems.RARE_SPICES )) {
                peacefulTime =this.random.nextInt(600) + 600;
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            this.playSound(ModSounds.BANDIT_TRADE,1.0f, 1.0f);
            this.TradingItemDropper(this, player);
                return ActionResult.success(this.getWorld().isClient);
            }

            else {
            this.playSound(ModSounds.BANDIT_TRADE_FAIL,1.0f, 1.0f);
            for (int i = 0; i < this.getRandom().nextInt(9) + 3; i++) {
                this.getWorld().addParticle(ParticleTypes.ANGRY_VILLAGER,
                        this.getParticleX(1.2),
                        this.getRandomBodyY(),
                        this.getParticleZ(1.2), 0.0, 0.0, 0.0);
            }
                return ActionResult.FAIL;
            }
        }
        else {
            this.playSound(ModSounds.BANDIT_TRADE_FAIL,1.0f, 1.0f);
            for (int i = 0; i < this.getRandom().nextInt(9) + 3; i++) {
                this.getWorld().addParticle(ParticleTypes.ANGRY_VILLAGER,
                        this.getParticleX(1.2),
                        this.getRandomBodyY(),
                        this.getParticleZ(1.2), 0.0, 0.0, 0.0);
            }
            return ActionResult.FAIL;
        }
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
        this.goalSelector.add(2, new BanditAttackGoal(this, 1d, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(4, new RevengeGoal(this));
        this.targetSelector.add(5, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.add(6, new ActiveTargetGoal<>(this, SnowGolemEntity.class, true));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0));

    }

    public static DefaultAttributeContainer.Builder createBanditAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25f)
                .add(EntityAttributes.GENERIC_ARMOR, 0.3f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 40)
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



    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(ATTACKING, false);
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

}
