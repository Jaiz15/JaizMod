package jaiz.jaizmod.util;

import jaiz.jaizmod.JaizMod;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModLootTables {
    public static RegistryKey<LootTable> BANDIT_TRADES_GAMEPLAY = of("gameplay/bandit_trades");

    private static RegistryKey<LootTable> of(String id) {
        return RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of(JaizMod.MOD_ID, id));
    }

    public static void registerLootTables(){
    }
}
