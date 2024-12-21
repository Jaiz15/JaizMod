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
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class MahoganyTrunkPlacer extends GiantTrunkPlacer {
    public static final MapCodec<MahoganyTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(objectInstance ->
            fillTrunkPlacerFields(objectInstance).apply(objectInstance, MahoganyTrunkPlacer::new));


    public MahoganyTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return TrunkPlacerTypes.MAHOGANY_TRUNK_PLACER;
    }


    public List<FoliagePlacer.TreeNode> generate(
            TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config
    ) {
        List<FoliagePlacer.TreeNode> list = Lists.<FoliagePlacer.TreeNode>newArrayList();
        list.addAll(super.generate(world, replacer, random, height, startPos, config));

        for (int i = height - 5; i < height - 3; i++) {

            //north1
            if(random.nextInt(4) == 1) {
                int z = random.nextInt(3);
                if(z == 3){
                for(int x = 0; x < 3; x++) {
                    replacer.accept(startPos.up(i).offset(Direction.NORTH, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                            .get(random, startPos.up(i).offset(Direction.NORTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                    for(int x2 = 1; x2 < 4; x2++) {
                        replacer.accept(startPos.up(i).offset(Direction.NORTH, 3).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.NORTH, 3).offset(Direction.UP, 5), -3, false));}
                else if (z == 2){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.NORTH, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.NORTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.NORTH, 2).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.NORTH, 2).offset(Direction.UP, 5), -3, false));}
                else if (z == 1){
                    for(int x = 0; x < 4; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.NORTH, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.NORTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.NORTH, 4).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.NORTH, 4).offset(Direction.UP, 5), -3, false));}
                else if (z == 0){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.NORTH, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.NORTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                        replacer.accept(startPos.up(i).offset(Direction.NORTH, 3).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.NORTH, 3).offset(Direction.UP, 5), -3, false));}
            }

            //north2
            if(random.nextInt(4) == 1) {
                int z = random.nextInt(3);
                if(z == 3){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.NORTH, x + 1).offset(Direction.EAST, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.NORTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.NORTH, 3).offset(Direction.EAST, 1).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.NORTH, 3).offset(Direction.UP, 5), -3, false));}
                else if (z == 2){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.NORTH, x + 1).offset(Direction.EAST, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.NORTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.NORTH, 2).offset(Direction.EAST, 1).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.NORTH, 2).offset(Direction.UP, 5), -3, false));}
                else if (z == 1){
                    for(int x = 0; x < 4; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.NORTH, x + 1).offset(Direction.EAST, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.NORTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.NORTH, 4).offset(Direction.EAST, 1).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.NORTH, 4).offset(Direction.UP, 5), -3, false));}
                else if (z == 0){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.NORTH, x + 1).offset(Direction.EAST, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.NORTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.NORTH, 3).offset(Direction.EAST, 1).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.NORTH, 3).offset(Direction.UP, 5), -3, false));}
            }



            //south1
            if(random.nextInt(4) == 1) {
                int z = random.nextInt(3);
                if(z == 3){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.SOUTH, x+ 2), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.SOUTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.SOUTH, 4).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.SOUTH, 4).offset(Direction.UP, 5), -3, false));}
                else if (z == 2){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.SOUTH, x+ 2), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.SOUTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.SOUTH, 3).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.SOUTH, 3).offset(Direction.UP, 5), -3, false));}
                else if (z == 1){
                    for(int x = 0; x < 4; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.SOUTH, x+ 2), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.SOUTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.SOUTH, 5).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.SOUTH, 5).offset(Direction.UP, 5), -3, false));}
                else if (z == 0){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.SOUTH, x+ 2), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.SOUTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.SOUTH, 4).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.SOUTH, 4).offset(Direction.UP, 5), -3, false));}
            }

            //south2
            if(random.nextInt(4) == 1) {
                int z = random.nextInt(3);
                if(z == 3){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.SOUTH, x + 2).offset(Direction.EAST, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.SOUTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.SOUTH, 4).offset(Direction.EAST, 1).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.SOUTH, 4).offset(Direction.UP, 5), -3, false));}
                else if (z == 2){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.SOUTH, x + 2).offset(Direction.EAST, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.SOUTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.SOUTH, 3).offset(Direction.EAST, 1).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.SOUTH, 3).offset(Direction.UP, 5), -3, false));}
                else if (z == 1){
                    for(int x = 0; x < 4; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.SOUTH, x+ 2).offset(Direction.EAST, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.SOUTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.SOUTH, 5).offset(Direction.EAST, 1).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.SOUTH, 5).offset(Direction.UP, 5), -3, false));}
                else if (z == 0){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.SOUTH, x+ 2).offset(Direction.EAST, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.SOUTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.SOUTH, 4).offset(Direction.EAST, 1).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.SOUTH, 4).offset(Direction.UP, 5), -3, false));}
            }

            //east
            if(random.nextInt(4) == 1) {
                int z = random.nextInt(3);
                if(z == 3){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.EAST, x + 2), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.EAST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.EAST, 4).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.EAST, 4).offset(Direction.UP, 5), -3, false));}
                else if (z == 2){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.EAST, x + 2), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.EAST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.EAST, 3).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.EAST, 3).offset(Direction.UP, 5), -3, false));}
                else if (z == 1){
                    for(int x = 0; x < 4; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.EAST, x + 2), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.EAST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.EAST, 5).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.EAST, 5).offset(Direction.UP, 5), -3, false));}
                else if (z == 0){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.EAST, x + 2), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.EAST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.EAST, 4).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.EAST, 4).offset(Direction.UP, 5), -3, false));}
            }

            //east2
            if(random.nextInt(4) == 1) {
                int z = random.nextInt(3);
                if(z == 3){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.EAST, x + 2).offset(Direction.SOUTH, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.EAST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.EAST, 4).offset(Direction.SOUTH, 1).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.EAST, 4).offset(Direction.UP, 5), -3, false));}
                else if (z == 2){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.EAST, x + 2).offset(Direction.SOUTH, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.EAST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.EAST, 3).offset(Direction.SOUTH, 1).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.EAST, 3).offset(Direction.UP, 5), -3, false));}
                else if (z == 1){
                    for(int x = 0; x < 4; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.EAST, x + 2).offset(Direction.SOUTH, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.EAST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.EAST, 5).offset(Direction.SOUTH, 1).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.EAST, 5).offset(Direction.UP, 5), -3, false));}
                else if (z == 0){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.EAST, x + 2).offset(Direction.SOUTH, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.EAST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.EAST, 4).offset(Direction.SOUTH, 1).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.EAST, 4).offset(Direction.UP, 5), -3, false));}
            }



            //west
            if(random.nextInt(4) == 1) {
                int z = random.nextInt(3);
                if(z == 3){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.WEST, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.WEST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.WEST, 3).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.WEST, 3).offset(Direction.UP, 5), -3, false));}
                else if (z == 2){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.WEST, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.WEST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.WEST, 2).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.WEST, 2).offset(Direction.UP, 5), -3, false));}
                else if (z == 1){
                    for(int x = 0; x < 4; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.WEST, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.WEST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.WEST, 4).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.WEST, 4).offset(Direction.UP, 5), -3, false));}
                else if (z == 0){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.WEST, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.WEST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.WEST, 3).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.WEST, 3).offset(Direction.UP, 5), -3, false));}
            }

            //west2
            if(random.nextInt(4) == 1) {
                int z = random.nextInt(3);
                if(z == 3){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.WEST, x + 1).offset(Direction.SOUTH, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.WEST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.WEST, 3).offset(Direction.SOUTH, 1).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.WEST, 3).offset(Direction.UP, 5), -3, false));}
                else if (z == 2){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.WEST, x + 1).offset(Direction.SOUTH, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.WEST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.WEST, 2).offset(Direction.SOUTH, 1).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.WEST, 2).offset(Direction.UP, 5), -3, false));}
                else if (z == 1){
                    for(int x = 0; x < 4; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.WEST, x + 1).offset(Direction.SOUTH, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.WEST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.WEST, 4).offset(Direction.SOUTH, 1).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.WEST, 4).offset(Direction.UP, 5), -3, false));}
                else if (z == 0){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.WEST, x + 1).offset(Direction.SOUTH, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.WEST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.up(i).offset(Direction.WEST, 3).offset(Direction.SOUTH, 1).offset(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .get(random, startPos.up(i).offset(Direction.UP, x2)).with(PillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.WEST, 3).offset(Direction.UP, 5), -3, false));}
            }

        }
        return list;
    }

}