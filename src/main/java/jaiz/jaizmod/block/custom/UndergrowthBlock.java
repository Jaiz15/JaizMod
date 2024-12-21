package jaiz.jaizmod.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.CarpetBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class UndergrowthBlock extends CarpetBlock {

    public UndergrowthBlock(Settings settings) {
        super(settings);
    }


    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isFullCube(world, pos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        return this.canPlantOnTop(world.getBlockState(blockPos), world, blockPos);
    }




}
