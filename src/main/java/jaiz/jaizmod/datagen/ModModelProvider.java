package jaiz.jaizmod.datagen;

import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) { super(output);}

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerTintableCross(ModBlocks.AMETHYST_THORN, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerTintableCross(ModBlocks.COLUMBINE, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerDoubleBlock(ModBlocks.CALLALILY_WHITE, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.CALLALILY_PURPLE, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.CALLALILY_YELLOW, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.CALLALILY_LILAC, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.CALLALILY_PINK, BlockStateModelGenerator.TintType.NOT_TINTED);


        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_ROTTEN_LOG).log(ModBlocks.STRIPPED_ROTTEN_LOG).wood(ModBlocks.STRIPPED_ROTTEN_WOOD);

        BlockStateModelGenerator.BlockTexturePool rotten_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ROTTEN_PLANKS);
        rotten_pool.family(ModBlocks.ROTTEN_FAMILY);

        rotten_pool.stairs(ModBlocks.ROTTEN_STAIRS);
        rotten_pool.slab(ModBlocks.ROTTEN_SLAB);
        rotten_pool.fence(ModBlocks.ROTTEN_FENCE);
        rotten_pool.fenceGate(ModBlocks.ROTTEN_FENCE_GATE);
        rotten_pool.button(ModBlocks.ROTTEN_BUTTON);
        rotten_pool.pressurePlate(ModBlocks.ROTTEN_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.ROTTEN_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.ROTTEN_TRAPDOOR);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ROT_BLOCK);

        blockStateModelGenerator.registerHangingSign(ModBlocks.HANGING_ROTTEN_SIGN, ModBlocks.HANGING_ROTTEN_SIGN, ModBlocks.WALL_HANGING_ROTTEN_SIGN);

        blockStateModelGenerator.registerLog(ModBlocks.MAHOGANY_LOG).log(ModBlocks.MAHOGANY_LOG).wood(ModBlocks.MAHOGANY_WOOD);

        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_MAHOGANY_LOG).log(ModBlocks.STRIPPED_MAHOGANY_LOG).wood(ModBlocks.STRIPPED_MAHOGANY_WOOD);

        BlockStateModelGenerator.BlockTexturePool mahogany_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MAHOGANY_PLANKS);
        mahogany_pool.family(ModBlocks.MAHOGANY_FAMILY);

        mahogany_pool.stairs(ModBlocks.MAHOGANY_STAIRS);
        mahogany_pool.slab(ModBlocks.MAHOGANY_SLAB);
        mahogany_pool.fence(ModBlocks.MAHOGANY_FENCE);
        mahogany_pool.fenceGate(ModBlocks.MAHOGANY_FENCE_GATE);
        mahogany_pool.button(ModBlocks.MAHOGANY_BUTTON);
        mahogany_pool.pressurePlate(ModBlocks.MAHOGANY_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.MAHOGANY_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.MAHOGANY_TRAPDOOR);

        blockStateModelGenerator.registerWoolAndCarpet((ModBlocks.FANCY_WHITE_WOOL), (ModBlocks.FANCY_WHITE_CARPET));
        blockStateModelGenerator.registerWoolAndCarpet((ModBlocks.FANCY_LIGHT_GRAY_WOOL), (ModBlocks.FANCY_LIGHT_GRAY_CARPET));
        blockStateModelGenerator.registerWoolAndCarpet((ModBlocks.FANCY_GRAY_WOOL), (ModBlocks.FANCY_GRAY_CARPET));
        blockStateModelGenerator.registerWoolAndCarpet((ModBlocks.FANCY_BLACK_WOOL), (ModBlocks.FANCY_BLACK_CARPET));
        blockStateModelGenerator.registerWoolAndCarpet((ModBlocks.FANCY_BROWN_WOOL), (ModBlocks.FANCY_BROWN_CARPET));
        blockStateModelGenerator.registerWoolAndCarpet((ModBlocks.FANCY_RED_WOOL), (ModBlocks.FANCY_RED_CARPET));
        blockStateModelGenerator.registerWoolAndCarpet((ModBlocks.FANCY_YELLOW_WOOL), (ModBlocks.FANCY_YELLOW_CARPET));
        blockStateModelGenerator.registerWoolAndCarpet((ModBlocks.FANCY_LIME_WOOL), (ModBlocks.FANCY_LIME_CARPET));
        blockStateModelGenerator.registerWoolAndCarpet((ModBlocks.FANCY_CYAN_WOOL), (ModBlocks.FANCY_CYAN_CARPET));
        blockStateModelGenerator.registerWoolAndCarpet((ModBlocks.FANCY_LIGHT_BLUE_WOOL), (ModBlocks.FANCY_LIGHT_BLUE_CARPET));
        blockStateModelGenerator.registerWoolAndCarpet((ModBlocks.FANCY_PURPLE_WOOL), (ModBlocks.FANCY_PURPLE_CARPET));
        blockStateModelGenerator.registerWoolAndCarpet((ModBlocks.FANCY_MAGENTA_WOOL), (ModBlocks.FANCY_MAGENTA_CARPET));
        blockStateModelGenerator.registerWoolAndCarpet((ModBlocks.FANCY_PINK_WOOL), (ModBlocks.FANCY_PINK_CARPET));
        blockStateModelGenerator.registerWoolAndCarpet((ModBlocks.FANCY_BLUE_WOOL), (ModBlocks.FANCY_BLUE_CARPET));

        blockStateModelGenerator.registerLog(ModBlocks.FANCY_ORANGE_WOOL).log(ModBlocks.FANCY_ORANGE_WOOL);
        blockStateModelGenerator.registerLog(ModBlocks.FANCY_GREEN_WOOL).log(ModBlocks.FANCY_GREEN_WOOL);


        blockStateModelGenerator.registerLog(ModBlocks.DESERT_OAK_LOG).log(ModBlocks.DESERT_OAK_LOG).wood(ModBlocks.DESERT_OAK_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_DESERT_OAK_LOG).log(ModBlocks.STRIPPED_DESERT_OAK_LOG).wood(ModBlocks.STRIPPED_DESERT_OAK_WOOD);


        BlockStateModelGenerator.BlockTexturePool desert_oak_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DESERT_OAK_PLANKS);
        desert_oak_pool.family(ModBlocks.DESERT_OAK_FAMILY);

        BlockStateModelGenerator.BlockTexturePool terracotta_brick_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TERRACOTTA_BRICKS);
        terracotta_brick_pool.family(ModBlocks.TERRACOTTA_BRICK_FAMILY);
        terracotta_brick_pool.stairs(ModBlocks.TERRACOTTA_BRICK_STAIRS);
        terracotta_brick_pool.slab(ModBlocks.TERRACOTTA_BRICK_SLAB);
        terracotta_brick_pool.wall(ModBlocks.TERRACOTTA_BRICK_WALL);

        desert_oak_pool.stairs(ModBlocks.DESERT_OAK_STAIRS);
        desert_oak_pool.slab(ModBlocks.DESERT_OAK_SLAB);
        desert_oak_pool.fence(ModBlocks.DESERT_OAK_FENCE);
        desert_oak_pool.fenceGate(ModBlocks.DESERT_OAK_FENCE_GATE);
        desert_oak_pool.button(ModBlocks.DESERT_OAK_BUTTON);
        desert_oak_pool.pressurePlate(ModBlocks.DESERT_OAK_PRESSURE_PLATE);

        blockStateModelGenerator.registerTintableCross(ModBlocks.DESERT_OAK_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.MAHOGANY_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerDoor(ModBlocks.DESERT_OAK_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.DESERT_OAK_TRAPDOOR);

        blockStateModelGenerator.registerBrushableBlock(ModBlocks.FOSSIL_SOIL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HONEYCOMB_DIRT);

        blockStateModelGenerator.registerHangingSign(ModBlocks.HANGING_DESERT_OAK_SIGN, ModBlocks.HANGING_DESERT_OAK_SIGN, ModBlocks.WALL_HANGING_DESERT_OAK_SIGN);

        blockStateModelGenerator.registerTintableCross(ModBlocks.SLIME_DRIP, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerHangingSign(ModBlocks.HANGING_MAHOGANY_SIGN, ModBlocks.HANGING_MAHOGANY_SIGN, ModBlocks.WALL_HANGING_MAHOGANY_SIGN);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.SILK, Models.GENERATED);
        itemModelGenerator.register(ModItems.DYNAMITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RARE_SPICES, Models.GENERATED);
        itemModelGenerator.register(ModItems.OBSIDIAN_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.WEDGE_OBSIDIAN_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHARP_OBSIDIAN_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.MIMIC_POT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOURMET_MEAL, Models.GENERATED);

        itemModelGenerator.register(ModItems.DESERT_OAK_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROTTEN_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAHOGANY_BOAT, Models.GENERATED);

        itemModelGenerator.register(ModItems.DESERT_OAK_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROTTEN_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAHOGANY_CHEST_BOAT, Models.GENERATED);

        itemModelGenerator.register(ModItems.BATTERED_AXE_REMNANT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BATTERED_AXE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.GLOW_BALL, Models.GENERATED);

        itemModelGenerator.register(ModItems.ORIGAMI_HAIRBALL_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.PETRIFIED_ARMOR_TRIM_SMITHING_TEMPLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.SHARP_OBSIDIAN_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WEDGE_OBSIDIAN_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHARP_OBSIDIAN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WEDGE_OBSIDIAN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHARP_WEDGE_OBSIDIAN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHARP_REGULAR_OBSIDIAN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD, Models.HANDHELD);


        itemModelGenerator.register(ModItems.BANDIT_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));


        itemModelGenerator.register(ModItems.GUANO, Models.GENERATED);

        itemModelGenerator.register(ModItems.FRUIT_BAT_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.register(ModItems.DRAGONFLY_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.register(ModItems.BUTTERFLY_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.register(ModItems.SNAIL_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.register(ModItems.CATERPILLAR_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.register(ModItems.FIREFLY_SWARM_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.register(ModItems.TEA_CUP, Models.GENERATED);
        itemModelGenerator.register(ModItems.NOVEL_TEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFIRED_TEA_CUP, Models.GENERATED);
        itemModelGenerator.register(ModItems.WITHER_ROSE_TEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.PUMPKIN_SPICE_TEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.HERBAL_TEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHORUS_FRUIT_TEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLOWER_TEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLOW_BERRY_TEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.GUNPOWDER_GREEN_TEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.KOMBUCHA_TEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHER_FUNGUS_TEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.WARPED_NETHER_FUNGUS_TEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.PITCHER_PLANT_TEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPORE_BLOSSOM_TEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.TORCH_FLOWER_TEA, Models.GENERATED);

    }
}
