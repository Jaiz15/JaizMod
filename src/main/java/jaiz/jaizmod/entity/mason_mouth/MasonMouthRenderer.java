package jaiz.jaizmod.entity.mason_mouth;

import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.entity.ModModelLayers;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class MasonMouthRenderer extends MobEntityRenderer<MasonmouthEntity, Masonmouth<MasonmouthEntity>> {
    private static final Identifier TEXTURE = Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth.png");

    public MasonMouthRenderer(EntityRendererFactory.Context context) {
        super(context, new Masonmouth<>(context.getPart(ModModelLayers.MASON_MOUTH)), 0.35f);
    }

    @Override
    public Identifier getTexture(MasonmouthEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(MasonmouthEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
