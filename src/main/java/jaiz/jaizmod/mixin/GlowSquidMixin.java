package jaiz.jaizmod.mixin;

import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.block.blockentities.SquidLightBlockEntity;
import jaiz.jaizmod.block.blockentities.WaterTickingBlock;
import jaiz.jaizmod.sound.ModSounds;
import jaiz.jaizmod.statuseffects.ModStatusEffects;
import jaiz.jaizmod.util.ModGameRules;
import net.minecraft.block.Blocks;
import net.minecraft.command.argument.EntityAnchorArgumentType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.GlowSquidEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Objects;


@Mixin(GlowSquidEntity.class)
public abstract class GlowSquidMixin extends SquidEntity {

    @Unique
    public int staringcount = 0;
    @Unique
    int hypnotisecooldown = 0;
    @Unique
    int hypnotiseeffectcooldown = 20;


    public GlowSquidMixin(EntityType<? extends SquidEntity> entityType, World world) {
        super(entityType, world);
    }

    @Unique
    boolean isPlayerStaring(PlayerEntity player) {
        ItemStack itemStack = player.getInventory().armor.get(3);
        if (itemStack.isOf(Blocks.CARVED_PUMPKIN.asItem())) {
            return false;
        } else {
            Vec3d vec3d = player.getRotationVec(1.0F).normalize();
            Vec3d vec3d2 = new Vec3d(this.getX() - player.getX(), this.getEyeY() - player.getEyeY(), this.getZ() - player.getZ());
            double d = vec3d2.length();
            vec3d2 = vec3d2.normalize();
            double e = vec3d.dotProduct(vec3d2);
            return e > 1.0 - 0.075 / d && player.canSee(this);
        }
    }

    public void tick() {
        super.tick();
        hypnotisecooldown--;
        if(this.getEntityWorld().getClosestPlayer(this, 32) != null){
            if(hypnotisecooldown <= 0){
            if(isPlayerStaring(Objects.requireNonNull(this.getEntityWorld().getClosestPlayer(this, 32)))){
                hypnotiseeffectcooldown++;
                staringcount++;
                if(staringcount >= 60){
                Objects.requireNonNull(this.getEntityWorld().getClosestPlayer(this, 32))
                        .lookAt(EntityAnchorArgumentType.EntityAnchor.EYES, this.getPos());
                if(hypnotiseeffectcooldown >= 20){
                    hypnotiseeffectcooldown = 0;
                    Objects.requireNonNull(this.getEntityWorld().getClosestPlayer(this, 40))
                            .addStatusEffect(new StatusEffectInstance(ModStatusEffects.HYPNO,
                                    60, 0, false, true));}
                }
            }
            else {
                staringcount = 0;
            }
            }
        }
    }


    @Inject(at = @At("TAIL"), method = "damage")
    private void init(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        hypnotisecooldown = 100;

        if(this.getWorld() == null || this.getWorld().isClient) {return;}
        Box box = (new Box(this.getBlockPos()).expand(1.25).stretch(0.0, 0.0, 0.0));
        List<LivingEntity> list = this.getWorld().getNonSpectatingEntities(LivingEntity.class, box);
        for (LivingEntity livingEntity  : list) {
            livingEntity.removeStatusEffect(StatusEffects.BLINDNESS);
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,
                    120, 0, false, false));
            livingEntity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.SHIMMER,
                    120, 0, false, true));
        }

    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (itemStack.isOf(Items.GLASS_BOTTLE)) {
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ITEM_BOTTLE_FILL,
                    SoundCategory.PLAYERS, 1.0f, 0.8f * this.getRandom().nextInt(3) * 0.05f);
            this.dropItem(ModBlocks.BIOLUMINESCENT_BOTTLE);
        }
        if (itemStack.isOf(Items.AMETHYST_SHARD)) {
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE,
                    SoundCategory.PLAYERS, 1.0f, 0.8f * this.getRandom().nextInt(3) * 0.05f);
            this.dropItem(ModBlocks.WATER_TORCH.asItem());
        }

        return ActionResult.success(this.getWorld().isClient);
    }

    //Romeo's Code
    @Inject(method = "tickMovement", at = @At("HEAD"))
    private void newMobTick(CallbackInfo ci) {

        if(this.getWorld().getGameRules().getBoolean(ModGameRules.DO_GLOWING_SQUID) == true){
        if(this.getWorld() !=null && !getWorld().isClient){
            if(SquidLightBlockEntity.waterNeedsUpdate(this.getWorld(), this.getBlockPos())){
                this.getWorld().setBlockState(this.getBlockPos(), ModBlocks.WATER_TEMPORARY_LIGHT.getDefaultState().with(WaterTickingBlock.WATERLOGGED, true));
            } else if (!SquidLightBlockEntity.waterNeedsUpdate(this.getWorld(), this.getBlockPos())) {
                this.getWorld().setBlockState(this.getBlockPos(), ModBlocks.WATER_TEMPORARY_LIGHT.getDefaultState().with(WaterTickingBlock.WATERLOGGED, false));
            }
        }
    }
    }

}
