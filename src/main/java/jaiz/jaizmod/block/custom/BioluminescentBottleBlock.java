package jaiz.jaizmod.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.LanternBlock;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class BioluminescentBottleBlock extends LanternBlock {

    public BioluminescentBottleBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);
        if (random.nextInt(2) == 0) {
            ParticleUtil.spawnParticle(world, pos, random, ParticleTypes.GLOW);
        }
    }

}
