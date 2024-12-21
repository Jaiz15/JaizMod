package jaiz.jaizmod.entity.butterfly;

import com.google.common.collect.Maps;
import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.entity.ModModelLayers;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class ButterflyRenderer extends MobEntityRenderer<ButterflyEntity, Butterfly<ButterflyEntity>> {

    private static final Identifier EMCHMU = Identifier.of(JaizMod.MOD_ID,"textures/entity/butterfly/butterfly_em.png");
    private static final Identifier SPPRINKLES = Identifier.of(JaizMod.MOD_ID,"textures/entity/butterfly/butterfly_spprinkles.png");
    private static final Identifier ROMEO = Identifier.of(JaizMod.MOD_ID,"textures/entity/butterfly/butterfly_romeo.png");
    private static final Identifier MEAT = Identifier.of(JaizMod.MOD_ID,"textures/entity/butterfly/meat_grinder_fly.png");

    private static final Identifier EPICCOOL = Identifier.of(JaizMod.MOD_ID,"textures/entity/butterfly/butterfly__epiccool_cinnabar_moth.png");
    private static final Identifier ETHANTIANYU = Identifier.of(JaizMod.MOD_ID,"textures/entity/butterfly/butterfly_ethantianyu.png");
    private static final Identifier DERNEV = Identifier.of(JaizMod.MOD_ID,"textures/entity/butterfly/butterfly_dernevs_enderfly.png");
    private static final Identifier TBK = Identifier.of(JaizMod.MOD_ID,"textures/entity/butterfly/butterfly_tbk.png");
    private static final Identifier ZUPERZ = Identifier.of(JaizMod.MOD_ID,"textures/entity/butterfly/butterfly_zuper.png");
    private static final Identifier ZUPER_SHINY = Identifier.of(JaizMod.MOD_ID,"textures/entity/butterfly/butterfly_zuper_2.png");


    public static final Map<ButterflyVariant, Identifier> BUTTERFLY_VARIANT =
            Util.make(Maps.newEnumMap(ButterflyVariant.class), (map) -> {
                map.put(ButterflyVariant.MONARCH, Identifier.of(JaizMod.MOD_ID, "textures/entity/butterfly/butterfly_monarch.png"));
                map.put(ButterflyVariant.WHITE_MONARCH, Identifier.of(JaizMod.MOD_ID, "textures/entity/butterfly/butterfly_white_monarch.png"));
                map.put(ButterflyVariant.YELLOW_MONARCH, Identifier.of(JaizMod.MOD_ID, "textures/entity/butterfly/butterfly_yellow_monarch.png"));
                map.put(ButterflyVariant.ATLAS_MOTH, Identifier.of(JaizMod.MOD_ID, "textures/entity/butterfly/butterfly_atlas_moth.png"));
                map.put(ButterflyVariant.LUNA_MOTH, Identifier.of(JaizMod.MOD_ID, "textures/entity/butterfly/butterfly_luna_moth.png"));
                map.put(ButterflyVariant.CABBAGE_MOTH, Identifier.of(JaizMod.MOD_ID, "textures/entity/butterfly/butterfly_cabbage_moth.png"));
                map.put(ButterflyVariant.CARINS_BIRDWING, Identifier.of(JaizMod.MOD_ID, "textures/entity/butterfly/butterfly_cairns_birdwing.png"));
                map.put(ButterflyVariant.ULYSSES, Identifier.of(JaizMod.MOD_ID, "textures/entity/butterfly/butterfly_ulysses_swallowtail.png"));
                map.put(ButterflyVariant.JAMPOTT, Identifier.of(JaizMod.MOD_ID, "textures/entity/butterfly/butterfly_jampott.png"));
            });

    public ButterflyRenderer(EntityRendererFactory.Context context) {
        super(context, new Butterfly<>(context.getPart(ModModelLayers.BUTTERFLY)), 0.35f);
    }

    @Override
    public Identifier getTexture(ButterflyEntity instance) {
        String string = Formatting.strip(instance.getName().getString());
        if ("emchmu".equals(string)) {
            return EMCHMU;
        }
        if ("em".equals(string)) {
            return EMCHMU;
        }
        if ("spprinkles".equals(string)) {
            return SPPRINKLES;
        }
        if ("Romeo".equals(string)) {
            return ROMEO;
        }
        if ("Ethantianyu".equals(string)) {
            return ETHANTIANYU;
        }
        if ("TBK".equals(string)) {
            return TBK;
        }
        if ("TruthBeKnown".equals(string)) {
            return TBK;
        }
        if ("epiccool".equals(string)) {
            return EPICCOOL;
        }
        if ("dernevs".equals(string)) {
            return DERNEV;
        }
        if ("ZuperZShiny".equals(string)) {
            return ZUPER_SHINY;
        }
        if ("ZuperZ".equals(string)) {
            return ZUPERZ;
        }
        if ("MeatGrinder".equals(string)) {
            return MEAT;
        }

        return BUTTERFLY_VARIANT.get(instance.getVariant());
    }

    @Override
    public void render(ButterflyEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
