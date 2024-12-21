package jaiz.jaizmod.worldgen.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

import static terrablender.api.ParameterUtils.*;

public class ModOverworldRegion extends Region {


    public ModOverworldRegion(Identifier name, RegionType type, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }
        public void addBiomes(Registry<Biome> registry, Consumer<Pair<net.minecraft.world.biome.source.util.MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper)
        {
            VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
            new ParameterPointListBuilder()
                    .temperature(Temperature.span(Temperature.WARM, Temperature.HOT))
                    .humidity((Humidity.WET))
                    .continentalness(Continentalness.MID_INLAND, Continentalness.INLAND, Continentalness.NEAR_INLAND, Continentalness.FAR_INLAND)
                    .erosion(Erosion.EROSION_1, Erosion.EROSION_3)
                    .depth(Depth.SURFACE, Depth.SURFACE)
                    .weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING)
                    .build().forEach(point -> builder.add(point, ModBiomes.MAHOGANY_FOREST));

            new ParameterPointListBuilder()
                    .temperature(Temperature.span(Temperature.WARM, Temperature.HOT))
                    .humidity(Humidity.span(Humidity.HUMID, Humidity.WET))
                    .continentalness(Continentalness.INLAND)
                    .erosion(Erosion.EROSION_0, Erosion.EROSION_1)
                    .depth(Depth.UNDERGROUND, Depth.UNDERGROUND)
                    .weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING)
                    .build().forEach(point -> builder.add(point, ModBiomes.FRUIT_BAT_CAVES));


            // Add our points to the mapper
            builder.build().forEach(mapper);
        }
    }
