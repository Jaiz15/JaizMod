package jaiz.jaizmod.mixin;


import com.mojang.serialization.MapCodec;
import jaiz.jaizmod.worldgen.tree.placers.MahoganyTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(TrunkPlacerType.class)
public interface TrunkPlacerTypeInvoker {
    @Invoker("register")
    static <P extends TrunkPlacer> TrunkPlacerType<P> callRegister(String id, MapCodec<MahoganyTrunkPlacer> codec) {
        throw new IllegalStateException();
    }
}
