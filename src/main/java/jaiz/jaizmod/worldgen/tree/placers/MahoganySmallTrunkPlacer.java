package jaiz.jaizmod.worldgen.tree.placers;

import com.google.common.collect.Lists;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jaiz.jaizmod.worldgen.tree.TrunkPlacerTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class MahoganySmallTrunkPlacer extends StraightTrunkPlacer {
    public static final MapCodec<MahoganySmallTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(objectInstance ->
            fillTrunkPlacerFields(objectInstance).apply(objectInstance, MahoganySmallTrunkPlacer::new));


    public MahoganySmallTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return TrunkPlacerTypes.SMALL_MAHOGANY_TRUNK_PLACER;
    }

    public List<FoliagePlacer.TreeNode> generate(
            TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config
    ) {
        List<FoliagePlacer.TreeNode> list = Lists.<FoliagePlacer.TreeNode>newArrayList();
        list.addAll(super.generate(world, replacer, random, height, startPos, config));

        for (int i = height - 4; i < height - 2; i++) {

            //north
            if(random.nextInt(7) == 1) {
                int z = random.nextInt(3);
                if(z <= 1){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.up(i-1).offset(Direction.NORTH, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.NORTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 2; x2++) {
                            replacer.accept(startPos.up(i-1).offset(Direction.NORTH, 2).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.NORTH, 2).offset(Direction.UP, 2), -4, false));}
                else{
                    for(int x = 0; x < 1; x++) {
                        replacer.accept(startPos.up(i + 1).offset(Direction.NORTH, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.NORTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                    }
                }
            }

            //south
            if(random.nextInt(7) == 1) {
                int z = random.nextInt(3);
                if(z <= 1){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.up(i-1).offset(Direction.SOUTH, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.SOUTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 2; x2++) {
                            replacer.accept(startPos.up(i-1).offset(Direction.SOUTH, 2).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.SOUTH, 2).offset(Direction.UP, 2), -4, false));}
                else{
                    for(int x = 0; x < 1; x++) {
                        replacer.accept(startPos.up(i + 1).offset(Direction.SOUTH, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.SOUTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                    }
                }
            }

            //east
            if(random.nextInt(7) == 1) {
                int z = random.nextInt(3);
                if(z <= 1){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.up(i-1).offset(Direction.EAST, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.EAST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 2; x2++) {
                            replacer.accept(startPos.up(i-1).offset(Direction.EAST, 2).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.EAST, 2).offset(Direction.UP, 2), -4, false));}
                else{
                    for(int x = 0; x < 1; x++) {
                        replacer.accept(startPos.up(i + 1).offset(Direction.EAST, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.EAST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                    }
                }
            }

            //west
            if(random.nextInt(7) == 1) {
                int z = random.nextInt(3);
                if(z <= 1){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.up(i-1).offset(Direction.WEST, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.WEST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 2; x2++) {
                            replacer.accept(startPos.up(i-1).offset(Direction.WEST, 2).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.WEST, 2).offset(Direction.UP, 2), -4, false));}
                else{
                    for(int x = 0; x < 1; x++) {
                        replacer.accept(startPos.up(i + 1).offset(Direction.WEST, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.WEST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                    }
                }
            }

        }
        return list;
    }

}