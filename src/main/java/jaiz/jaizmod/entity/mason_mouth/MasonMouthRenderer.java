package jaiz.jaizmod.entity.mason_mouth;

import com.google.common.collect.Maps;
import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.entity.ModModelLayers;
import jaiz.jaizmod.entity.bandit.BanditEntity;
import jaiz.jaizmod.entity.bandit.BanditVariant;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class MasonMouthRenderer extends MobEntityRenderer<MasonmouthEntity, Masonmouth<MasonmouthEntity>> {

    public static final Map<MasonMouthVariant, Identifier> MASON_MOUTH_VARIANT =
            Util.make(Maps.newEnumMap(MasonMouthVariant.class), (map) -> {
                map.put(MasonMouthVariant.ORIGINAL, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth.png"));
                map.put(MasonMouthVariant.ANGLER, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_angler.png"));
                map.put(MasonMouthVariant.ARCHER, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_archer.png"));
                map.put(MasonMouthVariant.ARMS_UP, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_arms_up.png"));
                map.put(MasonMouthVariant.BLADE, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_blade.png"));
                map.put(MasonMouthVariant.BREWER, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_brewer.png"));
                map.put(MasonMouthVariant.BURN, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_burn.png"));
                map.put(MasonMouthVariant.DANGER, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_danger.png"));
                map.put(MasonMouthVariant.EXPLORER, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_explorer.png"));
                map.put(MasonMouthVariant.FLOW, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_flow.png"));
                map.put(MasonMouthVariant.FRIEND, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_friend.png"));
                map.put(MasonMouthVariant.GUSTER, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_guster.png"));
                map.put(MasonMouthVariant.HEART, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_heart.png"));
                map.put(MasonMouthVariant.HEARTBREAK, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_heartbreak.png"));
                map.put(MasonMouthVariant.HOWL, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_howl.png"));
                map.put(MasonMouthVariant.MINER, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_miner.png"));
                map.put(MasonMouthVariant.MOURNER, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_mourner.png"));
                map.put(MasonMouthVariant.PLENTY, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_plenty.png"));
                map.put(MasonMouthVariant.PRIZE, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_prize.png"));
                map.put(MasonMouthVariant.SCRAPE, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_scrape.png"));
                map.put(MasonMouthVariant.SHEAF, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_sheaf.png"));
                map.put(MasonMouthVariant.SHELTER, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_shelter.png"));
                map.put(MasonMouthVariant.SKULL, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_skull.png"));
                map.put(MasonMouthVariant.SNORT, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_snort.png"));
                map.put(MasonMouthVariant.GILDED, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_gilded.png"));
                map.put(MasonMouthVariant.CLAY, Identifier.of(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_clay.png"));
            });

    public MasonMouthRenderer(EntityRendererFactory.Context context) {
        super(context, new Masonmouth<>(context.getPart(ModModelLayers.MASON_MOUTH)), 0.35f);
    }

    @Override
    public Identifier getTexture(MasonmouthEntity entity) {
        return MASON_MOUTH_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(MasonmouthEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
