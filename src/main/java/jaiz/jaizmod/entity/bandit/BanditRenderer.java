package jaiz.jaizmod.entity.bandit;

import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.entity.ModModelLayers;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class BanditRenderer extends MobEntityRenderer<BanditEntity, Bandit<BanditEntity>> {
    private static final Identifier TEXTURE = Identifier.of(JaizMod.MOD_ID, "textures/entity/bandit.png");

    public BanditRenderer(EntityRendererFactory.Context context) {
        super(context, new Bandit<>(context.getPart(ModModelLayers.BANDIT)), 0.35f);
    }

    protected void scale(BanditEntity banditEntity, MatrixStack matrixStack, float f) {
        float g = 0.9375F * banditEntity.getScaleFactor();
        matrixStack.scale(g, g, g);
    }

    @Override
    public Identifier getTexture(BanditEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(BanditEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
