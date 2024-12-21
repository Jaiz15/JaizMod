package jaiz.jaizmod.statuseffects;

import jaiz.jaizmod.JaizMod;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {

    public static RegistryEntry.Reference<StatusEffect> STINKY;
    public static RegistryEntry.Reference<StatusEffect> HYPNO;
    public static RegistryEntry.Reference<StatusEffect> SHIMMER;


    public static RegistryEntry.Reference<StatusEffect> registerStinkyStatusEffect(String name) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(JaizMod.MOD_ID, name),
                new StinkyStatusEffect(StatusEffectCategory.NEUTRAL, 5882118, JaizMod.STINK_PARTICLE).addAttributeModifier(
                        EntityAttributes.GENERIC_MOVEMENT_SPEED, Identifier.of(JaizMod.MOD_ID, "effects/stinky"), -0.25F, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
                ));

    }

    public static RegistryEntry.Reference<StatusEffect> registerHypnoStatusEffect(String name) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(JaizMod.MOD_ID, name),
                new HypnoStatusEffect(StatusEffectCategory.NEUTRAL, 5882118, ParticleTypes.GLOW)
                );
    }

    public static RegistryEntry.Reference<StatusEffect> registerShimmerStatusEffect(String name) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(JaizMod.MOD_ID, name),
                new ShimmerStatusEffect(StatusEffectCategory.NEUTRAL, 5882118, ParticleTypes.GLOW)
        );
    }


    public static void registerModEffects() {
        STINKY = registerStinkyStatusEffect("stinky");
        SHIMMER = registerShimmerStatusEffect("shimmer");
        HYPNO = registerHypnoStatusEffect("hypno");
        JaizMod.LOGGER.info("Registering Mod Effects for " + JaizMod.MOD_ID);
    }
}
