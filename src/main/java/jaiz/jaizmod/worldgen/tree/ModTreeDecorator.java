package jaiz.jaizmod.worldgen.tree;


import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.mixin.TreeDecoratorTypeMixin;
import jaiz.jaizmod.worldgen.tree.decorators.*;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class ModTreeDecorator {

    public static final TreeDecoratorType<?> SHROOMS = TreeDecoratorTypeMixin.callRegister("shrooms",
            MushroomDecorator.CODEC);

    public static final TreeDecoratorType<?> IVY =
            TreeDecoratorTypeMixin.callRegister("ivy", IvyDecorator.CODEC);

    public static final TreeDecoratorType<?> BIRCH_BRANCH =
            TreeDecoratorTypeMixin.callRegister("birch_branch", BirchBranchDecorator.CODEC);

    public static final TreeDecoratorType<?> OAK_BRANCH =
            TreeDecoratorTypeMixin.callRegister("oak_branch", OakBranchDecorator.CODEC);

    public static void register() {
        JaizMod.LOGGER.info("Registering the Tree Decorator for " + JaizMod.MOD_ID);
    }

}
