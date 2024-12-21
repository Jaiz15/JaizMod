package jaiz.jaizmod.worldgen.tree.decorators;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.block.custom.ShelfMushroomBlock;
import jaiz.jaizmod.worldgen.tree.ModTreeDecorator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.Iterator;
import java.util.List;

public class MushroomDecorator extends TreeDecorator {

    public static final MapCodec<MushroomDecorator> CODEC = Codec.floatRange(0.00F, 1.00F)
            .fieldOf("probability")
            .xmap(MushroomDecorator::new, decorator -> decorator.probability);

    private final float probability;

    public MushroomDecorator(float probability){
        this.probability = probability;
    }


    protected TreeDecoratorType<?> getType() {return ModTreeDecorator.SHROOMS;}

    @Override
    public void generate(Generator generator) {
        Random random = generator.getRandom();
        if (!(random.nextFloat() >= this.probability)) {
            List<BlockPos> list = generator.getLogPositions();
            int i = list.getFirst().getY();
            int k = list.getLast().getY();
            list.stream().filter((pos) -> i <= k).forEach((pos) -> {
                Iterator var3 = Direction.Type.HORIZONTAL.iterator();
                while(var3.hasNext()) {
                    Direction direction = (Direction)var3.next();
                    if (random.nextFloat() <= 0.05F) {
                        Direction direction2 = direction.getOpposite();
                        BlockPos blockPos = pos.add(direction2.getOffsetX(), 1, direction2.getOffsetZ());
                        if (generator.isAir(blockPos)  && pos.getY() >= i && pos.getY() <= k - 1) {
                            //HERES THE BLOCK FUTURE ME
                            generator.replace(blockPos, ModBlocks.SHELF_MUSHROOM_BLOCK.getDefaultState()
                                    .with(ShelfMushroomBlock.SIZE, random.nextInt(3))
                                    .with(ShelfMushroomBlock.FACING, direction.getOpposite()));
                        }
                    }
                }
            });
        }
    }
}



