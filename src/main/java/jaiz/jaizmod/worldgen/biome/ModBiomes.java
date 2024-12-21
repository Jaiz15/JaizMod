package jaiz.jaizmod.worldgen.biome;


import jaiz.jaizmod.JaizMod;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomes {

    public static final RegistryKey<Biome> MAHOGANY_FOREST = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(JaizMod.MOD_ID, "mahogany_forest"));

    public static final RegistryKey<Biome> FRUIT_BAT_CAVES = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(JaizMod.MOD_ID, "fruit_bat_caves"));
}
