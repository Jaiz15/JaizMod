package jaiz.jaizmod.block.custom;

import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class TeaPotBlock extends Block {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final BooleanProperty HAS_CUP = ModBlocks.HAS_CUP;

    public static final VoxelShape BOTTOM_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 4.0, 16.0);
    public static final VoxelShape MIDDLE_SHAPE = Block.createCuboidShape(5.0, 4.0, 5.0, 11.0, 12.0, 11.0);
    public static final VoxelShape BASE_SHAPE = VoxelShapes.union(BOTTOM_SHAPE, MIDDLE_SHAPE);

    public TeaPotBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(WATERLOGGED, false).with(FACING, Direction.NORTH).with(HAS_CUP, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BASE_SHAPE;
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        BlockState blockState = this.getDefaultState();
        WorldView worldView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        Direction[] directions = ctx.getPlacementDirections();

        for (Direction direction : directions) {
            if (direction.getAxis().isHorizontal()) {
                Direction direction2 = direction.getOpposite();
                blockState = blockState.with(FACING, direction2)
                        .with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);;
                if (blockState.canPlaceAt(worldView, blockPos)) {
                    return blockState;
                }
            }
        }

        return null;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }


    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double d = (double)pos.getX() + 0.5;
        double e = (double)pos.getY() + 0.2;
        double f = (double)pos.getZ() + 0.5;


        world.addParticle(ParticleTypes.FLAME, d, e, f, 0.0, 0.0, 0.0);

        if(state.get(FACING) == Direction.NORTH){
            world.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.5, pos.getY() + 0.7, pos.getZ() + 0.1, 0.0, 0.0, 0.0);
        }
        else if(state.get(FACING) == Direction.SOUTH){
            world.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.5, pos.getY() + 0.7, pos.getZ() + 0.9, 0.0, 0.0, 0.0);
        }
        else if(state.get(FACING) == Direction.WEST){
            world.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.1, pos.getY() + 0.7, pos.getZ() + 0.5, 0.0, 0.0, 0.0);
        }
        else if(state.get(FACING) == Direction.EAST){
            world.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.9, pos.getY() + 0.7, pos.getZ() + 0.5, 0.0, 0.0, 0.0);
        }

    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockState blockStatetrue = state.with(HAS_CUP, true);
        BlockState blockStatefalse = state.with(HAS_CUP, false);

        if ((stack.isOf(ModItems.TEA_CUP) && !state.get(HAS_CUP))) {
            world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, SoundEvents.BLOCK_STONE_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            stack.decrementUnlessCreative(1, player);
            world.setBlockState(pos, blockStatetrue, Block.NOTIFY_ALL);
            return ItemActionResult.success(world.isClient);
        }
        else if(state.get(HAS_CUP)){
            if((stack.isOf(Items.CHORUS_FRUIT))){
                world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5,
                        (double)pos.getZ() + 0.5, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                if (!player.getAbilities().creativeMode) {stack.decrement(1);}
                TeaPotBlock.dropStack(world, pos, new ItemStack(ModItems.CHORUS_FRUIT_TEA));
                world.setBlockState(pos, blockStatefalse, Block.NOTIFY_ALL);
                return ItemActionResult.success(world.isClient);
            }

            else if((stack.isOf(Items.BOOK))){
                world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5,
                        (double)pos.getZ() + 0.5, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                if (!player.getAbilities().creativeMode) {stack.decrement(1);}
                TeaPotBlock.dropStack(world, pos, new ItemStack(ModItems.NOVEL_TEA));
                world.setBlockState(pos, blockStatefalse, Block.NOTIFY_ALL);
                return ItemActionResult.success(world.isClient);
            }

            else if((stack.isOf(Items.PITCHER_PLANT))){
                world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5,
                        (double)pos.getZ() + 0.5, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                if (!player.getAbilities().creativeMode) {stack.decrement(1);}
                TeaPotBlock.dropStack(world, pos, new ItemStack(ModItems.PITCHER_PLANT_TEA));
                world.setBlockState(pos, blockStatefalse, Block.NOTIFY_ALL);
                return ItemActionResult.success(world.isClient);
            }

            else if((stack.isOf(Items.TORCHFLOWER))){
                world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5,
                        (double)pos.getZ() + 0.5, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                if (!player.getAbilities().creativeMode) {stack.decrement(1);}
                TeaPotBlock.dropStack(world, pos, new ItemStack(ModItems.TORCH_FLOWER_TEA));
                world.setBlockState(pos, blockStatefalse, Block.NOTIFY_ALL);
                return ItemActionResult.success(world.isClient);
            }

            else if((stack.isOf(Items.BROWN_MUSHROOM) || stack.isOf(Items.RED_MUSHROOM) || stack.isOf(Items.FERN))){
                world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5,
                        (double)pos.getZ() + 0.5, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                if (!player.getAbilities().creativeMode) {stack.decrement(1);}
                TeaPotBlock.dropStack(world, pos, new ItemStack(ModItems.HERBAL_TEA));
                world.setBlockState(pos, blockStatefalse, Block.NOTIFY_ALL);
                return ItemActionResult.success(world.isClient);
            }

            else if((stack.isOf(Items.GLOW_BERRIES))){
                world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5,
                        (double)pos.getZ() + 0.5, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                if (!player.getAbilities().creativeMode) {stack.decrement(1);}
                TeaPotBlock.dropStack(world, pos, new ItemStack(ModItems.GLOW_BERRY_TEA));
                world.setBlockState(pos, blockStatefalse, Block.NOTIFY_ALL);
                return ItemActionResult.success(world.isClient);
            }
            else if((stack.isOf(Items.GUNPOWDER))){
                world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5,
                        (double)pos.getZ() + 0.5, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                if (!player.getAbilities().creativeMode) {stack.decrement(1);}
                TeaPotBlock.dropStack(world, pos, new ItemStack(ModItems.GUNPOWDER_GREEN_TEA));
                world.setBlockState(pos, blockStatefalse, Block.NOTIFY_ALL);
                return ItemActionResult.success(world.isClient);
            }
            else if((stack.isOf(Items.WHEAT))){
                world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5,
                        (double)pos.getZ() + 0.5, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                if (!player.getAbilities().creativeMode) {stack.decrement(1);}
                TeaPotBlock.dropStack(world, pos, new ItemStack(ModItems.KOMBUCHA_TEA));
                world.setBlockState(pos, blockStatefalse, Block.NOTIFY_ALL);
                return ItemActionResult.success(world.isClient);
            }
            else if((stack.isOf(Items.CRIMSON_FUNGUS))){
                world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5,
                        (double)pos.getZ() + 0.5, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                if (!player.getAbilities().creativeMode) {stack.decrement(1);}
                TeaPotBlock.dropStack(world, pos, new ItemStack(ModItems.NETHER_FUNGUS_TEA));
                world.setBlockState(pos, blockStatefalse, Block.NOTIFY_ALL);
                return ItemActionResult.success(world.isClient);
            }
            else if((stack.isOf(Items.WARPED_FUNGUS))){
                world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5,
                        (double)pos.getZ() + 0.5, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                if (!player.getAbilities().creativeMode) {stack.decrement(1);}
                TeaPotBlock.dropStack(world, pos, new ItemStack(ModItems.WARPED_NETHER_FUNGUS_TEA));
                world.setBlockState(pos, blockStatefalse, Block.NOTIFY_ALL);
                return ItemActionResult.success(world.isClient);
            }
            else if((stack.isOf(Items.PUMPKIN))){
                world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5,
                        (double)pos.getZ() + 0.5, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                if (!player.getAbilities().creativeMode) {stack.decrement(1);}
                TeaPotBlock.dropStack(world, pos, new ItemStack(ModItems.PUMPKIN_SPICE_TEA));
                world.setBlockState(pos, blockStatefalse, Block.NOTIFY_ALL);
                return ItemActionResult.success(world.isClient);
            }
            else if((stack.isOf(Items.SPORE_BLOSSOM))){
                world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5,
                        (double)pos.getZ() + 0.5, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                if (!player.getAbilities().creativeMode) {stack.decrement(1);}
                TeaPotBlock.dropStack(world, pos, new ItemStack(ModItems.SPORE_BLOSSOM_TEA));
                world.setBlockState(pos, blockStatefalse, Block.NOTIFY_ALL);
                return ItemActionResult.success(world.isClient);
            }
            else if((stack.isOf(Items.WITHER_ROSE))){
                world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5,
                        (double)pos.getZ() + 0.5, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                if (!player.getAbilities().creativeMode) {stack.decrement(1);}
                TeaPotBlock.dropStack(world, pos, new ItemStack(ModItems.WITHER_ROSE_TEA));
                world.setBlockState(pos, blockStatefalse, Block.NOTIFY_ALL);
                return ItemActionResult.success(world.isClient);
            }
            else if((stack.isIn(ItemTags.FLOWERS))){
                world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5,
                        (double)pos.getZ() + 0.5, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                if (!player.getAbilities().creativeMode) {stack.decrement(1);}
                TeaPotBlock.dropStack(world, pos, new ItemStack(ModItems.FLOWER_TEA));
                world.setBlockState(pos, blockStatefalse, Block.NOTIFY_ALL);
                return ItemActionResult.success(world.isClient);
            }
        }

        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING, HAS_CUP);
    }
    
}
