package jaiz.jaizmod.worldgen.tree.decorators;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import jaiz.jaizmod.worldgen.tree.ModTreeDecorator;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.Iterator;
import java.util.List;

public class OakBranchDecorator extends TreeDecorator {

    public static final MapCodec<OakBranchDecorator> CODEC = Codec.floatRange(0.0F, 1.0F)
            .fieldOf("probability")
            .xmap(OakBranchDecorator::new, decorator -> decorator.probability);
    private final float probability;

    public OakBranchDecorator(float probability) {
        this.probability = probability;
    }

    @Override
    public void generate(Generator generator) {
        Random random = generator.getRandom();
        if (!(random.nextFloat() >= this.probability)) {
            List<BlockPos> list = generator.getLogPositions();
            int i = list.getFirst().getY();
            int k = list.getLast().getY();
            list.stream().filter((pos) -> i <= k).forEach((pos)  -> {
                Iterator var3 = Direction.Type.HORIZONTAL.iterator();
                while(var3.hasNext()) {
                    Direction direction = (Direction)var3.next();
                    if (random.nextFloat() <= 0.05F) {
                        Direction direction2 = direction.getOpposite();
                        BlockPos blockPos = pos.add(direction2.getOffsetX(), 3, direction2.getOffsetZ());
                    if (generator.isAir(blockPos) && pos.getY() >= i && pos.getY() <= k - 3) {
                            generator.replace(blockPos, Blocks.OAK_LOG.getDefaultState().with(PillarBlock.AXIS, direction.getAxis()));
                        }
                    }
                }
            });
        }
    }
    protected TreeDecoratorType<?> getType() {return ModTreeDecorator.OAK_BRANCH;}
}


