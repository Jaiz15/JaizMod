package jaiz.jaizmod.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.GlowSquidEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(SquidEntity.class)
public abstract class SquidMixin extends WaterCreatureEntity {

    public SquidMixin(EntityType<? extends SquidEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("HEAD"), method = "damage")
    private void init(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if(this.getWorld() == null || this.getWorld().isClient) {return;}
        Box box = (new Box(this.getBlockPos()).expand(1.25).stretch(0.0, 0.0, 0.0));
        List<LivingEntity> list = this.getWorld().getNonSpectatingEntities(LivingEntity.class, box);
        for (LivingEntity livingEntity  : list) {
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS,
                    120, 0, false, false));
        }
    }

}
