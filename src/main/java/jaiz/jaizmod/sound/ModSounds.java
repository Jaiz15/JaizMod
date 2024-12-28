package jaiz.jaizmod.sound;

import com.google.common.collect.ImmutableList;
import jaiz.jaizmod.JaizMod;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.stream.IntStream;

import static net.minecraft.sound.SoundEvents.GOAT_HORN_SOUNDS;

public class ModSounds {

    public static RegistryKey<JukeboxSong> of(String id) {
        return RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(JaizMod.MOD_ID, id));

    }

    public static final SoundEvent AMETHYST_HORN = registerSoundEvent("amethyst_horn");
    public static final SoundEvent AIR_HORN = registerSoundEvent("air_horn");
    public static final SoundEvent ANCIENT_HORN = registerSoundEvent("ancient_horn");

    public static final SoundEvent SHIELD_DRUM = registerSoundEvent("shield_drum");

    public static final SoundEvent BANDIT_IDLE = registerSoundEvent("bandit_idle");
    public static final SoundEvent BANDIT_DAMAGE = registerSoundEvent("bandit_damage");
    public static final SoundEvent BANDIT_DEATH = registerSoundEvent("bandit_death");
    public static final SoundEvent BANDIT_TRADE = registerSoundEvent("bandit_trade_success");
    public static final SoundEvent BANDIT_TRADE_FAIL = registerSoundEvent("bandit_trade_fail");

    public static void registerSounds() {
        JaizMod.LOGGER.info(("Registering sounds for " + JaizMod.MOD_ID));
        ModSounds.registerReference("origami_hairball");
    }


    private static void registerReference(String name) {
        Identifier ID = Identifier.of(JaizMod.MOD_ID, name);
        Registry.registerReference(Registries.SOUND_EVENT, ID, SoundEvent.of(ID));
    }

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(JaizMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));

    }
}
