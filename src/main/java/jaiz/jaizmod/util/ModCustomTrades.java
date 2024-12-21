package jaiz.jaizmod.util;

import jaiz.jaizmod.item.ModItems;
import jaiz.jaizmod.villager.ModVillagers;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;

public class ModCustomTrades {
    public static void registerCustomTrades() {

        //tea
        TradeOfferHelper.registerVillagerOffers(ModVillagers.TEA_BREWER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 1),
                    new ItemStack(Items.CLAY_BALL, 3),
                    6, 2, 0.05f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.TEA_BREWER, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 3),
                    new ItemStack(Items.COAL, 12),
                    6, 7, 0.075f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 1),
                    new ItemStack(Items.COPPER_INGOT, 3),
                    6, 7, 0.075f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.COAL, 12),
                    new ItemStack(Items.EMERALD, 1),
                    6, 7, 0.075f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.COAL, 16),
                    new ItemStack(Items.EMERALD, 1),
                    6, 7, 0.075f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.COPPER_INGOT, 6),
                    new ItemStack(Items.EMERALD, 1),
                    6, 7, 0.075f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.TEA_CUP, 1),
                    new ItemStack(Items.EMERALD, 3),
                    6, 7, 0.075f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.FLOWER_TEA, 1),
                    new ItemStack(Items.EMERALD, 3),
                    6, 7, 0.075f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.HERBAL_TEA, 1),
                    new ItemStack(Items.EMERALD, 3),
                    6, 7, 0.075f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.TEA_BREWER, 3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 8),
                    new ItemStack(ModItems.TEA_CUP, 1),
                    4, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 4),
                    new ItemStack(ModItems.UNFIRED_TEA_CUP, 1),
                    4, 10, 0.05f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.TEA_BREWER, 4, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 3),
                    new ItemStack(ModItems.FLOWER_TEA, 1),
                    3, 16, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 3),
                    new ItemStack(ModItems.PITCHER_PLANT_TEA, 1),
                    3, 16, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 3),
                    new ItemStack(ModItems.SPORE_BLOSSOM_TEA, 1),
                    3, 16, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 3),
                    new ItemStack(ModItems.WARPED_NETHER_FUNGUS_TEA, 1),
                    3, 16, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 3),
                    new ItemStack(ModItems.KOMBUCHA_TEA, 1),
                    3, 16, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 3),
                    new ItemStack(ModItems.WITHER_ROSE_TEA, 1),
                    3, 16, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 3),
                    new ItemStack(ModItems.NETHER_FUNGUS_TEA, 1),
                    3, 16, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 3),
                    new ItemStack(ModItems.TORCH_FLOWER_TEA, 1),
                    3, 16, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 3),
                    new ItemStack(ModItems.CHORUS_FRUIT_TEA, 1),
                    3, 16, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 3),
                    new ItemStack(ModItems.PUMPKIN_SPICE_TEA, 1),
                    3, 16, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.PUMPKIN, 3),
                    new ItemStack(Items.EMERALD, 1),
                    3, 16, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.WHEAT, 12),
                    new ItemStack(Items.EMERALD, 1),
                    3, 16, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.WARPED_FUNGUS, 8),
                    new ItemStack(Items.EMERALD, 1),
                    3, 16, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.CRIMSON_FUNGUS, 8),
                    new ItemStack(Items.EMERALD, 1),
                    3, 16, 0.05f
            ));
        });


        //Spice trader
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SPICE_TRADER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 6),
                    new ItemStack(ModItems.RARE_SPICES, 1),
                    4, 1, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 12),
                    new ItemStack(Items.CHARCOAL, 3),
                    4, 1, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 1),
                    new ItemStack(Items.RAW_COPPER, 1),
                    12, 1, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 16),
                    new ItemStack(Items.SPECTRAL_ARROW, 4),
                    4, 5, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 1),
                    new ItemStack(Items.STICK, 1),
                    16, 1, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 1),
                    new ItemStack(Items.IRON_NUGGET, 3),
                    3, 2, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 3),
                    new ItemStack(Items.RAW_IRON, 1),
                    1, 2, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 1),
                    new ItemStack(Items.GOLD_NUGGET, 2),
                    8, 2, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 3),
                    new ItemStack(Items.RAW_GOLD, 1),
                    1, 2, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 6),
                    new ItemStack(Items.COBWEB, 1),
                    5, 2, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 8),
                    new ItemStack(Items.SHEARS, 1),
                    3, 2, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 20),
                    new ItemStack(Items.NAUTILUS_SHELL, 1),
                    8, 5, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 10),
                    new ItemStack(Items.DECORATED_POT, 1),
                    3, 2, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 1),
                    new ItemStack(Items.CARROT, 1),
                    12, 1, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 1),
                    new ItemStack(Items.POTATO, 1),
                    12, 1, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 1),
                    new ItemStack(Items.BEETROOT_SEEDS, 1),
                    12, 1, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 12),
                    new ItemStack(Items.BOOK, 3),
                    3, 1, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 6),
                    new ItemStack(Items.CLAY_BALL, 3),
                    6, 1, 0.05f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SPICE_TRADER, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 5),
                    new ItemStack(ModItems.RARE_SPICES, 1),
                    4, 3, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 3),
                    new ItemStack(Items.COPPER_INGOT, 1),
                    6, 5, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 2),
                    new ItemStack(Items.RAW_IRON, 3),
                    3, 6, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 2),
                    new ItemStack(Items.RAW_GOLD, 3),
                    3, 5, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 2),
                    new ItemStack(Items.WHITE_WOOL, 1),
                    12, 4, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 3),
                    new ItemStack(Items.LAPIS_LAZULI, 1),
                    16, 7, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 3),
                    new ItemStack(Items.FEATHER, 1),
                    16, 4, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 12),
                    new ItemStack(Items.LEAD, 1),
                    1, 5, 0.05f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SPICE_TRADER, 3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 3),
                    new ItemStack(Items.IRON_INGOT, 1),
                    3, 8, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 3),
                    new ItemStack(Items.GOLD_INGOT, 1),
                    3, 12, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 3),
                    new ItemStack(ModItems.SILK, 1),
                    3, 12, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 1),
                    new ItemStack(Items.AMETHYST_SHARD, 4),
                    6, 12, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 2),
                    new ItemStack(Items.FLINT, 1),
                    16, 17, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 3),
                    new ItemStack(Items.PAPER, 2),
                    6, 5, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 12),
                    new ItemStack(Items.BUCKET, 1),
                    3, 6, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 1),
                    new ItemStack(Items.BRICK, 4),
                    3, 6, 0.05f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SPICE_TRADER, 4, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 10),
                    new ItemStack(Items.RAW_IRON_BLOCK, 1),
                    2, 16, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 10),
                    new ItemStack(ModItems.OBSIDIAN_SHARD, 1),
                    2, 16, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 10),
                    new ItemStack(ModItems.SHARP_OBSIDIAN_SHARD, 1),
                    2, 16, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 10),
                    new ItemStack(ModItems.SHARP_OBSIDIAN_SHARD, 1),
                    2, 16, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 10),
                    new ItemStack(ModItems.WEDGE_OBSIDIAN_SHARD, 1),
                    2, 16, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 2),
                    new ItemStack(Items.STRING, 12),
                    2, 16, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 3),
                    new ItemStack(Items.ENDER_PEARL, 1),
                    2, 6, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 1),
                    new ItemStack(Items.COCOA_BEANS, 4),
                    3, 6, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 32),
                    new ItemStack(Items.CREEPER_BANNER_PATTERN, 1),
                    1, 12, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 32),
                    new ItemStack(Items.GLOBE_BANNER_PATTERN, 1),
                    1, 12, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 6),
                    new ItemStack(Items.DECORATED_POT, 1),
                    3, 12, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 8),
                    new ItemStack(Items.OBSIDIAN, 2),
                    3, 12, 0.05f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SPICE_TRADER, 5, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 15),
                    new ItemStack(Items.IRON_BLOCK, 1),
                    1, 19, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 40),
                    new ItemStack(ModItems.WEDGE_OBSIDIAN_DAGGER, 1),
                    1, 19, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 40),
                    new ItemStack(ModItems.SHARP_OBSIDIAN_DAGGER, 1),
                    1, 19, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 40),
                    new ItemStack(ModItems.OBSIDIAN_DAGGER, 1),
                    1, 19, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 1),
                    new ItemStack(ModItems.SILK, 1),
                    10, 7, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 2),
                    new ItemStack(ModItems.RARE_SPICES, 1),
                    10, 5, 0.5f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 3),
                    new ItemStack(ModItems.RARE_SPICES, 1),
                    10, 3, 0.5f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 1),
                    new ItemStack(ModItems.RARE_SPICES, 1),
                    5, 3, 2.0f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 3),
                    new ItemStack(Items.BRICK, 16),
                    6, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 3),
                    new ItemStack(Items.OBSIDIAN, 1),
                    4, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RARE_SPICES, 32),
                    new ItemStack(Items.MOJANG_BANNER_PATTERN, 1),
                    1, 10, 0.05f
            ));
        });

    }
}
