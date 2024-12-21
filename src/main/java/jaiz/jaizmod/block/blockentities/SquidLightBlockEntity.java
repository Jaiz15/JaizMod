package jaiz.jaizmod.block.blockentities;

import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.block.blockentities.CustomBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.passive.GlowSquidEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

public class SquidLightBlockEntity extends BlockEntity implements TickableBlockEntity {

    public SquidLightBlockEntity(BlockPos pos, BlockState state) {
        super(CustomBlockEntities.SQUID_LIGHT_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void tick() {
        if (this.world == null || this.world.isClient) {
            return;
        }

        if(this.getWorld() !=null && !getWorld().isClient){

            boolean glowSquidNearby = false;
            for (GlowSquidEntity glowSquid : world.getNonSpectatingEntities(GlowSquidEntity.class, new Box(pos).expand(2.0))) {
                if (glowSquid.squaredDistanceTo(pos.getX(), pos.getY(), pos.getZ()) <= 9) {
                    glowSquidNearby = true;
                    if (waterNeedsUpdate(glowSquid.getWorld(), glowSquid.getBlockPos())) {
                        world.setBlockState(glowSquid.getBlockPos(), ModBlocks.WATER_TEMPORARY_LIGHT.getDefaultState().with(WaterTickingBlock.WATERLOGGED, true));
                    } else if(!waterNeedsUpdate(glowSquid.getWorld(), glowSquid.getBlockPos())) {
                        world.setBlockState(glowSquid.getBlockPos(), ModBlocks.WATER_TEMPORARY_LIGHT.getDefaultState().with(WaterTickingBlock.WATERLOGGED, false));
                    }
                }
            }

            if (!glowSquidNearby && waterNeedsUpdate(world, pos)) {
                world.setBlockState(pos, Blocks.WATER.getDefaultState());
            } else if (!glowSquidNearby && !waterNeedsUpdate(world, pos)) {
                world.setBlockState(pos, Blocks.AIR.getDefaultState());
            }

        }

    }

    public static boolean waterNeedsUpdate(World world, BlockPos pos) {
        int waterCount = 0;
        BlockPos[] directions = {pos.up(), pos.north(), pos.east(), pos.south(), pos.west(), pos.down()};
        for (BlockPos direction : directions) {
            BlockState state = world.getBlockState(direction);
            if (state.isOf(Blocks.WATER)) {
                waterCount++;
            } else if (state.isOf(ModBlocks.WATER_TEMPORARY_LIGHT)) {
                if (state.get(WaterTickingBlock.WATERLOGGED)) {
                    waterCount++;
                }
            }
        }
        return waterCount >= 2;
    }




}


