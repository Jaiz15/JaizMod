package jaiz.jaizmod.worldgen.structure;

import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.mixin.StructurePlacerTypeInvoker;
import jaiz.jaizmod.worldgen.structure.placers.JaizJungleTempleStructurePlacer;
import net.minecraft.world.gen.structure.StructureType;

public class StructurePlacerTypes {

    public static final StructureType<JaizJungleTempleStructurePlacer> JAIZ_JUNGLE_TEMPLE_STRUCTURE_PLACER =
            StructurePlacerTypeInvoker.callRegister("jaiz_jungle_temple_structure_placer", JaizJungleTempleStructurePlacer.CODEC);

    public static void register() {
        JaizMod.LOGGER.info("Registering Structure Placers for " + JaizMod.MOD_ID);
    }

}
