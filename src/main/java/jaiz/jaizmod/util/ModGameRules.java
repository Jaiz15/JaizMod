package jaiz.jaizmod.util;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class ModGameRules {

    public static final GameRules.Key<GameRules.BooleanRule> DO_GLOWING_SQUID =
            GameRuleRegistry.register("doGlowingSquid", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(false));


    public static void registerGamerules(){
    }
}
