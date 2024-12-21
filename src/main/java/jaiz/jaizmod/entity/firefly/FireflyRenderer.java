package jaiz.jaizmod.entity.firefly;

import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.entity.ModModelLayers;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class FireflyRenderer extends MobEntityRenderer<FireFlySwarmEntity, Fireflies<FireFlySwarmEntity>> {

    private static final Identifier TEXTURE = Identifier.of(JaizMod.MOD_ID,"textures/entity/fireflies/fireflies.png");

    public FireflyRenderer(EntityRendererFactory.Context context) {
        super(context, new Fireflies<>(context.getPart(ModModelLayers.FIRE_FLY_SWARM)), 0f);
        this.addFeature(new FireFliesFeatureRenderer<>(this));
    }

    @Override
    public Identifier getTexture(FireFlySwarmEntity instance) {
        return TEXTURE;

    }

    @Override
    public void render(FireFlySwarmEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
