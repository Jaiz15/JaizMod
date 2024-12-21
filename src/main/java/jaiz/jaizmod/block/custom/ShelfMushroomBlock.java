package jaiz.jaizmod.block.custom;

import jaiz.jaizmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class ShelfMushroomBlock extends Block{

    public static final IntProperty SIZE = ModBlocks.SIZE;

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    private static final VoxelShape NORTH_LARGE_SHELF = Block.createCuboidShape(1, 13, 3, 15, 16, 16);
    private static final VoxelShape NORTH_MEDIUM_SHELVES = VoxelShapes.combineAndSimplify(Block.createCuboidShape(5, 9, 9, 13, 11, 16), Block.createCuboidShape(1, 5, 5, 14, 7, 16), BooleanBiFunction.OR);
    private static final VoxelShape NORTH_SMALL_SHELVES = Stream.of(
            Block.createCuboidShape(10, 4, 11, 15, 5, 16),
            Block.createCuboidShape(6, 10, 9, 13, 11, 16),
            Block.createCuboidShape(0, 7, 7, 10, 8, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SOUTH_LARGE_SHELF = Block.createCuboidShape(1, 13, 0, 15, 16, 13);
    private static final VoxelShape SOUTH_MEDIUM_SHELVES = VoxelShapes.combineAndSimplify(Block.createCuboidShape(3, 9, 0, 11, 11, 7), Block.createCuboidShape(2, 5, 0, 15, 7, 11), BooleanBiFunction.OR);
    private static final VoxelShape SOUTH_SMALL_SHELVES = Stream.of(
            Block.createCuboidShape(1, 4, 0, 6, 5, 5),
            Block.createCuboidShape(3, 10, 0, 10, 11, 7),
            Block.createCuboidShape(6, 7, 0, 16, 8, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    private static final VoxelShape WEST_LARGE_SHELF = Block.createCuboidShape(3, 13, 1, 16, 16, 15);
    private static final VoxelShape EAST_MEDIUM_SHELVES = VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 9, 5, 7, 11, 13), Block.createCuboidShape(0, 5, 1, 11, 7, 14), BooleanBiFunction.OR);
    private static final VoxelShape EAST_SMALL_SHELVES = Stream.of(
            Block.createCuboidShape(0, 4, 10, 5, 5, 15),
            Block.createCuboidShape(0, 10, 6, 7, 11, 13),
            Block.createCuboidShape(0, 7, 0, 9, 8, 10)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    private static final VoxelShape EAST_LARGE_SHELF = Block.createCuboidShape(0, 13, 1, 13, 16, 15);
    private static final VoxelShape WEST_MEDIUM_SHELVES = VoxelShapes.combineAndSimplify(Block.createCuboidShape(9, 9, 3, 16, 11, 11), Block.createCuboidShape(5, 5, 2, 16, 7, 15), BooleanBiFunction.OR);
    private static final VoxelShape WEST_SMALL_SHELVES = Stream.of(
            Block.createCuboidShape(11, 4, 1, 16, 5, 6),
            Block.createCuboidShape(9, 10, 3, 16, 11, 10),
            Block.createCuboidShape(7, 7, 6, 16, 8, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();



    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public ShelfMushroomBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(SIZE, 2).with(FACING, Direction.NORTH).with(WATERLOGGED, false));
    }


    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState;
        if (!ctx.canReplaceExisting() && (blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(ctx.getSide().getOpposite()))).isOf(this) && blockState.get(FACING) == ctx.getSide()) {
            return null;
        }
        blockState = this.getDefaultState();
        World worldView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        for (Direction direction : ctx.getPlacementDirections()) {
            if (!direction.getAxis().isHorizontal() || !(blockState = (BlockState)blockState.with(FACING, direction.getOpposite())).canPlaceAt(worldView, blockPos)) continue;
            return (BlockState)blockState.with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
        }
        return null;
    }


    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (direction.getOpposite() == state.get(FACING) && !state.canPlaceAt(world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        if (state.get(WATERLOGGED).booleanValue()) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }



    private boolean canPlaceOn(BlockView world, BlockPos pos, Direction side) {
        BlockState blockState = world.getBlockState(pos);
        return blockState.isSideSolidFullSquare(world, pos, side);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = state.get(FACING);
        return this.canPlaceOn(world, pos.offset(direction.getOpposite()), direction);
    }


    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }


    private static boolean shearItem(ItemStack stack) {
        return stack.isOf(Items.SHEARS);
    }

    private static boolean growItem(ItemStack stack) {
        return stack.isOf(Items.BONE_MEAL);
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (ShelfMushroomBlock.shearItem(itemStack) && ShelfMushroomBlock.shearable(state)) {
            ShelfMushroomBlock.shear(player, world, pos, state);
            if (!player.getAbilities().creativeMode) {
                stack.damage(1, player, LivingEntity.getSlotForHand(hand));
            }
        }

        if (ShelfMushroomBlock.growItem(itemStack)) {
            ShelfMushroomBlock.dropStack(world, pos, new ItemStack(ModBlocks.SHELF_MUSHROOM_BLOCK));
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
        }
        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }

    private static boolean shearable(BlockState state) {
        return state.get(SIZE) > 0;
    }

    public static void shear(@Nullable Entity charger, World world, BlockPos pos, BlockState state) {
        BlockState blockState = (BlockState)state.with(SIZE, state.get(SIZE) - 1);
        world.setBlockState(pos, blockState, Block.NOTIFY_ALL);
        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(charger, blockState));
        world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, SoundEvents.BLOCK_BEEHIVE_SHEAR, SoundCategory.BLOCKS, 1.0f, 1.0f);
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (entity.bypassesLandingEffects()) {
            super.onLandedUpon(world, state, pos, entity, fallDistance);
        } else {
            entity.handleFallDamage(fallDistance, 0.0f, world.getDamageSources().fall());
        }
    }


    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        if (entity.bypassesLandingEffects()) {
            super.onEntityLand(world, entity);
        } else {
            this.bounce(entity);
        }
    }

    private void bounce(Entity entity) {
        Vec3d vec3d = entity.getVelocity();
        if (vec3d.y < 0.0) {
            double d = entity instanceof LivingEntity ? 1.0 : 0.8;
            entity.setVelocity(vec3d.x, -vec3d.y * d, vec3d.z);
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case EAST: {
                if (state.get(SIZE) == 2) {
                    return EAST_LARGE_SHELF;
                } else if (state.get(SIZE) == 1) {
                    return EAST_MEDIUM_SHELVES;
                }
                return EAST_SMALL_SHELVES;
            }
            case SOUTH: {
                if (state.get(SIZE) == 2) {
                    return SOUTH_LARGE_SHELF;
                } else if (state.get(SIZE) == 1) {
                    return SOUTH_MEDIUM_SHELVES;
                }
                return SOUTH_SMALL_SHELVES;
            }
            case WEST: {
                if (state.get(SIZE) == 2) {
                    return WEST_LARGE_SHELF;
                } else if (state.get(SIZE) == 1) {
                    return WEST_MEDIUM_SHELVES;
                }
                return WEST_SMALL_SHELVES;
            }
        }
        if (state.get(SIZE) == 2) {
            return NORTH_LARGE_SHELF;
        } else if (state.get(SIZE) == 1) {
            return NORTH_MEDIUM_SHELVES;
        }
        return NORTH_SMALL_SHELVES;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SIZE, FACING, WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED).booleanValue()) {
            return Fluids.WATER.getStill(false);
        }
        return super.getFluidState(state);
    }

    @Override
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }
}
