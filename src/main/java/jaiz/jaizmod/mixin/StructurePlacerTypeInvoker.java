package jaiz.jaizmod.mixin;


import com.mojang.serialization.MapCodec;
import jaiz.jaizmod.worldgen.structure.placers.JaizJungleTempleStructurePlacer;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(StructureType.class)
public interface StructurePlacerTypeInvoker {
    @Invoker("register")
    static <S extends Structure> StructureType<S> callRegister(String id, MapCodec<JaizJungleTempleStructurePlacer> codec) {
        throw new IllegalStateException();
    }
}
