package jaiz.jaizmod.block;

import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.block.blockentities.WaterTickingBlock;
import jaiz.jaizmod.block.custom.*;
import jaiz.jaizmod.worldgen.features.ModConfiguredFeatures;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModBlocks {
    public static final IntProperty SIZE = IntProperty.of("size", 0, 2);
    public static final IntProperty ROTTING = IntProperty.of("rotting", 0, 1);
    public static final BooleanProperty HAS_CUP = BooleanProperty.of("has_cup");

    public static final Block TEAPOTBLOCK = registerBlock("tea_pot_block", new TeaPotBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).luminance(state -> 13).nonOpaque()));

    public static final Block BIOLUMINESCENT_BOTTLE = registerBlock("bioluminescent_bottle",
            new BioluminescentBottleBlock(AbstractBlock.Settings.copy(Blocks.GLASS).sounds(BlockSoundGroup.GLASS).luminance(state -> 15)));

    public static final Block WATER_TEMPORARY_LIGHT = registerBlock("water_temporary_light", new WaterTickingBlock(AbstractBlock.Settings.create()
            .replaceable().noCollision().liquid().strength(-1.0F, 3600000.8F).mapColor(MapColor.CLEAR).dropsNothing()
            .nonOpaque().luminance(state -> 7)));

    public static final Block AMETHYST_THORN = registerBlock("amethyst_thorn",
            new AmethystThornBlock(AbstractBlock.Settings.copy(Blocks.AMETHYST_CLUSTER).sounds(BlockSoundGroup.AMETHYST_CLUSTER).ticksRandomly().noCollision()));

    public static final Block FANCY_WHITE_WOOL = registerBlock("fancy_white_wool",
            new Block(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_BLUE_WOOL = registerBlock("fancy_blue_wool",
            new Block(AbstractBlock.Settings.copy(Blocks.BLUE_WOOL).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_CYAN_WOOL = registerBlock("fancy_cyan_wool",
            new Block(AbstractBlock.Settings.copy(Blocks.CYAN_WOOL).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_LIGHT_BLUE_WOOL = registerBlock("fancy_light_blue_wool",
            new Block(AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_WOOL).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_BROWN_WOOL = registerBlock("fancy_brown_wool",
            new Block(AbstractBlock.Settings.copy(Blocks.BROWN_WOOL).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_PINK_WOOL = registerBlock("fancy_pink_wool",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_WOOL).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_MAGENTA_WOOL = registerBlock("fancy_magenta_wool",
            new Block(AbstractBlock.Settings.copy(Blocks.MAGENTA_WOOL).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_PURPLE_WOOL = registerBlock("fancy_purple_wool",
            new Block(AbstractBlock.Settings.copy(Blocks.PURPLE_WOOL).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_BLACK_WOOL = registerBlock("fancy_black_wool",
            new Block(AbstractBlock.Settings.copy(Blocks.BLACK_WOOL).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_LIGHT_GRAY_WOOL = registerBlock("fancy_light_gray_wool",
            new Block(AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_WOOL).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_GRAY_WOOL = registerBlock("fancy_gray_wool",
            new Block(AbstractBlock.Settings.copy(Blocks.GRAY_WOOL).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_LIME_WOOL = registerBlock("fancy_lime_wool",
            new Block(AbstractBlock.Settings.copy(Blocks.LIME_WOOL).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_GREEN_WOOL = registerBlock("fancy_green_wool",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.GREEN_WOOL).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_ORANGE_WOOL = registerBlock("fancy_orange_wool",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.ORANGE_WOOL).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_RED_WOOL = registerBlock("fancy_red_wool",
            new Block(AbstractBlock.Settings.copy(Blocks.RED_WOOL).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_YELLOW_WOOL = registerBlock("fancy_yellow_wool",
            new Block(AbstractBlock.Settings.copy(Blocks.YELLOW_WOOL).sounds(BlockSoundGroup.WOOL)));

    //Carpets

    public static final Block FANCY_WHITE_CARPET = registerBlock("fancy_white_carpet",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.WHITE_CARPET).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_BLUE_CARPET = registerBlock("fancy_blue_carpet",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.BLUE_CARPET).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_CYAN_CARPET = registerBlock("fancy_cyan_carpet",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.CYAN_CARPET).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_LIGHT_BLUE_CARPET = registerBlock("fancy_light_blue_carpet",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_CARPET).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_BROWN_CARPET = registerBlock("fancy_brown_carpet",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.BROWN_CARPET).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_PINK_CARPET = registerBlock("fancy_pink_carpet",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.PINK_CARPET).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_MAGENTA_CARPET = registerBlock("fancy_magenta_carpet",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.MAGENTA_CARPET).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_PURPLE_CARPET = registerBlock("fancy_purple_carpet",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.PURPLE_CARPET).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_BLACK_CARPET = registerBlock("fancy_black_carpet",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.BLACK_CARPET).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_LIGHT_GRAY_CARPET = registerBlock("fancy_light_gray_carpet",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_CARPET).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_GRAY_CARPET = registerBlock("fancy_gray_carpet",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.GRAY_CARPET).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_LIME_CARPET = registerBlock("fancy_lime_carpet",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.LIME_CARPET).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_GREEN_CARPET = registerBlock("fancy_green_carpet",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.GREEN_CARPET).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_ORANGE_CARPET = registerBlock("fancy_orange_carpet",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.ORANGE_CARPET).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_RED_CARPET = registerBlock("fancy_red_carpet",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.RED_CARPET).sounds(BlockSoundGroup.WOOL)));
    public static final Block FANCY_YELLOW_CARPET = registerBlock("fancy_yellow_carpet",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.YELLOW_CARPET).sounds(BlockSoundGroup.WOOL)));

    //sandstone

    public static final Block GILDED_SANDSTONE = registerBlock("gilded_sandstone",
            new Block(AbstractBlock.Settings.copy(Blocks.GILDED_BLACKSTONE).sounds(BlockSoundGroup.GILDED_BLACKSTONE).requiresTool()));
    public static final Block GILDED_CUT_SANDSTONE = registerBlock("gilded_cut_sandstone",
            new Block(AbstractBlock.Settings.copy(Blocks.GILDED_BLACKSTONE).sounds(BlockSoundGroup.GILDED_BLACKSTONE).requiresTool()));
    public static final Block GILDED_CHISELED_SANDSTONE = registerBlock("gilded_chiseled_sandstone",
            new Block(AbstractBlock.Settings.copy(Blocks.GILDED_BLACKSTONE).sounds(BlockSoundGroup.GILDED_BLACKSTONE).requiresTool()));


    public static final Block DESERT_OAK_LOG = registerBlock("desert_oak_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).strength(3f)));

    public static final SaplingGenerator DESERT_OAK = new SaplingGenerator("desert_oak",
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.DESERT_OAK_KEY),
            Optional.empty());
    public static final Block DESERT_OAK_SAPLING = registerBlock("desert_oak_sapling",
            new SaplingBlock(DESERT_OAK, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    public static final Block DESERT_OAK_WOOD = registerBlock("desert_oak_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).strength(3f)));

    public static final Block STRIPPED_DESERT_OAK_LOG = registerBlock("stripped_desert_oak_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).strength(3f)));

    public static final Block STRIPPED_DESERT_OAK_WOOD = registerBlock("stripped_desert_oak_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));

    public static final Block DESERT_OAK_PLANKS = registerBlock("desert_oak_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).strength(3f)));

    public static final Block DESERT_OAK_BUTTON = registerBlock("desert_oak_button",
            new ButtonBlock(BlockSetType.OAK, 10, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)));
    public static final Block DESERT_OAK_PRESSURE_PLATE = registerBlock("desert_oak_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE)));

    public static final Block DESERT_OAK_LEAVES = registerBlock("desert_oak_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).nonOpaque()));

    public static final Identifier DESERT_OAK_SIGN_TEXTURE = Identifier.of(JaizMod.MOD_ID, "entity/signs/desert_oak");
    public static final Identifier DESERT_OAK_HANGING_SIGN_TEXTURE = Identifier.of(JaizMod.MOD_ID, "entity/signs/hanging/desert_oak");
    public static final Identifier DESERT_OAK_HANGING_GUI_SIGN_TEXTURE = Identifier.of(JaizMod.MOD_ID, "textures/gui/hanging_signs/desert_oak");

    public static final Block STANDING_DESERT_OAK_SIGN = Registry.register(Registries.BLOCK, Identifier.of(JaizMod.MOD_ID, "desert_oak_standing_sign"),
            new TerraformSignBlock(DESERT_OAK_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)));

    public static final Block WALL_DESERT_OAK_SIGN = Registry.register(Registries.BLOCK, Identifier.of(JaizMod.MOD_ID, "desert_oak_wall_sign"),
            new TerraformWallSignBlock(DESERT_OAK_SIGN_TEXTURE, AbstractBlock.Settings.copy(ModBlocks.STANDING_DESERT_OAK_SIGN)));

    public static final Block HANGING_DESERT_OAK_SIGN = Registry.register(Registries.BLOCK, Identifier.of(JaizMod.MOD_ID, "desert_oak_hanging_sign"),
            new TerraformHangingSignBlock(DESERT_OAK_HANGING_SIGN_TEXTURE, DESERT_OAK_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)));

    public static final Block WALL_HANGING_DESERT_OAK_SIGN = Registry.register(Registries.BLOCK, Identifier.of(JaizMod.MOD_ID, "desert_oak_wall_hanging_sign"),
            new TerraformWallHangingSignBlock(DESERT_OAK_HANGING_SIGN_TEXTURE, DESERT_OAK_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copy(ModBlocks.HANGING_DESERT_OAK_SIGN)));

    // Fancy Bits for the desert oak
    public static final Block DESERT_OAK_STAIRS = registerBlock("desert_oak_stairs",
            new StairsBlock(ModBlocks.DESERT_OAK_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));
    public static final Block DESERT_OAK_SLAB = registerBlock("desert_oak_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));

    public static final Block DESERT_OAK_FENCE = registerBlock("desert_oak_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block DESERT_OAK_FENCE_GATE = registerBlock("desert_oak_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block DESERT_OAK_DOOR = registerBlock("desert_oak_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block DESERT_OAK_TRAPDOOR = registerBlock("desert_oak_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));


    public static final BlockFamily DESERT_OAK_FAMILY = BlockFamilies.register(ModBlocks.DESERT_OAK_PLANKS)
            .sign(ModBlocks.STANDING_DESERT_OAK_SIGN, ModBlocks.WALL_DESERT_OAK_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();


    public static final Block TERRACOTTA_BRICKS = registerBlock("terracotta_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.TERRACOTTA).requiresTool()));

    public static final BlockFamily TERRACOTTA_BRICK_FAMILY = BlockFamilies.register(ModBlocks.TERRACOTTA_BRICKS)
            .group("terracotta_group").build();



    public static final Block FOSSIL_SOIL = registerBlock(
            "fossil_soil",
            new FossilSoilBlock(
                    Blocks.AIR,
                    SoundEvents.ITEM_BRUSH_BRUSHING_GRAVEL,
                    SoundEvents.BLOCK_GRAVEL_BREAK,
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.BROWN)
                            .instrument(NoteBlockInstrument.SNARE)
                            .strength(0.25F)
                            .sounds(BlockSoundGroup.SUSPICIOUS_GRAVEL)
                            .pistonBehavior(PistonBehavior.DESTROY)
            )
    );

    public static final Block HONEYCOMB_DIRT = registerBlock("honeycomb_dirt",
            new Block(AbstractBlock.Settings.copy(Blocks.COARSE_DIRT).strength(2f)));

    public static final Block TERRACOTTA_BRICK_STAIRS = registerBlock("terracotta_brick_stairs",
            new StairsBlock(ModBlocks.TERRACOTTA_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.STONE_BRICK_STAIRS).requiresTool()));

    public static final Block TERRACOTTA_BRICK_SLAB = registerBlock("terracotta_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICK_SLAB).requiresTool()));

    public static final Block TERRACOTTA_BRICK_WALL= registerBlock("terracotta_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICK_WALL).requiresTool()));

    public static final Block SPICE_BARREL = registerBlock("spice_barrel",
            new SpiceBarrelBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));


    public static final Block GUANO_PILE = registerBlock("guano_block",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.MOSS_CARPET).nonOpaque()
                    .noCollision().sounds(BlockSoundGroup.HONEY).velocityMultiplier(0.75f)));

    public static final Block SLIME_DRIP = registerBlock("slime_drip",
            new HangingRootsBlock(AbstractBlock.Settings.copy(Blocks.HANGING_ROOTS).nonOpaque()
                    .noCollision().sounds(BlockSoundGroup.SLIME)));

    public static final Block SLIMEY_STONE = registerBlock("slimey_stone",
            new SlimeDripBlock(AbstractBlock.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.STONE).ticksRandomly()));

    //mahogany wood

    public static final Block MAHOGANY_LEAVES = registerBlock("mahogany_leaves", createLeavesBlock(BlockSoundGroup.GRASS));
    public static Block createLeavesBlock(BlockSoundGroup soundGroup) {
        return new LeavesBlock(
                AbstractBlock.Settings.create()
                        .mapColor(MapColor.DARK_GREEN)
                        .strength(0.2F)
                        .ticksRandomly()
                        .sounds(soundGroup)
                        .nonOpaque()
                        .allowsSpawning(Blocks::canSpawnOnLeaves)
                        .suffocates(Blocks::never)
                        .blockVision(Blocks::never)
                        .burnable()
                        .pistonBehavior(PistonBehavior.DESTROY)
                        .solidBlock(Blocks::never)
        );
    }

    public static final Block MAHOGANY_LOG = registerBlock("mahogany_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).burnable()));

    public static final Block MAHOGANY_WOOD = registerBlock("mahogany_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).burnable()));

    public static final Block STRIPPED_MAHOGANY_LOG = registerBlock("stripped_mahogany_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).burnable()));

    public static final Block STRIPPED_MAHOGANY_WOOD = registerBlock("stripped_mahogany_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).burnable()));

    public static final Block MAHOGANY_PLANKS = registerBlock("mahogany_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).burnable()));

    public static final Block MAHOGANY_BUTTON = registerBlock("mahogany_button",
            new ButtonBlock(BlockSetType.OAK, 10, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON).burnable()));
    public static final Block MAHOGANY_PRESSURE_PLATE = registerBlock("mahogany_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE).burnable()));

    public static final Identifier MAHOGANY_SIGN_TEXTURE = Identifier.of(JaizMod.MOD_ID, "entity/signs/mahogany");
    public static final Identifier MAHOGANY_HANGING_SIGN_TEXTURE = Identifier.of(JaizMod.MOD_ID, "entity/signs/hanging/mahogany");
    public static final Identifier MAHOGANY_HANGING_GUI_SIGN_TEXTURE = Identifier.of(JaizMod.MOD_ID, "textures/gui/hanging_signs/mahogany");

    public static final Block STANDING_MAHOGANY_SIGN = Registry.register(Registries.BLOCK, Identifier.of(JaizMod.MOD_ID, "mahogany_standing_sign"),
            new TerraformSignBlock(MAHOGANY_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)));

    public static final Block WALL_MAHOGANY_SIGN = Registry.register(Registries.BLOCK, Identifier.of(JaizMod.MOD_ID, "mahogany_wall_sign"),
            new TerraformWallSignBlock(MAHOGANY_SIGN_TEXTURE, AbstractBlock.Settings.copy(ModBlocks.STANDING_MAHOGANY_SIGN)));

    public static final Block HANGING_MAHOGANY_SIGN = Registry.register(Registries.BLOCK, Identifier.of(JaizMod.MOD_ID, "mahogany_hanging_sign"),
            new TerraformHangingSignBlock(MAHOGANY_HANGING_SIGN_TEXTURE, MAHOGANY_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)));

    public static final Block WALL_HANGING_MAHOGANY_SIGN = Registry.register(Registries.BLOCK, Identifier.of(JaizMod.MOD_ID, "mahogany_wall_hanging_sign"),
            new TerraformWallHangingSignBlock(MAHOGANY_HANGING_SIGN_TEXTURE, MAHOGANY_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copy(ModBlocks.HANGING_MAHOGANY_SIGN)));

    public static final Block MAHOGANY_STAIRS = registerBlock("mahogany_stairs",
            new StairsBlock(ModBlocks.MAHOGANY_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).burnable()));
    public static final Block MAHOGANY_SLAB = registerBlock("mahogany_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).burnable()));

    public static final Block MAHOGANY_FENCE = registerBlock("mahogany_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).burnable()));
    public static final Block MAHOGANY_FENCE_GATE = registerBlock("mahogany_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).burnable()));

    public static final Block MAHOGANY_DOOR = registerBlock("mahogany_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque().burnable()));
    public static final Block MAHOGANY_TRAPDOOR = registerBlock("mahogany_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque().burnable()));

    public static final SaplingGenerator MAHOGANY = new SaplingGenerator("mahogany_tree",
            Optional.of(ModConfiguredFeatures.MAHOGANY_TREE),
            Optional.empty(),
            Optional.empty());
    public static final Block MAHOGANY_SAPLING = registerBlock("mahogany_sapling",
            new SaplingBlock(MAHOGANY, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    public static final BlockFamily MAHOGANY_FAMILY = BlockFamilies.register(ModBlocks.MAHOGANY_PLANKS)
            .sign(ModBlocks.STANDING_MAHOGANY_SIGN, ModBlocks.WALL_MAHOGANY_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();


    public static final Block FIREFLY_BOTTLE = registerBlock("firefly_bottle",
            new FireflyBottleBlock(AbstractBlock.Settings.copy(Blocks.GLASS).sounds(BlockSoundGroup.GLASS).luminance(state -> 15)));

    public static final Block COCOON_BLOCK = registerBlock("cocoon_block",
            new CocoonBlock(AbstractBlock.Settings.copy(Blocks.HONEY_BLOCK).sounds(BlockSoundGroup.HONEY)));

    public static final Block ROT_BLOCK = registerBlock("rot_block",
            new RotBlock(AbstractBlock.Settings.copy(Blocks.DIRT).sounds(BlockSoundGroup.WET_GRASS).ticksRandomly()));

    public static final Block IVY = registerBlock("ivy",
            new IvyBlock(AbstractBlock.Settings.copy(Blocks.VINE).sounds(BlockSoundGroup.VINE).ticksRandomly()));

    public static final Block UNDERGROWTH = registerBlock("undergrowth",
            new UndergrowthBlock(AbstractBlock.Settings.copy(Blocks.MOSS_CARPET).sounds(BlockSoundGroup.WET_GRASS).noCollision().breakInstantly()));


    public static final Block SHELF_MUSHROOM_BLOCK = registerBlock("shelf_mushroom",
            new ShelfMushroomBlock(AbstractBlock.Settings.copy(Blocks.MUSHROOM_STEM).sounds(BlockSoundGroup.SHROOMLIGHT)));

    public static final Block CALLALILY_WHITE = registerBlock("callalily_white",
            new TallFlowerBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).burnable().pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block CALLALILY_PINK = registerBlock("callalily_pink",
            new TallFlowerBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).burnable().pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block CALLALILY_YELLOW = registerBlock("callalily_yellow",
            new TallFlowerBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).burnable().pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block CALLALILY_LILAC = registerBlock("callalily_lilac",
            new TallFlowerBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).burnable().pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block CALLALILY_PURPLE = registerBlock("callalily_purple",
            new TallFlowerBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).burnable().pistonBehavior(PistonBehavior.DESTROY)));


    public static final Block COLUMBINE = registerBlock("columbine",
            new FlowerBlock(StatusEffects.DARKNESS, 60, AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));

    //Rotten Wood

    public static final Block ROTTEN_LOG = registerBlock("rotten_log",
            new RottingLog(AbstractBlock.Settings.copy(Blocks.OAK_LOG).strength(2f).burnable().ticksRandomly()));

    public static final Block ROTTEN_WOOD = registerBlock("rotten_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).strength(2f).burnable()));

    public static final Block STRIPPED_ROTTEN_LOG = registerBlock("stripped_rotten_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).strength(2f).burnable()));

    public static final Block STRIPPED_ROTTEN_WOOD = registerBlock("stripped_rotten_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).strength(2f).burnable()));

    public static final Block ROTTEN_PLANKS = registerBlock("rotten_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).strength(2f).burnable()));

    public static final Block ROTTEN_BUTTON = registerBlock("rotten_button",
            new ButtonBlock(BlockSetType.OAK, 10, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON).burnable()));
    public static final Block ROTTEN_PRESSURE_PLATE = registerBlock("rotten_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE).burnable()));

    public static final Identifier ROTTEN_SIGN_TEXTURE = Identifier.of(JaizMod.MOD_ID, "entity/signs/rotten");
    public static final Identifier ROTTEN_HANGING_SIGN_TEXTURE = Identifier.of(JaizMod.MOD_ID, "entity/signs/hanging/rotten");
    public static final Identifier ROTTEN_HANGING_GUI_SIGN_TEXTURE = Identifier.of(JaizMod.MOD_ID, "textures/gui/hanging_signs/rotten");

    public static final Block STANDING_ROTTEN_SIGN = Registry.register(Registries.BLOCK, Identifier.of(JaizMod.MOD_ID, "rotten_standing_sign"),
            new TerraformSignBlock(ROTTEN_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)));

    public static final Block WALL_ROTTEN_SIGN = Registry.register(Registries.BLOCK, Identifier.of(JaizMod.MOD_ID, "rotten_wall_sign"),
            new TerraformWallSignBlock(ROTTEN_SIGN_TEXTURE, AbstractBlock.Settings.copy(ModBlocks.STANDING_ROTTEN_SIGN)));

    public static final Block HANGING_ROTTEN_SIGN = Registry.register(Registries.BLOCK, Identifier.of(JaizMod.MOD_ID, "rotten_hanging_sign"),
            new TerraformHangingSignBlock(ROTTEN_HANGING_SIGN_TEXTURE, ROTTEN_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)));

    public static final Block WALL_HANGING_ROTTEN_SIGN = Registry.register(Registries.BLOCK, Identifier.of(JaizMod.MOD_ID, "rotten_wall_hanging_sign"),
            new TerraformWallHangingSignBlock(ROTTEN_HANGING_SIGN_TEXTURE, ROTTEN_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copy(ModBlocks.HANGING_ROTTEN_SIGN)));

    public static final Block ROTTEN_STAIRS = registerBlock("rotten_stairs",
            new StairsBlock(ModBlocks.ROTTEN_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).burnable()));
    public static final Block ROTTEN_SLAB = registerBlock("rotten_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).burnable()));

    public static final Block ROTTEN_FENCE = registerBlock("rotten_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).burnable()));
    public static final Block ROTTEN_FENCE_GATE = registerBlock("rotten_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).burnable()));

    public static final Block ROTTEN_DOOR = registerBlock("rotten_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque().burnable()));
    public static final Block ROTTEN_TRAPDOOR = registerBlock("rotten_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque().burnable()));



    public static final BlockFamily ROTTEN_FAMILY = BlockFamilies.register(ModBlocks.ROTTEN_PLANKS)
            .sign(ModBlocks.STANDING_ROTTEN_SIGN, ModBlocks.WALL_ROTTEN_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();


    public static final Block WATER_TORCH = registerBlockWithCustomItem(
            "water_torch",
            new WaterTorchBlock(
                    ParticleTypes.GLOW,
                    AbstractBlock.Settings.create().noCollision().breakInstantly()
                            .luminance(state -> WallWaterTorchBlock.isDry(state) ? 3 : 15)
                            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                            .pistonBehavior(PistonBehavior.DESTROY)
            )
    );

    public static final Block WALL_WATER_TORCH = registerBlockWithCustomItem(
            "wall_water_torch",
            new WallWaterTorchBlock(

                    ParticleTypes.GLOW,
                    AbstractBlock.Settings.create()
                            .noCollision()
                            .breakInstantly()
                            .luminance(state -> WallWaterTorchBlock.isDry(state) ? 3 : 15)
                            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                            .dropsLike(WATER_TORCH)
                            .pistonBehavior(PistonBehavior.DESTROY)
            )
    );



    //Main Bits

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(JaizMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(JaizMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static Block registerBlockWithCustomItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(JaizMod.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        JaizMod.LOGGER.info("Registering ModBlocks for " + JaizMod.MOD_ID);
    }

}
