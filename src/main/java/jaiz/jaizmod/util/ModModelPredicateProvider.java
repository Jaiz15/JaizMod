package jaiz.jaizmod.util;

import jaiz.jaizmod.item.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

@Environment(value = EnvType.CLIENT)
public class ModModelPredicateProvider {

    public static void registerModModels() {
        registerHornModel(ModItems.AMETHYST_HORN);
        registerHornModel(ModItems.AIR_HORN);
        registerHornModel(ModItems.ANCIENT_HORN);
    }

    private static void registerHornModel(Item item) {
        FabricModelPredicateProviderRegistry.register(Identifier.ofVanilla("tooting"), (stack, world, entity, seed) ->
                entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F);
    }


}
