package jaiz.jaizmod.datagen;

import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.BATTERED_AXE);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.OBSIDIAN_DAGGER)
                .add(ModItems.SHARP_REGULAR_OBSIDIAN_SWORD)
                .add(ModItems.SHARP_OBSIDIAN_DAGGER)
                .add(ModItems.SHARP_WEDGE_OBSIDIAN_SWORD)
                .add(ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD)
                .add(ModItems.WEDGE_OBSIDIAN_DAGGER)
                .add(ModItems.WEDGE_OBSIDIAN_SWORD)
                .add(ModItems.SHARP_OBSIDIAN_SWORD)
                .add(ModItems.MACUAHUITL)
                .add(ModItems.OBSIDIAN_SWORD);

        getOrCreateTagBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(ModItems.OBSIDIAN_DAGGER)
                .add(ModItems.SHARP_REGULAR_OBSIDIAN_SWORD)
                .add(ModItems.SHARP_OBSIDIAN_DAGGER)
                .add(ModItems.SHARP_WEDGE_OBSIDIAN_SWORD)
                .add(ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD)
                .add(ModItems.WEDGE_OBSIDIAN_DAGGER)
                .add(ModItems.WEDGE_OBSIDIAN_SWORD)
                .add(ModItems.SHARP_OBSIDIAN_SWORD)
                .add(ModItems.MACUAHUITL)
                .add(ModItems.BATTERED_AXE)
                .add(ModItems.OBSIDIAN_SWORD);

        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(ModItems.BATTERED_AXE);

        getOrCreateTagBuilder(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(ModItems.BATTERED_AXE);

        getOrCreateTagBuilder(ItemTags.VANISHING_ENCHANTABLE)
                .add(ModItems.OBSIDIAN_DAGGER)
                .add(ModItems.SHARP_REGULAR_OBSIDIAN_SWORD)
                .add(ModItems.SHARP_OBSIDIAN_DAGGER)
                .add(ModItems.SHARP_WEDGE_OBSIDIAN_SWORD)
                .add(ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD)
                .add(ModItems.WEDGE_OBSIDIAN_DAGGER)
                .add(ModItems.WEDGE_OBSIDIAN_SWORD)
                .add(ModItems.SHARP_OBSIDIAN_SWORD)
                .add(ModItems.MACUAHUITL)
                .add(ModItems.BATTERED_AXE)
                .add(ModItems.OBSIDIAN_SWORD);

        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.OBSIDIAN_DAGGER)
                .add(ModItems.SHARP_REGULAR_OBSIDIAN_SWORD)
                .add(ModItems.SHARP_OBSIDIAN_DAGGER)
                .add(ModItems.SHARP_WEDGE_OBSIDIAN_SWORD)
                .add(ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD)
                .add(ModItems.WEDGE_OBSIDIAN_DAGGER)
                .add(ModItems.WEDGE_OBSIDIAN_SWORD)
                .add(ModItems.SHARP_OBSIDIAN_SWORD)
                .add(ModItems.MACUAHUITL)
                .add(ModItems.BATTERED_AXE)
                .add(ModItems.OBSIDIAN_SWORD);



        getOrCreateTagBuilder(ItemTags.FENCES)
                .add(ModBlocks.ROTTEN_FENCE.asItem())
                .add(ModBlocks.DESERT_OAK_FENCE.asItem())
                .add(ModBlocks.MAHOGANY_FENCE.asItem());

        getOrCreateTagBuilder(ItemTags.WALLS)
                .add(ModBlocks.TERRACOTTA_BRICK_WALL.asItem());

        getOrCreateTagBuilder(ItemTags.STONE_BRICKS)
                .add(ModBlocks.TERRACOTTA_BRICKS.asItem());

        getOrCreateTagBuilder(ItemTags.FLOWERS)
                .add(ModBlocks.COLUMBINE.asItem())
                .add(ModBlocks.CALLALILY_LILAC.asItem())
                .add(ModBlocks.CALLALILY_YELLOW.asItem())
                .add(ModBlocks.CALLALILY_PURPLE.asItem())
                .add(ModBlocks.CALLALILY_WHITE.asItem())
                .add(ModBlocks.CALLALILY_PINK.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.MAHOGANY_LOG.asItem())
                .add(ModBlocks.MAHOGANY_WOOD.asItem())
                .add(ModBlocks.STRIPPED_MAHOGANY_LOG.asItem())
                .add(ModBlocks.STRIPPED_MAHOGANY_WOOD.asItem())
                .add(ModBlocks.ROTTEN_LOG.asItem())
                .add(ModBlocks.ROTTEN_WOOD.asItem())
                .add(ModBlocks.STRIPPED_ROTTEN_LOG.asItem())
                .add(ModBlocks.STRIPPED_ROTTEN_WOOD.asItem())
                .add(ModBlocks.DESERT_OAK_LOG.asItem())
                .add(ModBlocks.DESERT_OAK_WOOD.asItem())
                .add(ModBlocks.STRIPPED_DESERT_OAK_LOG.asItem())
                .add(ModBlocks.STRIPPED_DESERT_OAK_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.ROTTEN_PLANKS.asItem())
                .add(ModBlocks.DESERT_OAK_PLANKS.asItem())
                .add(ModBlocks.MAHOGANY_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.DIRT)
                .add(ModBlocks.HONEYCOMB_DIRT.asItem())
                .add(ModBlocks.ROT_BLOCK.asItem());


        getOrCreateTagBuilder(ItemTags.FENCE_GATES)
                .add(ModBlocks.DESERT_OAK_FENCE_GATE.asItem())
                .add(ModBlocks.MAHOGANY_FENCE_GATE.asItem())
                .add(ModBlocks.ROTTEN_FENCE_GATE.asItem());


        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.DESERT_OAK_SLAB.asItem())
                .add(ModBlocks.ROTTEN_SLAB.asItem())
                .add(ModBlocks.MAHOGANY_SLAB.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks.DESERT_OAK_BUTTON.asItem())
                .add(ModBlocks.MAHOGANY_BUTTON.asItem())
                .add(ModBlocks.ROTTEN_BUTTON.asItem());


        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.DESERT_OAK_STAIRS.asItem())
                .add(ModBlocks.ROTTEN_STAIRS.asItem())
                .add(ModBlocks.MAHOGANY_STAIRS.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.DESERT_OAK_PRESSURE_PLATE.asItem())
                .add(ModBlocks.ROTTEN_PRESSURE_PLATE.asItem())
                .add(ModBlocks.MAHOGANY_PRESSURE_PLATE.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
                .add(ModBlocks.ROTTEN_FENCE.asItem())
                .add(ModBlocks.DESERT_OAK_FENCE.asItem())
                .add(ModBlocks.MAHOGANY_FENCE.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
                .add(ModBlocks.DESERT_OAK_DOOR.asItem())
                .add(ModBlocks.DESERT_OAK_TRAPDOOR.asItem())
                .add(ModBlocks.ROTTEN_DOOR.asItem())
                .add(ModBlocks.ROTTEN_TRAPDOOR.asItem())
                .add(ModBlocks.MAHOGANY_DOOR.asItem())
                .add(ModBlocks.MAHOGANY_TRAPDOOR.asItem());

        getOrCreateTagBuilder(ItemTags.LEAVES)
                .add(ModBlocks.DESERT_OAK_LEAVES.asItem())
                .add(ModBlocks.MAHOGANY_LEAVES.asItem());

        getOrCreateTagBuilder(ItemTags.SAPLINGS)
                .add(ModBlocks.DESERT_OAK_SAPLING.asItem())
                .add(ModBlocks.MAHOGANY_SAPLING.asItem());


        getOrCreateTagBuilder(ItemTags.FLOWERS)
                .add(ModBlocks.COLUMBINE.asItem())
                .add(ModBlocks.CALLALILY_LILAC.asItem())
                .add(ModBlocks.CALLALILY_YELLOW.asItem())
                .add(ModBlocks.CALLALILY_PURPLE.asItem())
                .add(ModBlocks.CALLALILY_WHITE.asItem())
                .add(ModBlocks.CALLALILY_PINK.asItem());

        getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS)
                .add(ModBlocks.COLUMBINE.asItem());

    }


}
