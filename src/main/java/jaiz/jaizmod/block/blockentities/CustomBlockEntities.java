package jaiz.jaizmod.block.blockentities;

import jaiz.jaizmod.block.ModBlocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CustomBlockEntities {

    public static final BlockEntityType<SquidLightBlockEntity> SQUID_LIGHT_BLOCK_ENTITY = register("ticking_block", BlockEntityType.Builder.create(SquidLightBlockEntity::new, ModBlocks.WATER_TEMPORARY_LIGHT).build());

    public static <T extends BlockEntity>BlockEntityType<T> register(String name, BlockEntityType<T> type){
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(name), type);
    }


    public static void registerBlockEntities(){
    }

}
