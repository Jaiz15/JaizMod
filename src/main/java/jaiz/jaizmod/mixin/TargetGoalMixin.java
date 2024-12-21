package jaiz.jaizmod.mixin;

import jaiz.jaizmod.statuseffects.ModStatusEffects;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.TrackTargetGoal;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ActiveTargetGoal.class)
public abstract class TargetGoalMixin extends TrackTargetGoal {

    public TargetGoalMixin(MobEntity mob, boolean checkVisibility) {
        super(mob, checkVisibility);
    }

    public void tick() {
        if (!(this.mob.getTarget() == null) && this.mob.getTarget().hasStatusEffect(ModStatusEffects.STINKY)) {
            this.stop();
        }
    }


}
