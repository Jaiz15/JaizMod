package jaiz.jaizmod.villager;

import com.google.common.collect.ImmutableSet;
import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {

    public static final RegistryKey<PointOfInterestType> TEA_POI_KEY = poiKey("teapoi");
    public static final PointOfInterestType TEA_POI = registerPoi("teapoi", ModBlocks.TEAPOTBLOCK);
    public static final VillagerProfession TEA_BREWER = registerTeaProfession("tea_brewer", TEA_POI_KEY);

    public static final RegistryKey<PointOfInterestType> SPICE_POI_KEY = poiKey("spicepoi");
    public static final PointOfInterestType SPICE_POI = registerPoi("spicepoi", ModBlocks.SPICE_BARREL);
    public static final VillagerProfession SPICE_TRADER = registerSpiceProfession("spice_trader", SPICE_POI_KEY);

    private static VillagerProfession registerSpiceProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(JaizMod.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_FISHERMAN));
    }

    private static VillagerProfession registerTeaProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(JaizMod.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_CLERIC));
    }

    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(Identifier.of(JaizMod.MOD_ID, name), 1, 1, block);
    }

    public static RegistryKey<PointOfInterestType>  poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(JaizMod.MOD_ID, name));
    }

    public static void registerVillagers() {
        JaizMod.LOGGER.info("Registering Villagers " + JaizMod.MOD_ID);

    }
}
