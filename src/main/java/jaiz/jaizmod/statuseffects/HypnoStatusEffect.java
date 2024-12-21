package jaiz.jaizmod.statuseffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

public class HypnoStatusEffect extends StatusEffect {
    protected HypnoStatusEffect(StatusEffectCategory statusEffectCategory, int i, ParticleEffect particleEffect) {
        super(statusEffectCategory, i, particleEffect);}

    public int hypnoIntensity = 0;
    public static float hypnopulse;
    public int hypnopulseInt;

        @Override
        public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
            entity.setSwimming(false);

                hypnoIntensity++;
                if (hypnoIntensity == 0) {
                    hypnopulseInt = 0;
                }
                if (hypnoIntensity <= 50) {
                    hypnopulseInt++;
                }
                if (hypnoIntensity > 50) {
                    hypnopulseInt--;
                }
                if (hypnoIntensity >= 100) {
                    hypnoIntensity = 0;
                }


                hypnopulse = hypnopulseInt * 0.01f;

            return true;
        }

    @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return true;
        }

}
