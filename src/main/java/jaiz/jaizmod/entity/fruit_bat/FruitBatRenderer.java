package jaiz.jaizmod.entity.fruit_bat;

import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.entity.ModModelLayers;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class FruitBatRenderer extends MobEntityRenderer<FruitBatEntity, FruitBat<FruitBatEntity>> {
    private static final Identifier TEXTURE = Identifier.of(JaizMod.MOD_ID, "textures/entity/bats/fruit_bat.png");

    public FruitBatRenderer(EntityRendererFactory.Context context) {
        super(context, new FruitBat<>(context.getPart(ModModelLayers.FRUIT_BAT)), 0.25f);
    }

    @Override
    public Identifier getTexture(FruitBatEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(FruitBatEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
