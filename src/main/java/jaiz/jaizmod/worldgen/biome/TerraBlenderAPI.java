package jaiz.jaizmod.worldgen.biome;

import jaiz.jaizmod.JaizMod;
import net.minecraft.util.Identifier;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;


public class TerraBlenderAPI implements TerraBlenderApi {

    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(Identifier.of(JaizMod.MOD_ID, "overworld"), RegionType.OVERWORLD, 1));
    }
}
