package jaiz.jaizmod.entity.bandit;

import com.google.common.collect.Maps;
import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.entity.ModModelLayers;
import jaiz.jaizmod.entity.dragonfly.DragonflyVariant;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.CowEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.VillagerEntityRenderer;
import net.minecraft.client.render.entity.feature.HeadFeatureRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class BanditRenderer extends MobEntityRenderer<BanditEntity, Bandit<BanditEntity>> {

    public static final Map<BanditVariant, Identifier> BANDIT_VARIANT =
            Util.make(Maps.newEnumMap(BanditVariant.class), (map) -> {
                map.put(BanditVariant.ORIGINAL, Identifier.of(JaizMod.MOD_ID, "textures/entity/bandit/bandit_1.png"));
                map.put(BanditVariant.RED_MASK, Identifier.of(JaizMod.MOD_ID, "textures/entity/bandit/bandit_2.png"));
                map.put(BanditVariant.GLOVES, Identifier.of(JaizMod.MOD_ID, "textures/entity/bandit/bandit_3.png"));
                map.put(BanditVariant.BROWN_SHIRT, Identifier.of(JaizMod.MOD_ID, "textures/entity/bandit/bandit_4.png"));
                map.put(BanditVariant.HAT, Identifier.of(JaizMod.MOD_ID, "textures/entity/bandit/bandit_5.png"));
                map.put(BanditVariant.PAINTED, Identifier.of(JaizMod.MOD_ID, "textures/entity/bandit/bandit_6.png"));
                map.put(BanditVariant.HAND_PRINT, Identifier.of(JaizMod.MOD_ID, "textures/entity/bandit/bandit_7.png"));
                map.put(BanditVariant.SKI_MASK, Identifier.of(JaizMod.MOD_ID, "textures/entity/bandit/bandit_8.png"));
                map.put(BanditVariant.RED, Identifier.of(JaizMod.MOD_ID, "textures/entity/bandit/bandit_9.png"));
                map.put(BanditVariant.GREEN, Identifier.of(JaizMod.MOD_ID, "textures/entity/bandit/bandit_10.png"));
                map.put(BanditVariant.BLUE, Identifier.of(JaizMod.MOD_ID, "textures/entity/bandit/bandit_11.png"));
            });

    public BanditRenderer(EntityRendererFactory.Context context) {
        super(context, new Bandit<>(context.getPart(ModModelLayers.BANDIT)), 0.35f);
        this.addFeature(new HeldItemFeatureRenderer<>(this, context.getHeldItemRenderer()));
    }

    protected void scale(BanditEntity banditEntity, MatrixStack matrixStack, float f) {
        float g = 0.9375F * banditEntity.getScaleFactor();
        matrixStack.scale(g, g, g);
    }

    @Override
    public Identifier getTexture(BanditEntity entity) {
        return BANDIT_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(BanditEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
