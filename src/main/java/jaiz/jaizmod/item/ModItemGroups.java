package jaiz.jaizmod.item;

import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup JUNGLE_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(JaizMod.MOD_ID, "jungle"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.jungle"))
                    .icon(() -> new ItemStack(Blocks.JUNGLE_LOG)).entries((displayContext, entries) -> {
                        // things go here
                        entries.add(ModBlocks.MAHOGANY_PLANKS);
                        entries.add(ModBlocks.MAHOGANY_STAIRS);
                        entries.add(ModBlocks.MAHOGANY_SLAB);
                        entries.add(ModBlocks.MAHOGANY_LOG);
                        entries.add(ModBlocks.MAHOGANY_LEAVES);
                        entries.add(ModBlocks.MAHOGANY_SAPLING);
                        entries.add(ModBlocks.MAHOGANY_WOOD);
                        entries.add(ModBlocks.STRIPPED_MAHOGANY_LOG);
                        entries.add(ModBlocks.STRIPPED_MAHOGANY_WOOD);
                        entries.add(ModBlocks.MAHOGANY_DOOR);
                        entries.add(ModBlocks.MAHOGANY_TRAPDOOR);
                        entries.add(ModBlocks.MAHOGANY_BUTTON);
                        entries.add(ModBlocks.MAHOGANY_PRESSURE_PLATE);
                        entries.add(ModBlocks.MAHOGANY_FENCE);
                        entries.add(ModBlocks.MAHOGANY_FENCE_GATE);
                        entries.add(ModItems.HANGING_MAHOGANY_SIGN);
                        entries.add(ModItems.MAHOGANY_SIGN);
                        entries.add(ModItems.MAHOGANY_BOAT);
                        entries.add(ModItems.MAHOGANY_CHEST_BOAT);
                        entries.add(ModBlocks.SLIMEY_STONE);
                        entries.add(ModBlocks.SLIME_DRIP);
                        entries.add(ModItems.GUANO);
                        entries.add(ModBlocks.GUANO_PILE);
                        entries.add(ModItems.FRUIT_BAT_SPAWN_EGG);


                    }).build());

    public static final ItemGroup PLANTS_AND_JUNK_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(JaizMod.MOD_ID, "plantsandjunk"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.plantsandjunk"))
                    .icon(() -> new ItemStack(Blocks.MOSS_BLOCK)).entries((displayContext, entries) -> {
                        // things go here
                        entries.add(ModItems.CATERPILLAR_SPAWN_EGG);
                        entries.add(ModItems.BUTTERFLY_SPAWN_EGG);
                        entries.add(ModItems.DRAGONFLY_SPAWN_EGG);
                        entries.add(ModItems.FIREFLY_SWARM_SPAWN_EGG);
                        entries.add(ModItems.SNAIL_SPAWN_EGG);
                        entries.add(ModBlocks.FIREFLY_BOTTLE);
                        entries.add(ModBlocks.ROTTEN_PLANKS);
                        entries.add(ModBlocks.ROTTEN_DOOR);
                        entries.add(ModBlocks.ROTTEN_TRAPDOOR);
                        entries.add(ModBlocks.ROTTEN_FENCE);
                        entries.add(ModBlocks.ROTTEN_FENCE_GATE);
                        entries.add(ModBlocks.ROTTEN_SLAB);
                        entries.add(ModBlocks.ROTTEN_STAIRS);
                        entries.add(ModItems.ROTTEN_SIGN);
                        entries.add(ModItems.HANGING_ROTTEN_SIGN);
                        entries.add(ModBlocks.ROT_BLOCK);
                        entries.add(ModBlocks.ROTTEN_LOG);
                        entries.add(ModBlocks.ROTTEN_WOOD);
                        entries.add(ModBlocks.STRIPPED_ROTTEN_LOG);
                        entries.add(ModBlocks.STRIPPED_ROTTEN_WOOD);
                        entries.add(ModItems.ROTTEN_BOAT);
                        entries.add(ModItems.ROTTEN_CHEST_BOAT);
                        entries.add(ModBlocks.SHELF_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.COCOON_BLOCK);
                        entries.add(ModBlocks.COLUMBINE);
                        entries.add(ModBlocks.CALLALILY_WHITE);
                        entries.add(ModBlocks.CALLALILY_LILAC);
                        entries.add(ModBlocks.CALLALILY_PINK);
                        entries.add(ModBlocks.CALLALILY_PURPLE);
                        entries.add(ModBlocks.CALLALILY_YELLOW);
                        entries.add(ModBlocks.IVY);
                        entries.add(ModBlocks.UNDERGROWTH);


                    }).build());


    public static final ItemGroup DESERT_UPDATE_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(JaizMod.MOD_ID, "desertmodupdate"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.desertmodupdate"))
                    .icon(() -> new ItemStack(Blocks.CACTUS)).entries((displayContext, entries) -> {
                        // things go here
                        entries.add(ModItems.SILK);
                        entries.add(ModItems.RARE_SPICES);
                        entries.add(ModItems.GOURMET_MEAL);
                        entries.add(ModItems.ORIGAMI_HAIRBALL_MUSIC_DISC);
                        entries.add(ModItems.BATTERED_AXE_REMNANT);
                        entries.add(ModItems.BATTERED_AXE);
                        entries.add(ModItems.OBSIDIAN_SHARD);
                        entries.add(ModItems.WEDGE_OBSIDIAN_SHARD);
                        entries.add(ModItems.SHARP_OBSIDIAN_SHARD);
                        entries.add(ModItems.OBSIDIAN_DAGGER);
                        entries.add(ModItems.WEDGE_OBSIDIAN_DAGGER);
                        entries.add(ModItems.SHARP_OBSIDIAN_DAGGER);
                        entries.add(ModItems.OBSIDIAN_SWORD);
                        entries.add(ModItems.WEDGE_OBSIDIAN_SWORD);
                        entries.add(ModItems.SHARP_OBSIDIAN_SWORD);
                        entries.add(ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD);
                        entries.add(ModItems.SHARP_WEDGE_OBSIDIAN_SWORD);
                        entries.add(ModItems.SHARP_REGULAR_OBSIDIAN_SWORD);
                        entries.add(ModItems.MIMIC_POT);
                        entries.add(ModItems.BANDIT_SPAWN_EGG);
                        entries.add(ModBlocks.FANCY_WHITE_WOOL);
                        entries.add(ModBlocks.FANCY_LIGHT_GRAY_WOOL);
                        entries.add(ModBlocks.FANCY_GRAY_WOOL);
                        entries.add(ModBlocks.FANCY_BLACK_WOOL);
                        entries.add(ModBlocks.FANCY_BROWN_WOOL);
                        entries.add(ModBlocks.FANCY_RED_WOOL);
                        entries.add(ModBlocks.FANCY_ORANGE_WOOL);
                        entries.add(ModBlocks.FANCY_YELLOW_WOOL);
                        entries.add(ModBlocks.FANCY_LIME_WOOL);
                        entries.add(ModBlocks.FANCY_GREEN_WOOL);
                        entries.add(ModBlocks.FANCY_CYAN_WOOL);
                        entries.add(ModBlocks.FANCY_LIGHT_BLUE_WOOL);
                        entries.add(ModBlocks.FANCY_BLUE_WOOL);
                        entries.add(ModBlocks.FANCY_PURPLE_WOOL);
                        entries.add(ModBlocks.FANCY_MAGENTA_WOOL);
                        entries.add(ModBlocks.FANCY_PINK_WOOL);
                        entries.add(ModBlocks.FANCY_WHITE_CARPET);
                        entries.add(ModBlocks.FANCY_LIGHT_GRAY_CARPET);
                        entries.add(ModBlocks.FANCY_GRAY_CARPET);
                        entries.add(ModBlocks.FANCY_BLACK_CARPET);
                        entries.add(ModBlocks.FANCY_BROWN_CARPET);
                        entries.add(ModBlocks.FANCY_RED_CARPET);
                        entries.add(ModBlocks.FANCY_ORANGE_CARPET);
                        entries.add(ModBlocks.FANCY_YELLOW_CARPET);
                        entries.add(ModBlocks.FANCY_LIME_CARPET);
                        entries.add(ModBlocks.FANCY_GREEN_CARPET);
                        entries.add(ModBlocks.FANCY_CYAN_CARPET);
                        entries.add(ModBlocks.FANCY_LIGHT_BLUE_CARPET);
                        entries.add(ModBlocks.FANCY_BLUE_CARPET);
                        entries.add(ModBlocks.FANCY_PURPLE_CARPET);
                        entries.add(ModBlocks.FANCY_MAGENTA_CARPET);
                        entries.add(ModBlocks.FANCY_PINK_CARPET);
                        entries.add(ModBlocks.GILDED_CHISELED_SANDSTONE);
                        entries.add(ModBlocks.GILDED_CUT_SANDSTONE);
                        entries.add(ModBlocks.GILDED_SANDSTONE);
                        entries.add(ModBlocks.TERRACOTTA_BRICKS);
                        entries.add(ModBlocks.TERRACOTTA_BRICK_STAIRS);
                        entries.add(ModBlocks.TERRACOTTA_BRICK_WALL);
                        entries.add(ModBlocks.TERRACOTTA_BRICK_SLAB);
                        entries.add(ModBlocks.DESERT_OAK_PLANKS);
                        entries.add(ModBlocks.DESERT_OAK_DOOR);
                        entries.add(ModBlocks.DESERT_OAK_TRAPDOOR);
                        entries.add(ModBlocks.DESERT_OAK_FENCE);
                        entries.add(ModBlocks.DESERT_OAK_FENCE_GATE);
                        entries.add(ModBlocks.DESERT_OAK_SLAB);
                        entries.add(ModBlocks.DESERT_OAK_STAIRS);
                        entries.add(ModItems.DESERT_OAK_SIGN);
                        entries.add(ModItems.HANGING_DESERT_OAK_SIGN);
                        entries.add(ModItems.DESERT_OAK_BOAT);
                        entries.add(ModItems.DESERT_OAK_CHEST_BOAT);
                        entries.add(ModBlocks.SPICE_BARREL);
                        entries.add(ModBlocks.DESERT_OAK_SAPLING);
                        entries.add(ModBlocks.DESERT_OAK_LEAVES);
                        entries.add(ModBlocks.DESERT_OAK_LOG);
                        entries.add(ModBlocks.DESERT_OAK_WOOD);
                        entries.add(ModBlocks.STRIPPED_DESERT_OAK_LOG);
                        entries.add(ModBlocks.STRIPPED_DESERT_OAK_WOOD);
                        entries.add(ModBlocks.FOSSIL_SOIL);
                        entries.add(ModBlocks.HONEYCOMB_DIRT);
                        entries.add(ModItems.AMETHYST_HORN);
                        entries.add(ModItems.AIR_HORN);
                        entries.add(ModItems.ANCIENT_HORN);


                    }).build());


    public static final ItemGroup GLOW_SQUID_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(JaizMod.MOD_ID, "glow_squid"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.glow_squid"))
                    .icon(() -> new ItemStack(Items.GLOW_INK_SAC)).entries((displayContext, entries) -> {
                        // things go here
                        entries.add(Items.GLOW_SQUID_SPAWN_EGG);
                        entries.add(Items.SQUID_SPAWN_EGG);
                        entries.add(ModItems.GLOWING_SPYGLASS);
                        entries.add(ModItems.WATER_TORCH);
                        entries.add(ModItems.GLOW_BALL);
                        entries.add(ModBlocks.BIOLUMINESCENT_BOTTLE);

                    }).build());

    public static final ItemGroup TEA_TIME_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(JaizMod.MOD_ID, "tea_time"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.tea_time"))
                    .icon(() -> new ItemStack(ModItems.TEA_CUP)).entries((displayContext, entries) -> {
                        // things go here
                        entries.add(ModBlocks.TEAPOTBLOCK);
                        entries.add(ModItems.UNFIRED_TEA_CUP);
                        entries.add(ModItems.TEA_CUP);
                        entries.add(ModItems.CHORUS_FRUIT_TEA);
                        entries.add(ModItems.FLOWER_TEA);
                        entries.add(ModItems.GLOW_BERRY_TEA);
                        entries.add(ModItems.GUNPOWDER_GREEN_TEA);
                        entries.add(ModItems.HERBAL_TEA);
                        entries.add(ModItems.KOMBUCHA_TEA);
                        entries.add(ModItems.NETHER_FUNGUS_TEA);
                        entries.add(ModItems.WARPED_NETHER_FUNGUS_TEA);
                        entries.add(ModItems.PITCHER_PLANT_TEA);
                        entries.add(ModItems.PUMPKIN_SPICE_TEA);
                        entries.add(ModItems.SPORE_BLOSSOM_TEA);
                        entries.add(ModItems.TORCH_FLOWER_TEA);
                        entries.add(ModItems.WITHER_ROSE_TEA);
                        entries.add(ModItems.NOVEL_TEA);

                    }).build());

    public static void registerItemGroups() {
        JaizMod.LOGGER.info("Registering Item Groups");
    }
}
