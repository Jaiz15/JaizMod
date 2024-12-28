package jaiz.jaizmod.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.entity.ModEntities;
import jaiz.jaizmod.entity.boats.ModBoats;
import jaiz.jaizmod.item.custom.*;
import jaiz.jaizmod.item.custom.ancient_horns.AmethystHornItem;
import jaiz.jaizmod.item.custom.ancient_horns.AirHornItem;
import jaiz.jaizmod.item.custom.ancient_horns.AncientHornItem;
import jaiz.jaizmod.item.custom.GlowingSpyGlassItem;
import jaiz.jaizmod.item.custom.teas.*;
import jaiz.jaizmod.sound.ModSounds;
import jaiz.jaizmod.trim.ModTrimPatterns;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.InstrumentTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Direction;


import static net.minecraft.item.Items.register;

public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(JaizMod.MOD_ID, name), item);
    }

    public static final Item PETRIFIED_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("petrified_armor_trim_smithing_template", SmithingTemplateItem.of(ModTrimPatterns.PETRIFIED));

    public static final Item GLOWING_SPYGLASS = registerItem("glowing_spyglass", new GlowingSpyGlassItem(new Item.Settings().maxCount(1)));

    public static final Item MAHOGANY_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.MAHOGANY_BOAT_ID, ModBoats.MAHOGANY_BOAT, false);
    public static final Item MAHOGANY_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.MAHOGANY_CHEST_BOAT_ID, ModBoats.MAHOGANY_BOAT, true);

    public static final Item DESERT_OAK_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.DESERT_OAK_BOAT_ID, ModBoats.DESERT_OAK_BOAT, false);
    public static final Item DESERT_OAK_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.DESERT_OAK_CHEST_BOAT_ID, ModBoats.DESERT_OAK_BOAT, true);

    public static final Item ROTTEN_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.ROTTEN_BOAT_ID, ModBoats.ROTTEN_BOAT, false);
    public static final Item ROTTEN_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.ROTTEN_CHEST_BOAT_ID, ModBoats.ROTTEN_BOAT, true);





    public static final Item WATER_TORCH = register(new VerticallyAttachableBlockItem(ModBlocks.WATER_TORCH, ModBlocks.WALL_WATER_TORCH, new Item.Settings(), Direction.DOWN));

    public static final Item FRUIT_BAT_SPAWN_EGG = registerItem("fruit_bat_spawn_egg", new SpawnEggItem(ModEntities.FRUIT_BAT, 0x341609, 0xe9c79a, new Item.Settings()));
    public static final Item GUANO = registerItem("guano", new GuanoItem(new Item.Settings()));
    public static final Item GLOW_BALL = registerItem("glowball", new GlowBallItem(new Item.Settings()));


    public static final Item MAHOGANY_SIGN = registerItem("mahogany_sign", new SignItem(new Item.Settings().maxCount(16), ModBlocks.STANDING_MAHOGANY_SIGN, ModBlocks.WALL_MAHOGANY_SIGN));
    public static final Item HANGING_MAHOGANY_SIGN = registerItem("mahogany_hanging_sign", new HangingSignItem(ModBlocks.HANGING_MAHOGANY_SIGN, ModBlocks.WALL_HANGING_MAHOGANY_SIGN, new Item.Settings().maxCount(16)));

    public static final Item SNAIL_SPAWN_EGG = registerItem("snail_spawn_egg", new SpawnEggItem(ModEntities.SNAIL, 0x4F3420, 0xEAE4B0, new Item.Settings()));
    public static final Item CATERPILLAR_SPAWN_EGG = registerItem("caterpillar_spawn_egg", new SpawnEggItem(ModEntities.CATERPILLAR, 0x308723, 0xF0DA1B, new Item.Settings()));
    public static final Item BUTTERFLY_SPAWN_EGG = registerItem("butterfly_spawn_egg", new SpawnEggItem(ModEntities.BUTTERFLY, 0x261007, 0xD56C24, new Item.Settings()));
    public static final Item FIREFLY_SWARM_SPAWN_EGG = registerItem("firefly_swarm_spawn_egg", new SpawnEggItem(ModEntities.FIRE_FLY_SWARM, 0x0E0709, 0x9DFF18, new Item.Settings()));
    public static final Item DRAGONFLY_SPAWN_EGG = registerItem("dragonfly_spawn_egg", new SpawnEggItem(ModEntities.DRAGONFLY, 0x2C0818, 0x658DD3, new Item.Settings()));

    public static final Item ROTTEN_SIGN = registerItem("rotten_sign", new SignItem(new Item.Settings().maxCount(16), ModBlocks.STANDING_ROTTEN_SIGN, ModBlocks.WALL_ROTTEN_SIGN));
    public static final Item HANGING_ROTTEN_SIGN = registerItem("rotten_hanging_sign", new HangingSignItem(ModBlocks.HANGING_ROTTEN_SIGN, ModBlocks.WALL_HANGING_ROTTEN_SIGN, new Item.Settings().maxCount(16)));

    public static final Item SILK = registerItem("silk", new Item(new Item.Settings()));
    public static final Item BATTERED_AXE_REMNANT = registerItem("battered_axe_remnant", new Item(new Item.Settings()));

    public static final Item AMETHYST_HORN = registerItem("amethyst_horn", new AmethystHornItem(new Item.Settings().maxCount(1).maxDamage(64), InstrumentTags.GOAT_HORNS));
    public static final Item AIR_HORN = registerItem("air_horn", new AirHornItem(new Item.Settings().maxCount(1).maxDamage(64), InstrumentTags.GOAT_HORNS));
    public static final Item ANCIENT_HORN = registerItem("ancient_horn", new AncientHornItem(new Item.Settings().maxCount(1).maxDamage(64), InstrumentTags.GOAT_HORNS));

    public static final Item RARE_SPICES = registerItem("rare_spices", new Item(new Item.Settings().food(ModFoodComponents.RARE_SPICES)));
    public static final Item GOURMET_MEAL = registerItem("gourmet_meal", new Item(new Item.Settings().food(ModFoodComponents.GOURMET_MEAL).maxCount(16)));
    public static final Item OBSIDIAN_SHARD = registerItem("obsidian_shard", new Item(new Item.Settings()));
    public static final Item SHARP_OBSIDIAN_SHARD = registerItem("sharp_obsidian_shard", new Item(new Item.Settings()));
    public static final Item WEDGE_OBSIDIAN_SHARD = registerItem("wedge_obsidian_shard", new Item(new Item.Settings()));
    public static final Item MIMIC_POT = registerItem("mimic_pot", new SpawnEggItem(ModEntities.MASON_MOUTH, 0xFFFFFF, 0xFFFFFF, new Item.Settings().maxCount(1)));
    public static final Item BANDIT_SPAWN_EGG = registerItem("bandit_spawn_egg", new SpawnEggItem(ModEntities.BANDIT, 0xD3B081, 0x715F3B, new Item.Settings()));

    public static final Item UNFIRED_TEA_CUP = registerItem("unfired_tea_cup", new Item(new Item.Settings().maxCount(1)));
    public static final Item TEA_CUP = registerItem("tea_cup", new Item(new Item.Settings().maxCount(1)));
    public static final Item CHORUS_FRUIT_TEA = registerItem("chorus_fruit_tea", new ChorusTeaItem(new Item.Settings().food(ModFoodComponents.CHORUS_TEA).maxCount(1)));
    public static final Item NOVEL_TEA = registerItem("novel_tea", new NovelTeaItem(new Item.Settings().food(ModFoodComponents.TEA).maxCount(1)));
    public static final Item FLOWER_TEA = registerItem("flower_tea", new TeaItem(new Item.Settings().food(ModFoodComponents.TEA).maxCount(1)));
    public static final Item GLOW_BERRY_TEA = registerItem("glow_berry_tea", new TeaItem(new Item.Settings().food(ModFoodComponents.GLOW_BERRY_TEA).maxCount(1)));
    public static final Item GUNPOWDER_GREEN_TEA = registerItem("gunpowder_green_tea", new GunPowderTeaItem(new Item.Settings().food(ModFoodComponents.TEA).maxCount(1)));
    public static final Item HERBAL_TEA = registerItem("herbal_tea", new TeaItem(new Item.Settings().food(ModFoodComponents.TEA).maxCount(1)));
    public static final Item KOMBUCHA_TEA = registerItem("kombucha_tea", new TeaItem(new Item.Settings().food(ModFoodComponents.TEA).maxCount(1)));
    public static final Item NETHER_FUNGUS_TEA = registerItem("nether_fungus_tea", new TeaItem(new Item.Settings().food(ModFoodComponents.NETHER_FUNGAL_TEA).maxCount(1)));
    public static final Item WARPED_NETHER_FUNGUS_TEA = registerItem("warped_nether_fungus_tea", new TeaItem(new Item.Settings().food(ModFoodComponents.NETHER_FUNGAL_TEA).maxCount(1)));
    public static final Item PITCHER_PLANT_TEA = registerItem("pitcher_plant_tea", new TeaItem(new Item.Settings().food(ModFoodComponents.PITCHER_PLANT_TEA).maxCount(1)));
    public static final Item PUMPKIN_SPICE_TEA = registerItem("pumpkin_spice_tea", new TeaItem(new Item.Settings().food(ModFoodComponents.TEA).maxCount(1)));
    public static final Item SPORE_BLOSSOM_TEA = registerItem("spore_blossom_tea", new TeaItem(new Item.Settings().food(ModFoodComponents.SPORE_BLOSSOM_TEA).maxCount(1)));
    public static final Item TORCH_FLOWER_TEA = registerItem("torch_flower_tea", new TeaItem(new Item.Settings().food(ModFoodComponents.TORCH_FLOWER_TEA).maxCount(1)));
    public static final Item WITHER_ROSE_TEA = registerItem("wither_rose_tea", new WitherTeaItem(new Item.Settings().food(ModFoodComponents.WITHER_ROSE_TEA).maxCount(1)));


    public static final Item MACUAHUITL = registerItem(
            "macuahuitl",
            new MayanSwordItem(
                    ModToolMaterial.MAYAN_SWORD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.OBSIDIAN_SWORD, 6, -3.5f))
            )
    );

    public static final Item OBSIDIAN_SWORD = registerItem(
            "obsidian_sword",
            new SwordItem(
                    ModToolMaterial.OBSIDIAN_SWORD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.OBSIDIAN_SWORD, 2, -2.4f))
            )
    );
    public static final Item SHARP_OBSIDIAN_SWORD = registerItem(
            "sharp_obsidian_sword",
            new SwordItem(
                    ModToolMaterial.SHARP_OBSIDIAN_SWORD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.SHARP_OBSIDIAN_SWORD, 2, -2.0f))
            )
    );
    public static final Item WEDGE_OBSIDIAN_SWORD = registerItem(
            "wedge_obsidian_sword",
            new SwordItem(
                    ModToolMaterial.WEDGE_OBSIDIAN_SWORD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.WEDGE_OBSIDIAN_SWORD, 1, -2.8f))
            )
    );

    public static final Item WEDGE_REGULAR_OBSIDIAN_SWORD = registerItem(
            "wedge_regular_obsidian_sword",
            new SwordItem(
                    ModToolMaterial.WEDGE_REGULAR_OBSIDIAN_SWORD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.WEDGE_REGULAR_OBSIDIAN_SWORD, 2, -2.8f))
            )
    );
    public static final Item SHARP_REGULAR_OBSIDIAN_SWORD = registerItem(
            "sharp_regular_obsidian_sword",
            new SwordItem(
                    ModToolMaterial.SHARP_REGULAR_OBSIDIAN_SWORD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.SHARP_REGULAR_OBSIDIAN_SWORD, 3, -2.0f))
            )
    );
    public static final Item SHARP_WEDGE_OBSIDIAN_SWORD = registerItem(
            "sharp_wedge_obsidian_sword",
            new SwordItem(
                    ModToolMaterial.SHARP_WEDGE_OBSIDIAN_SWORD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.SHARP_WEDGE_OBSIDIAN_SWORD, 3, -3.2f))
            )
    );

    public static final Item OBSIDIAN_DAGGER = registerItem(
            "obsidian_dagger",
            new SwordItem(
                    ModToolMaterial.OBSIDIAN_DAGGER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.OBSIDIAN_DAGGER, 2, -2.4f))
            )
    );
    public static final Item SHARP_OBSIDIAN_DAGGER = registerItem(
            "sharp_obsidian_dagger",
            new SwordItem(
                    ModToolMaterial.SHARP_OBSIDIAN_DAGGER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.SHARP_OBSIDIAN_DAGGER, 2, -2.0f))
            )
    );
    public static final Item WEDGE_OBSIDIAN_DAGGER = registerItem(
            "wedge_obsidian_dagger",
            new SwordItem(
                    ModToolMaterial.WEDGE_OBSIDIAN_DAGGER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.WEDGE_OBSIDIAN_DAGGER, 3, -2.8f))
            )
    );

    public static final Item BATTERED_AXE = registerItem(
            "battered_axe",
            new AxeItem(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterial.BATTERED, 5.0F, -2.8f)))
    );

    public static final Item ORIGAMI_HAIRBALL_MUSIC_DISC = registerItem("origami_hairball_music_disc", new Item(new Item.Settings().jukeboxPlayable(ModSounds.of("origami_hairball")).rarity(Rarity.RARE).maxCount(1)));

    public static final Item DESERT_OAK_SIGN = registerItem("desert_oak_sign", new SignItem(new Item.Settings().maxCount(16), ModBlocks.STANDING_DESERT_OAK_SIGN, ModBlocks.WALL_DESERT_OAK_SIGN));
    public static final Item HANGING_DESERT_OAK_SIGN = registerItem("hanging_desert_oak_sign", new HangingSignItem(ModBlocks.HANGING_DESERT_OAK_SIGN, ModBlocks.WALL_HANGING_DESERT_OAK_SIGN, new Item.Settings().maxCount(16)));





    public static void registerModItems() {
        JaizMod.LOGGER.info("Registering Mod Items for " + JaizMod.MOD_ID);
    }
}
