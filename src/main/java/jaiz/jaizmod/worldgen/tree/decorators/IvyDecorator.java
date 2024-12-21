package jaiz.jaizmod.worldgen.tree.decorators;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.block.custom.IvyBlock;
import jaiz.jaizmod.worldgen.tree.ModTreeDecorator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class IvyDecorator extends TreeDecorator {

    public static final MapCodec<IvyDecorator> CODEC = Codec.floatRange(0.00F, 1.00F)
            .fieldOf("probability")
            .xmap(IvyDecorator::new, decorator -> decorator.probability);

    private final float probability;

    public IvyDecorator(float probability){
        this.probability = probability;
    }

    protected TreeDecoratorType<?> getType() {return ModTreeDecorator.IVY;}

    @Override
    public void generate(Generator generator) {
        Random random = generator.getRandom();
        if (!(random.nextFloat() >= this.probability)) {
            generator.getLogPositions().forEach(pos -> {
                BlockPos blockPos;
                if (random.nextInt(3) > 0 && generator.isAir(blockPos = pos.west())) {
                    generator.replace(blockPos, ModBlocks.IVY.getDefaultState().with(IvyBlock.EAST, true));
                }
                if (random.nextInt(3) > 0 && generator.isAir(blockPos = pos.east())) {
                    generator.replace(blockPos, ModBlocks.IVY.getDefaultState().with(IvyBlock.WEST, true));
                }
                if (random.nextInt(3) > 0 && generator.isAir(blockPos = pos.north())) {
                    generator.replace(blockPos, ModBlocks.IVY.getDefaultState().with(IvyBlock.SOUTH, true));
                }
                if (random.nextInt(3) > 0 && generator.isAir(blockPos = pos.south())) {
                    generator.replace(blockPos, ModBlocks.IVY.getDefaultState().with(IvyBlock.NORTH, true));
                }
            });
        }
    }
}

