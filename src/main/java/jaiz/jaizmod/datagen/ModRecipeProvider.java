package jaiz.jaizmod.datagen;


import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.item.ModItemGroups;
import jaiz.jaizmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.StonecuttingRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        List<ItemConvertible> UNFIRED_TEA_CUP = List.of(ModItems.UNFIRED_TEA_CUP);
        offerSmelting(exporter, UNFIRED_TEA_CUP, RecipeCategory.FOOD, ModItems.TEA_CUP, 0.25f, 200, "tea_cup");
        offerBlasting(exporter, UNFIRED_TEA_CUP, RecipeCategory.FOOD, ModItems.TEA_CUP, 0.25f, 150, "tea_cup");

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.UNFIRED_TEA_CUP, 1)
                .pattern("R R")
                .pattern(" R ")
                .input('R', Items.CLAY_BALL)
                .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.UNFIRED_TEA_CUP)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModBlocks.TEAPOTBLOCK, 1)
                .pattern("R R")
                .pattern(" R ")
                .pattern("XCX")
                .input('R', Items.COPPER_INGOT)
                .input('X', ItemTags.LOGS)
                .input('C', Items.COAL)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.OAK_LOG), conditionsFromItem(Items.OAK_LOG))
                .criterion(hasItem(Items.COAL), conditionsFromItem(Items.COAL))

                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.TEAPOTBLOCK)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.GLOWING_SPYGLASS, 1)
                .pattern("LLL")
                .pattern("LXL")
                .pattern("LLL")
                .input('X', Items.SPYGLASS)
                .input('L', Items.GLOW_INK_SAC)
                .criterion(hasItem(Items.SPYGLASS), conditionsFromItem(Items.SPYGLASS))
                .criterion(hasItem(Items.GLOW_INK_SAC), conditionsFromItem(Items.GLOW_INK_SAC))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.GLOWING_SPYGLASS)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GOURMET_MEAL, 1)
                .input(ModItems.RARE_SPICES)
                .input(Items.BEETROOT)
                .input(Items.COOKED_CHICKEN)
                .input(Items.CARROT)
                .criterion(hasItem(ModItems.RARE_SPICES), conditionsFromItem(ModItems.RARE_SPICES))
                .criterion(hasItem(Items.BEETROOT), conditionsFromItem(Items.BEETROOT))
                .criterion(hasItem(Items.CARROT), conditionsFromItem(Items.CARROT))
                .criterion(hasItem(Items.COOKED_CHICKEN), conditionsFromItem(Items.COOKED_CHICKEN))
                .offerTo(exporter, Identifier.of(JaizMod.MOD_ID, "gourmet_meal_chicken"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GOURMET_MEAL, 1)
                .input(ModItems.RARE_SPICES)
                .input(Items.BEETROOT)
                .input(Items.COOKED_RABBIT)
                .input(Items.CARROT)
                .criterion(hasItem(ModItems.RARE_SPICES), conditionsFromItem(ModItems.RARE_SPICES))
                .criterion(hasItem(Items.BEETROOT), conditionsFromItem(Items.BEETROOT))
                .criterion(hasItem(Items.CARROT), conditionsFromItem(Items.CARROT))
                .criterion(hasItem(Items.COOKED_RABBIT), conditionsFromItem(Items.COOKED_RABBIT))
                .offerTo(exporter, Identifier.of(JaizMod.MOD_ID, "gourmet_meal_rabbit"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModItems.WATER_TORCH, 4)
                .pattern("Y")
                .pattern("X")
                .input('Y', Items.GLOW_INK_SAC)
                .input('X', Items.AMETHYST_SHARD)
                .criterion(hasItem(Items.GLOW_INK_SAC), conditionsFromItem(Items.GLOW_INK_SAC))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.WATER_TORCH)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TERRACOTTA_BRICKS, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', Items.TERRACOTTA)
                .input('R', Items.BRICK)
                .criterion(hasItem(Items.BRICK), conditionsFromItem(Items.BRICK))
                .criterion(hasItem(Items.TERRACOTTA), conditionsFromItem(Items.TERRACOTTA))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.TERRACOTTA_BRICKS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HONEYCOMB_DIRT, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', Items.HONEYCOMB)
                .input('R', Items.DIRT)
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .criterion(hasItem(Blocks.DIRT), conditionsFromItem(Items.DIRT))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.HONEYCOMB_DIRT)));

        //wools ;-;

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_BLACK_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.BLACK_WOOL)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_BLACK_WOOL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_GRAY_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.GRAY_WOOL)
                .criterion(hasItem(Items.GRAY_WOOL), conditionsFromItem(Items.GRAY_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_GRAY_WOOL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_LIGHT_GRAY_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.LIGHT_GRAY_WOOL)
                .criterion(hasItem(Items.LIGHT_GRAY_WOOL), conditionsFromItem(Items.LIGHT_GRAY_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_LIGHT_GRAY_WOOL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_WHITE_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.WHITE_WOOL)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_WHITE_WOOL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_BROWN_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.BROWN_WOOL)
                .criterion(hasItem(Items.BROWN_WOOL), conditionsFromItem(Items.BROWN_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_BROWN_WOOL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_ORANGE_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.ORANGE_WOOL)
                .criterion(hasItem(Items.ORANGE_WOOL), conditionsFromItem(Items.ORANGE_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_ORANGE_WOOL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_RED_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.RED_WOOL)
                .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_RED_WOOL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_YELLOW_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.YELLOW_WOOL)
                .criterion(hasItem(Items.YELLOW_WOOL), conditionsFromItem(Items.YELLOW_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_YELLOW_WOOL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_LIME_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.LIME_WOOL)
                .criterion(hasItem(Items.LIME_WOOL), conditionsFromItem(Items.LIME_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_LIME_WOOL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_GREEN_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.GREEN_WOOL)
                .criterion(hasItem(Items.GREEN_WOOL), conditionsFromItem(Items.GREEN_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_GREEN_WOOL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_CYAN_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.CYAN_WOOL)
                .criterion(hasItem(Items.CYAN_WOOL), conditionsFromItem(Items.CYAN_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_CYAN_WOOL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_LIGHT_BLUE_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.LIGHT_BLUE_WOOL)
                .criterion(hasItem(Items.LIGHT_BLUE_WOOL), conditionsFromItem(Items.LIGHT_BLUE_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_LIGHT_BLUE_WOOL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_BLUE_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.BLUE_WOOL)
                .criterion(hasItem(Items.BLUE_WOOL), conditionsFromItem(Items.BLUE_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_BLUE_WOOL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_PURPLE_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.PURPLE_WOOL)
                .criterion(hasItem(Items.PURPLE_WOOL), conditionsFromItem(Items.PURPLE_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_PURPLE_WOOL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_MAGENTA_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.MAGENTA_WOOL)
                .criterion(hasItem(Items.MAGENTA_WOOL), conditionsFromItem(Items.MAGENTA_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_MAGENTA_WOOL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_PINK_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.PINK_WOOL)
                .criterion(hasItem(Items.PINK_WOOL), conditionsFromItem(Items.PINK_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_PINK_WOOL)));

        //more fucking carpets


        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_BLACK_CARPET, 2)
                .pattern("RR")
                .input('R', ModBlocks.FANCY_BLACK_WOOL)
                .criterion(hasItem(ModBlocks.FANCY_BLACK_WOOL), conditionsFromItem(ModBlocks.FANCY_BLACK_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_BLACK_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_BROWN_CARPET, 2)
                .pattern("RR")
                .input('R', ModBlocks.FANCY_BROWN_WOOL)
                .criterion(hasItem(ModBlocks.FANCY_BROWN_WOOL), conditionsFromItem(ModBlocks.FANCY_BROWN_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_BROWN_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_GRAY_CARPET, 2)
                .pattern("RR")
                .input('R', ModBlocks.FANCY_GRAY_WOOL)
                .criterion(hasItem(ModBlocks.FANCY_GRAY_WOOL), conditionsFromItem(ModBlocks.FANCY_GRAY_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_GRAY_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_LIGHT_GRAY_CARPET, 2)
                .pattern("RR")
                .input('R', ModBlocks.FANCY_LIGHT_GRAY_WOOL)
                .criterion(hasItem(ModBlocks.FANCY_LIGHT_GRAY_WOOL), conditionsFromItem(ModBlocks.FANCY_LIGHT_GRAY_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_LIGHT_GRAY_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_WHITE_CARPET, 2)
                .pattern("RR")
                .input('R', ModBlocks.FANCY_WHITE_WOOL)
                .criterion(hasItem(ModBlocks.FANCY_WHITE_WOOL), conditionsFromItem(ModBlocks.FANCY_WHITE_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_WHITE_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_BLUE_CARPET, 2)
                .pattern("RR")
                .input('R', ModBlocks.FANCY_BLUE_WOOL)
                .criterion(hasItem(ModBlocks.FANCY_BLUE_WOOL), conditionsFromItem(ModBlocks.FANCY_BLUE_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_BLUE_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_LIGHT_BLUE_CARPET, 2)
                .pattern("RR")
                .input('R', ModBlocks.FANCY_LIGHT_BLUE_WOOL)
                .criterion(hasItem(ModBlocks.FANCY_LIGHT_BLUE_WOOL), conditionsFromItem(ModBlocks.FANCY_LIGHT_BLUE_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_LIGHT_BLUE_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_LIME_CARPET, 2)
                .pattern("RR")
                .input('R', ModBlocks.FANCY_LIME_WOOL)
                .criterion(hasItem(ModBlocks.FANCY_LIME_WOOL), conditionsFromItem(ModBlocks.FANCY_LIME_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_LIME_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_GREEN_CARPET, 2)
                .pattern("RR")
                .input('R', ModBlocks.FANCY_GREEN_WOOL)
                .criterion(hasItem(ModBlocks.FANCY_GREEN_WOOL), conditionsFromItem(ModBlocks.FANCY_GREEN_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_GREEN_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_YELLOW_CARPET, 2)
                .pattern("RR")
                .input('R', ModBlocks.FANCY_YELLOW_WOOL)
                .criterion(hasItem(ModBlocks.FANCY_YELLOW_WOOL), conditionsFromItem(ModBlocks.FANCY_YELLOW_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_YELLOW_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_RED_CARPET, 2)
                .pattern("RR")
                .input('R', ModBlocks.FANCY_RED_WOOL)
                .criterion(hasItem(ModBlocks.FANCY_RED_WOOL), conditionsFromItem(ModBlocks.FANCY_RED_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_RED_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_ORANGE_CARPET, 2)
                .pattern("RR")
                .input('R', ModBlocks.FANCY_ORANGE_WOOL)
                .criterion(hasItem(ModBlocks.FANCY_ORANGE_WOOL), conditionsFromItem(ModBlocks.FANCY_ORANGE_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_ORANGE_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_PINK_CARPET, 2)
                .pattern("RR")
                .input('R', ModBlocks.FANCY_PINK_WOOL)
                .criterion(hasItem(ModBlocks.FANCY_PINK_WOOL), conditionsFromItem(ModBlocks.FANCY_PINK_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_PINK_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_CYAN_CARPET, 2)
                .pattern("RR")
                .input('R', ModBlocks.FANCY_CYAN_WOOL)
                .criterion(hasItem(ModBlocks.FANCY_CYAN_WOOL), conditionsFromItem(ModBlocks.FANCY_CYAN_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_CYAN_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_MAGENTA_CARPET, 2)
                .pattern("RR")
                .input('R', ModBlocks.FANCY_MAGENTA_WOOL)
                .criterion(hasItem(ModBlocks.FANCY_MAGENTA_WOOL), conditionsFromItem(ModBlocks.FANCY_MAGENTA_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_MAGENTA_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FANCY_PURPLE_CARPET, 2)
                .pattern("RR")
                .input('R', ModBlocks.FANCY_PURPLE_WOOL)
                .criterion(hasItem(ModBlocks.FANCY_PURPLE_WOOL), conditionsFromItem(ModBlocks.FANCY_PURPLE_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FANCY_PURPLE_CARPET)));




        // Sandstone Variants

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GILDED_SANDSTONE, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', Items.GOLD_NUGGET)
                .input('R', Items.SANDSTONE)
                .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                .criterion(hasItem(Items.SANDSTONE), conditionsFromItem(Items.SANDSTONE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.GILDED_SANDSTONE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GILDED_CHISELED_SANDSTONE, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', Items.GOLD_NUGGET)
                .input('R', Items.CHISELED_SANDSTONE)
                .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                .criterion(hasItem(Items.CHISELED_SANDSTONE), conditionsFromItem(Items.CHISELED_SANDSTONE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.GILDED_CHISELED_SANDSTONE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GILDED_CUT_SANDSTONE, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', Items.GOLD_NUGGET)
                .input('R', Items.CUT_SANDSTONE)
                .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                .criterion(hasItem(Items.CUT_SANDSTONE), conditionsFromItem(Items.CUT_SANDSTONE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.GILDED_CUT_SANDSTONE)));

        //Desert Oak

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DESERT_OAK_DOOR, 3)
                .pattern("RR")
                .pattern("RR")
                .pattern("RR")
                .input('R', ModBlocks.DESERT_OAK_PLANKS)
                .criterion(hasItem(ModBlocks.DESERT_OAK_PLANKS), conditionsFromItem(ModBlocks.DESERT_OAK_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.DESERT_OAK_DOOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DESERT_OAK_TRAPDOOR, 2)
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModBlocks.DESERT_OAK_PLANKS)
                .criterion(hasItem(ModBlocks.DESERT_OAK_PLANKS), conditionsFromItem(ModBlocks.DESERT_OAK_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.DESERT_OAK_TRAPDOOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DESERT_OAK_FENCE, 3)
                .pattern("RXR")
                .pattern("RXR")
                .input('R', ModBlocks.DESERT_OAK_PLANKS)
                .input('X', Items.STICK)
                .criterion(hasItem(ModBlocks.DESERT_OAK_PLANKS), conditionsFromItem(ModBlocks.DESERT_OAK_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.DESERT_OAK_FENCE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DESERT_OAK_FENCE_GATE, 1)
                .pattern("RXR")
                .pattern("RXR")
                .input('X', ModBlocks.DESERT_OAK_PLANKS)
                .input('R', Items.STICK)
                .criterion(hasItem(ModBlocks.DESERT_OAK_PLANKS), conditionsFromItem(ModBlocks.DESERT_OAK_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.DESERT_OAK_FENCE_GATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DESERT_OAK_SLAB, 6)
                .pattern("RRR")
                .input('R', ModBlocks.DESERT_OAK_PLANKS)
                .criterion(hasItem(ModBlocks.DESERT_OAK_PLANKS), conditionsFromItem(ModBlocks.DESERT_OAK_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.DESERT_OAK_SLAB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DESERT_OAK_STAIRS, 4)
                .pattern("R  ")
                .pattern("RR ")
                .pattern("RRR")
                .input('R', ModBlocks.DESERT_OAK_PLANKS)
                .criterion(hasItem(ModBlocks.DESERT_OAK_PLANKS), conditionsFromItem(ModBlocks.DESERT_OAK_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.DESERT_OAK_STAIRS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.DESERT_OAK_BOAT, 1)
                .pattern("R R")
                .pattern("RRR")
                .input('R', ModBlocks.DESERT_OAK_PLANKS)
                .criterion(hasItem(ModBlocks.DESERT_OAK_PLANKS), conditionsFromItem(ModBlocks.DESERT_OAK_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.DESERT_OAK_BOAT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DESERT_OAK_WOOD, 4)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModBlocks.DESERT_OAK_LOG)
                .criterion(hasItem(ModBlocks.DESERT_OAK_LOG), conditionsFromItem(ModBlocks.DESERT_OAK_LOG))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.DESERT_OAK_WOOD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_DESERT_OAK_WOOD, 4)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModBlocks.STRIPPED_DESERT_OAK_LOG)
                .criterion(hasItem(ModBlocks.STRIPPED_DESERT_OAK_LOG), conditionsFromItem(ModBlocks.STRIPPED_DESERT_OAK_LOG))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.STRIPPED_DESERT_OAK_WOOD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.DESERT_OAK_PRESSURE_PLATE, 1)
                .pattern("RR")
                .input('R', ModBlocks.DESERT_OAK_PLANKS)
                .criterion(hasItem(ModBlocks.DESERT_OAK_PLANKS), conditionsFromItem(ModBlocks.DESERT_OAK_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.DESERT_OAK_PRESSURE_PLATE)));

        //Swords recipe

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("R")
                .pattern("X")
                .input('R', ModItems.OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.OBSIDIAN_SHARD), conditionsFromItem(ModItems.OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.OBSIDIAN_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.WEDGE_OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("R")
                .pattern("X")
                .input('R', ModItems.WEDGE_OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.WEDGE_OBSIDIAN_SHARD), conditionsFromItem(ModItems.WEDGE_OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.WEDGE_OBSIDIAN_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SHARP_OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("R")
                .pattern("X")
                .input('R', ModItems.SHARP_OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.SHARP_OBSIDIAN_SHARD), conditionsFromItem(ModItems.SHARP_OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.SHARP_OBSIDIAN_SWORD)));

        //custom ones
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SHARP_REGULAR_OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("C")
                .pattern("X")
                .input('R', ModItems.SHARP_OBSIDIAN_SHARD)
                .input('C', ModItems.OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.OBSIDIAN_SHARD), conditionsFromItem(ModItems.OBSIDIAN_SHARD))
                .criterion(hasItem(ModItems.SHARP_OBSIDIAN_SHARD), conditionsFromItem(ModItems.SHARP_OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.SHARP_REGULAR_OBSIDIAN_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("C")
                .pattern("X")
                .input('R', ModItems.WEDGE_OBSIDIAN_SHARD)
                .input('C', ModItems.OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.OBSIDIAN_SHARD), conditionsFromItem(ModItems.OBSIDIAN_SHARD))
                .criterion(hasItem(ModItems.WEDGE_OBSIDIAN_SHARD), conditionsFromItem(ModItems.WEDGE_OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SHARP_WEDGE_OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("C")
                .pattern("X")
                .input('R', ModItems.SHARP_OBSIDIAN_SHARD)
                .input('C', ModItems.WEDGE_OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.WEDGE_OBSIDIAN_SHARD), conditionsFromItem(ModItems.WEDGE_OBSIDIAN_SHARD))
                .criterion(hasItem(ModItems.SHARP_OBSIDIAN_SHARD), conditionsFromItem(ModItems.SHARP_OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.SHARP_WEDGE_OBSIDIAN_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SHARP_WEDGE_OBSIDIAN_SWORD, 1)
                .pattern("C")
                .pattern("R")
                .pattern("X")
                .input('R', ModItems.SHARP_OBSIDIAN_SHARD)
                .input('C', ModItems.WEDGE_OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.WEDGE_OBSIDIAN_SHARD), conditionsFromItem(ModItems.WEDGE_OBSIDIAN_SHARD))
                .criterion(hasItem(ModItems.SHARP_OBSIDIAN_SHARD), conditionsFromItem(ModItems.SHARP_OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(JaizMod.MOD_ID, "sharp_wedge_obsidian_sword_2"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("C")
                .pattern("X")
                .input('R', ModItems.OBSIDIAN_SHARD)
                .input('C', ModItems.WEDGE_OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.WEDGE_OBSIDIAN_SHARD), conditionsFromItem(ModItems.WEDGE_OBSIDIAN_SHARD))
                .criterion(hasItem(ModItems.OBSIDIAN_SHARD), conditionsFromItem(ModItems.OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(JaizMod.MOD_ID, "regular_wedge_obsidian_sword_2"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SHARP_REGULAR_OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("C")
                .pattern("X")
                .input('R', ModItems.OBSIDIAN_SHARD)
                .input('C', ModItems.SHARP_OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.SHARP_OBSIDIAN_SHARD), conditionsFromItem(ModItems.SHARP_OBSIDIAN_SHARD))
                .criterion(hasItem(ModItems.OBSIDIAN_SHARD), conditionsFromItem(ModItems.OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(JaizMod.MOD_ID, "regular_sharp_obsidian_sword_2"));


        //daggers

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.OBSIDIAN_DAGGER, 1)
                .pattern("R")
                .pattern("X")
                .input('R', ModItems.OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.OBSIDIAN_SHARD), conditionsFromItem(ModItems.OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.OBSIDIAN_DAGGER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.WEDGE_OBSIDIAN_DAGGER, 1)
                .pattern("R")
                .pattern("X")
                .input('R', ModItems.WEDGE_OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.WEDGE_OBSIDIAN_SHARD), conditionsFromItem(ModItems.WEDGE_OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.WEDGE_OBSIDIAN_DAGGER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SHARP_OBSIDIAN_DAGGER, 1)
                .pattern("R")
                .pattern("X")
                .input('R', ModItems.SHARP_OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.SHARP_OBSIDIAN_SHARD), conditionsFromItem(ModItems.SHARP_OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.SHARP_OBSIDIAN_DAGGER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TERRACOTTA_BRICK_SLAB, 6)
                .pattern("RRR")
                .input('R', ModBlocks.TERRACOTTA_BRICKS)
                .criterion(hasItem(ModBlocks.TERRACOTTA_BRICKS), conditionsFromItem(ModBlocks.TERRACOTTA_BRICKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.TERRACOTTA_BRICK_SLAB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TERRACOTTA_BRICK_STAIRS, 4)
                .pattern("R  ")
                .pattern("RR ")
                .pattern("RRR")
                .input('R', ModBlocks.TERRACOTTA_BRICKS)
                .criterion(hasItem(ModBlocks.TERRACOTTA_BRICKS), conditionsFromItem(ModBlocks.TERRACOTTA_BRICKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.TERRACOTTA_BRICK_STAIRS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TERRACOTTA_BRICK_WALL, 6)
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModBlocks.TERRACOTTA_BRICKS)
                .criterion(hasItem(ModBlocks.TERRACOTTA_BRICKS), conditionsFromItem(ModBlocks.TERRACOTTA_BRICKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.TERRACOTTA_BRICK_WALL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModBlocks.SPICE_BARREL, 1)
                .pattern("RRR")
                .pattern("RXR")
                .pattern("RRR")
                .input('R', ModItems.RARE_SPICES)
                .input('X', Items.BARREL)
                .criterion(hasItem(ModItems.RARE_SPICES), conditionsFromItem(ModItems.RARE_SPICES))
                .criterion(hasItem(Items.BARREL), conditionsFromItem(Items.BARREL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.SPICE_BARREL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BATTERED_AXE, 1)
                .pattern("RYR")
                .pattern(" X ")
                .input('Y', ModItems.BATTERED_AXE_REMNANT)
                .input('X', Items.STICK)
                .input('R', Items.COPPER_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(ModItems.BATTERED_AXE_REMNANT), conditionsFromItem(ModItems.BATTERED_AXE_REMNANT))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.BATTERED_AXE)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_SIGN, 3)
                .pattern("RRR")
                .pattern("RRR")
                .pattern(" X ")
                .input('R', ModBlocks.DESERT_OAK_PLANKS)
                .input('X', Items.STICK)
                .criterion(hasItem(ModBlocks.DESERT_OAK_PLANKS), conditionsFromItem(ModBlocks.DESERT_OAK_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.DESERT_OAK_SIGN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModItems.HANGING_DESERT_OAK_SIGN, 6)
                .pattern("X X")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModBlocks.STRIPPED_DESERT_OAK_LOG)
                .input('X', Blocks.CHAIN)
                .criterion(hasItem(ModBlocks.STRIPPED_DESERT_OAK_LOG), conditionsFromItem(ModBlocks.STRIPPED_DESERT_OAK_LOG))
                .criterion(hasItem(Blocks.CHAIN), conditionsFromItem(Blocks.CHAIN))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.HANGING_DESERT_OAK_SIGN)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DESERT_OAK_BUTTON, 1)
                .pattern("R")
                .input('R', ModBlocks.DESERT_OAK_PLANKS)
                .criterion(hasItem(ModBlocks.DESERT_OAK_PLANKS), conditionsFromItem(ModBlocks.DESERT_OAK_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.DESERT_OAK_BUTTON)));


        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DESERT_OAK_PLANKS, 4)
                .input(ModBlocks.DESERT_OAK_LOG)
                .criterion(hasItem(ModBlocks.DESERT_OAK_LOG), conditionsFromItem(ModBlocks.DESERT_OAK_LOG))
                .offerTo(exporter, Identifier.of(JaizMod.MOD_ID, "planks_desert0"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DESERT_OAK_PLANKS, 4)
                .input(ModBlocks.STRIPPED_DESERT_OAK_LOG)
                .criterion(hasItem(ModBlocks.STRIPPED_DESERT_OAK_LOG), conditionsFromItem(ModBlocks.STRIPPED_DESERT_OAK_LOG))
                .offerTo(exporter, Identifier.of(JaizMod.MOD_ID, "planks_desert1"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DESERT_OAK_PLANKS, 4)
                .input(ModBlocks.STRIPPED_DESERT_OAK_WOOD)
                .criterion(hasItem(ModBlocks.STRIPPED_DESERT_OAK_WOOD), conditionsFromItem(ModBlocks.STRIPPED_DESERT_OAK_WOOD))
                .offerTo(exporter, Identifier.of(JaizMod.MOD_ID, "planks_desert2"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DESERT_OAK_PLANKS, 4)
                .input(ModBlocks.DESERT_OAK_WOOD)
                .criterion(hasItem(ModBlocks.DESERT_OAK_WOOD), conditionsFromItem(ModBlocks.DESERT_OAK_WOOD))
                .offerTo(exporter, Identifier.of(JaizMod.MOD_ID, "planks_desert3"));



        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.MAGENTA_DYE, 2)
                .pattern("R")
                .input('R', ModBlocks.CALLALILY_LILAC)
                .criterion(hasItem(ModBlocks.CALLALILY_LILAC), conditionsFromItem(ModBlocks.CALLALILY_LILAC))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.MAGENTA_DYE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.PINK_DYE, 2)
                .pattern("R")
                .input('R', ModBlocks.CALLALILY_PINK)
                .criterion(hasItem(ModBlocks.CALLALILY_PINK), conditionsFromItem(ModBlocks.CALLALILY_PINK))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.PINK_DYE)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.WHITE_DYE, 2)
                .pattern("R")
                .input('R', ModBlocks.CALLALILY_WHITE)
                .criterion(hasItem(ModBlocks.CALLALILY_WHITE), conditionsFromItem(ModBlocks.CALLALILY_WHITE))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.WHITE_DYE)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.YELLOW_DYE, 2)
                .pattern("R")
                .input('R', ModBlocks.CALLALILY_YELLOW)
                .criterion(hasItem(ModBlocks.CALLALILY_YELLOW), conditionsFromItem(ModBlocks.CALLALILY_YELLOW))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.YELLOW_DYE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.PURPLE_DYE, 2)
                .pattern("S")
                .input('S', ModBlocks.CALLALILY_PURPLE)
                .criterion(hasItem(ModBlocks.CALLALILY_PURPLE), conditionsFromItem(ModBlocks.CALLALILY_PURPLE))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.PURPLE_DYE)));



        //rotten wood

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROTTEN_PLANKS, 4)
                .pattern("R")
                .input('R', ModBlocks.ROTTEN_LOG)
                .criterion(hasItem(ModBlocks.ROTTEN_LOG), conditionsFromItem(ModBlocks.ROTTEN_LOG))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.ROTTEN_PLANKS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROTTEN_BUTTON, 1)
                .pattern("R")
                .input('R', ModBlocks.ROTTEN_PLANKS)
                .criterion(hasItem(ModBlocks.ROTTEN_PLANKS), conditionsFromItem(ModBlocks.ROTTEN_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.ROTTEN_BUTTON)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROTTEN_PRESSURE_PLATE, 1)
                .pattern("RR")
                .input('R', ModBlocks.ROTTEN_PLANKS)
                .criterion(hasItem(ModBlocks.ROTTEN_PLANKS), conditionsFromItem(ModBlocks.ROTTEN_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.ROTTEN_PRESSURE_PLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROTTEN_DOOR, 3)
                .pattern("RR")
                .pattern("RR")
                .pattern("RR")
                .input('R', ModBlocks.ROTTEN_PLANKS)
                .criterion(hasItem(ModBlocks.ROTTEN_PLANKS), conditionsFromItem(ModBlocks.ROTTEN_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.ROTTEN_DOOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROTTEN_TRAPDOOR, 2)
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModBlocks.ROTTEN_PLANKS)
                .criterion(hasItem(ModBlocks.ROTTEN_PLANKS), conditionsFromItem(ModBlocks.ROTTEN_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.ROTTEN_TRAPDOOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROTTEN_FENCE, 3)
                .pattern("RXR")
                .pattern("RXR")
                .input('R', ModBlocks.ROTTEN_PLANKS)
                .input('X', Items.STICK)
                .criterion(hasItem(ModBlocks.ROTTEN_PLANKS), conditionsFromItem(ModBlocks.ROTTEN_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.ROTTEN_FENCE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROTTEN_FENCE_GATE, 1)
                .pattern("RXR")
                .pattern("RXR")
                .input('X', ModBlocks.ROTTEN_PLANKS)
                .input('R', Items.STICK)
                .criterion(hasItem(ModBlocks.ROTTEN_PLANKS), conditionsFromItem(ModBlocks.ROTTEN_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.ROTTEN_FENCE_GATE)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_SIGN, 3)
                .pattern("RRR")
                .pattern("RRR")
                .pattern(" X ")
                .input('R', ModBlocks.ROTTEN_PLANKS)
                .input('X', Items.STICK)
                .criterion(hasItem(ModBlocks.ROTTEN_PLANKS), conditionsFromItem(ModBlocks.ROTTEN_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.ROTTEN_SIGN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModItems.HANGING_ROTTEN_SIGN, 6)
                .pattern("X X")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModBlocks.STRIPPED_ROTTEN_LOG)
                .input('X', Blocks.CHAIN)
                .criterion(hasItem(ModBlocks.STRIPPED_ROTTEN_LOG), conditionsFromItem(ModBlocks.STRIPPED_ROTTEN_LOG))
                .criterion(hasItem(Blocks.CHAIN), conditionsFromItem(Blocks.CHAIN))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.HANGING_ROTTEN_SIGN)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROTTEN_SLAB, 6)
                .pattern("RRR")
                .input('R', ModBlocks.ROTTEN_PLANKS)
                .criterion(hasItem(ModBlocks.ROTTEN_PLANKS), conditionsFromItem(ModBlocks.ROTTEN_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.ROTTEN_SLAB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROTTEN_STAIRS, 4)
                .pattern("R  ")
                .pattern("RR ")
                .pattern("RRR")
                .input('R', ModBlocks.ROTTEN_PLANKS)
                .criterion(hasItem(ModBlocks.ROTTEN_PLANKS), conditionsFromItem(ModBlocks.ROTTEN_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.ROTTEN_STAIRS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.ROTTEN_BOAT, 1)
                .pattern("R R")
                .pattern("RRR")
                .input('R', ModBlocks.ROTTEN_PLANKS)
                .criterion(hasItem(ModBlocks.ROTTEN_PLANKS), conditionsFromItem(ModBlocks.ROTTEN_PLANKS))
                .offerTo(exporter, Identifier.of(JaizMod.MOD_ID, "rotten_boat"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROTTEN_WOOD, 4)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModBlocks.ROTTEN_LOG)
                .criterion(hasItem(ModBlocks.ROTTEN_LOG), conditionsFromItem(ModBlocks.ROTTEN_LOG))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.ROTTEN_WOOD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_ROTTEN_WOOD, 4)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModBlocks.STRIPPED_ROTTEN_LOG)
                .criterion(hasItem(ModBlocks.STRIPPED_ROTTEN_LOG), conditionsFromItem(ModBlocks.STRIPPED_ROTTEN_LOG))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.STRIPPED_ROTTEN_WOOD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.ROT_BLOCK, 4)
                .pattern("XR")
                .pattern("RX")
                .input('R', Blocks.DIRT)
                .input('X', Items.BONE_MEAL)
                .criterion(hasItem(Blocks.DIRT), conditionsFromItem(Blocks.DIRT))
                .criterion(hasItem(Items.BONE_MEAL), conditionsFromItem(Items.BONE_MEAL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.ROT_BLOCK)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GUANO_PILE, 1)
                .input(ModItems.GUANO)
                .criterion(hasItem(ModItems.GUANO), conditionsFromItem(ModItems.GUANO))
                .offerTo(exporter, Identifier.of(JaizMod.MOD_ID, "guano_block"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.BONE_MEAL, 3)
                .input(ModItems.GUANO)
                .criterion(hasItem(ModItems.GUANO), conditionsFromItem(ModItems.GUANO))
                .offerTo(exporter, Identifier.of(JaizMod.MOD_ID, "fertiliser_from_guano"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_PLANKS, 4)
                .input(ModBlocks.MAHOGANY_LOG)
                .criterion(hasItem(ModBlocks.MAHOGANY_LOG), conditionsFromItem(ModBlocks.MAHOGANY_LOG))
                .offerTo(exporter, Identifier.of(JaizMod.MOD_ID, "planks_mahogany0"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_PLANKS, 4)
                .input(ModBlocks.STRIPPED_MAHOGANY_LOG)
                .criterion(hasItem(ModBlocks.STRIPPED_MAHOGANY_LOG), conditionsFromItem(ModBlocks.STRIPPED_MAHOGANY_LOG))
                .offerTo(exporter, Identifier.of(JaizMod.MOD_ID, "planks_mahogany1"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_PLANKS, 4)
                .input(ModBlocks.STRIPPED_MAHOGANY_WOOD)
                .criterion(hasItem(ModBlocks.STRIPPED_MAHOGANY_WOOD), conditionsFromItem(ModBlocks.STRIPPED_MAHOGANY_WOOD))
                .offerTo(exporter, Identifier.of(JaizMod.MOD_ID, "planks_mahogany2"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_PLANKS, 4)
                .input(ModBlocks.MAHOGANY_WOOD)
                .criterion(hasItem(ModBlocks.MAHOGANY_WOOD), conditionsFromItem(ModBlocks.MAHOGANY_WOOD))
                .offerTo(exporter, Identifier.of(JaizMod.MOD_ID, "planks_mahogany3"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_DOOR, 3)
                .pattern("RR")
                .pattern("RR")
                .pattern("RR")
                .input('R', ModBlocks.MAHOGANY_PLANKS)
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.MAHOGANY_DOOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_TRAPDOOR, 2)
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModBlocks.MAHOGANY_PLANKS)
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.MAHOGANY_TRAPDOOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_FENCE, 3)
                .pattern("RXR")
                .pattern("RXR")
                .input('R', ModBlocks.MAHOGANY_PLANKS)
                .input('X', Items.STICK)
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.MAHOGANY_FENCE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_FENCE_GATE, 1)
                .pattern("RXR")
                .pattern("RXR")
                .input('X', ModBlocks.MAHOGANY_PLANKS)
                .input('R', Items.STICK)
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.MAHOGANY_FENCE_GATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_SLAB, 6)
                .pattern("RRR")
                .input('R', ModBlocks.MAHOGANY_PLANKS)
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.MAHOGANY_SLAB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_STAIRS, 4)
                .pattern("R  ")
                .pattern("RR ")
                .pattern("RRR")
                .input('R', ModBlocks.MAHOGANY_PLANKS)
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.MAHOGANY_STAIRS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.MAHOGANY_BOAT, 1)
                .pattern("R R")
                .pattern("RRR")
                .input('R', ModBlocks.MAHOGANY_PLANKS)
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(exporter, Identifier.of(JaizMod.MOD_ID, "mahogany_boat"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_WOOD, 4)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModBlocks.MAHOGANY_LOG)
                .criterion(hasItem(ModBlocks.MAHOGANY_LOG), conditionsFromItem(ModBlocks.MAHOGANY_LOG))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.MAHOGANY_WOOD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_MAHOGANY_WOOD, 4)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModBlocks.STRIPPED_MAHOGANY_LOG)
                .criterion(hasItem(ModBlocks.STRIPPED_MAHOGANY_LOG), conditionsFromItem(ModBlocks.STRIPPED_MAHOGANY_LOG))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.STRIPPED_MAHOGANY_WOOD)));



        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_SIGN, 3)
                .pattern("RRR")
                .pattern("RRR")
                .pattern(" X ")
                .input('R', ModBlocks.MAHOGANY_PLANKS)
                .input('X', Items.STICK)
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.MAHOGANY_SIGN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModItems.HANGING_MAHOGANY_SIGN, 6)
                .pattern("X X")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModBlocks.STRIPPED_MAHOGANY_LOG)
                .input('X', Blocks.CHAIN)
                .criterion(hasItem(ModBlocks.STRIPPED_MAHOGANY_LOG), conditionsFromItem(ModBlocks.STRIPPED_MAHOGANY_LOG))
                .criterion(hasItem(Blocks.CHAIN), conditionsFromItem(Blocks.CHAIN))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.HANGING_MAHOGANY_SIGN)));
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_BUTTON, 1)
                .pattern("R")
                .input('R', ModBlocks.MAHOGANY_PLANKS)
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.MAHOGANY_BUTTON)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_PRESSURE_PLATE, 1)
                .pattern("RR")
                .input('R', ModBlocks.MAHOGANY_PLANKS)
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.MAHOGANY_PRESSURE_PLATE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.GLOW_BALL, 1)
                .input(Items.SNOWBALL)
                .input(Items.GLOW_INK_SAC)
                .criterion(hasItem(Items.SNOWBALL), conditionsFromItem(Items.SNOWBALL))
                .criterion(hasItem(Items.GLOW_INK_SAC), conditionsFromItem(Items.GLOW_INK_SAC))
                .offerTo(exporter, Identifier.of(JaizMod.MOD_ID, "glowball"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BIOLUMINESCENT_BOTTLE.asItem(), 1)
                .input(Items.GLASS_BOTTLE)
                .input(Items.GLOW_INK_SAC)
                .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
                .criterion(hasItem(Items.GLOW_INK_SAC), conditionsFromItem(Items.GLOW_INK_SAC))
                .offerTo(exporter, Identifier.of(JaizMod.MOD_ID, "bioluminescent_bottle"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.DESERT_OAK_CHEST_BOAT, 1)
                .input(ModItems.DESERT_OAK_BOAT)
                .input(Items.CHEST)
                .criterion(hasItem(ModItems.DESERT_OAK_BOAT), conditionsFromItem(ModItems.DESERT_OAK_BOAT))
                .criterion(hasItem(Items.CHEST), conditionsFromItem(Items.CHEST))
                .offerTo(exporter, Identifier.of(JaizMod.MOD_ID, "desert_oak_chest_boat"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.MAHOGANY_CHEST_BOAT, 1)
                .input(ModItems.MAHOGANY_BOAT)
                .input(Items.CHEST)
                .criterion(hasItem(ModItems.MAHOGANY_BOAT), conditionsFromItem(ModItems.MAHOGANY_BOAT))
                .criterion(hasItem(Items.CHEST), conditionsFromItem(Items.CHEST))
                .offerTo(exporter, Identifier.of(JaizMod.MOD_ID, "mahogany_chest_boat"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.ROTTEN_CHEST_BOAT, 1)
                .input(ModItems.ROTTEN_BOAT)
                .input(Items.CHEST)
                .criterion(hasItem(ModItems.ROTTEN_BOAT), conditionsFromItem(ModItems.ROTTEN_BOAT))
                .criterion(hasItem(Items.CHEST), conditionsFromItem(Items.CHEST))
                .offerTo(exporter, Identifier.of(JaizMod.MOD_ID, "rotten_chest_boat"));

    }
}