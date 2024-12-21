package jaiz.jaizmod.entity.boats;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.item.ModItems;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModBoats {

    public static final Identifier MAHOGANY_BOAT_ID = Identifier.of(JaizMod.MOD_ID, "mahogany_boat");
    public static final Identifier MAHOGANY_CHEST_BOAT_ID = Identifier.of(JaizMod.MOD_ID, "mahogany_chest_boat");

    public static final Identifier DESERT_OAK_BOAT_ID = Identifier.of(JaizMod.MOD_ID, "desert_oak_boat");
    public static final Identifier DESERT_OAK_CHEST_BOAT_ID = Identifier.of(JaizMod.MOD_ID, "desert_oak_chest_boat");

    public static final Identifier ROTTEN_BOAT_ID = Identifier.of(JaizMod.MOD_ID, "rotten_boat");
    public static final Identifier ROTTEN_CHEST_BOAT_ID = Identifier.of(JaizMod.MOD_ID, "rotten_chest_boat");


    public static final RegistryKey<TerraformBoatType> MAHOGANY_BOAT = TerraformBoatTypeRegistry.createKey(MAHOGANY_BOAT_ID);
    public static final RegistryKey<TerraformBoatType> DESERT_OAK_BOAT = TerraformBoatTypeRegistry.createKey(DESERT_OAK_BOAT_ID);
    public static final RegistryKey<TerraformBoatType> ROTTEN_BOAT = TerraformBoatTypeRegistry.createKey(ROTTEN_BOAT_ID);

    public static void registerBoats(){
        TerraformBoatType mahogany_boat = new TerraformBoatType.Builder()
                .item(ModItems.MAHOGANY_BOAT)
                .chestItem(ModItems.MAHOGANY_CHEST_BOAT)
                .planks(ModBlocks.MAHOGANY_PLANKS.asItem()).build();
        Registry.register(TerraformBoatTypeRegistry.INSTANCE,MAHOGANY_BOAT, mahogany_boat);

        TerraformBoatType desert_oak_boat = new TerraformBoatType.Builder()
                .item(ModItems.DESERT_OAK_BOAT)
                .chestItem(ModItems.DESERT_OAK_CHEST_BOAT)
                .planks(ModBlocks.DESERT_OAK_PLANKS.asItem()).build();
        Registry.register(TerraformBoatTypeRegistry.INSTANCE,DESERT_OAK_BOAT, desert_oak_boat);

        TerraformBoatType rotten_boat = new TerraformBoatType.Builder()
                .item(ModItems.ROTTEN_BOAT)
                .chestItem(ModItems.ROTTEN_CHEST_BOAT)
                .planks(ModBlocks.ROTTEN_PLANKS.asItem()).build();
        Registry.register(TerraformBoatTypeRegistry.INSTANCE,ROTTEN_BOAT, rotten_boat);

    }
}
