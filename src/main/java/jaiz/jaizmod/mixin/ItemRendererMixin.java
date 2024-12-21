package jaiz.jaizmod.mixin;


import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel use3DModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(jaiz.jaizmod.item.ModItems.GLOWING_SPYGLASS) && renderMode == ModelTransformationMode.GROUND) {
            return ((ItemRendererAccessor) this).jaizmod$getModels().getModelManager().getModel(new ModelIdentifier(Identifier.of("jaizmod", "glowing_spyglass"), "ground"));
        }
        if (stack.isOf(jaiz.jaizmod.item.ModItems.GLOWING_SPYGLASS) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).jaizmod$getModels().getModelManager().getModel(new ModelIdentifier(Identifier.of("jaizmod", "glowing_spyglass_in_hand"), "inventory"));
        }
        return value;
    }
}
