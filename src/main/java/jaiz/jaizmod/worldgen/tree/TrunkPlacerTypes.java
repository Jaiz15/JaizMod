package jaiz.jaizmod.worldgen.tree;

import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.mixin.TrunkPlacerTypeInvoker;
import jaiz.jaizmod.worldgen.tree.placers.MahoganySmallTrunkPlacer;
import jaiz.jaizmod.worldgen.tree.placers.MahoganyTrunkPlacer;
import net.minecraft.world.gen.structure.StructureType;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class TrunkPlacerTypes {
    public static final TrunkPlacerType<?> MAHOGANY_TRUNK_PLACER =
            TrunkPlacerTypeInvoker.callRegister("mahogany_trunk_placer", MahoganyTrunkPlacer.CODEC);

    public static final TrunkPlacerType<?> SMALL_MAHOGANY_TRUNK_PLACER =
            TrunkPlacerTypeInvoker.callRegister("small_mahogany_trunk_placer", MahoganySmallTrunkPlacer.CODEC);

    public static void register() {
        JaizMod.LOGGER.info("Registering Trunk Placers for " + JaizMod.MOD_ID);
    }

}
