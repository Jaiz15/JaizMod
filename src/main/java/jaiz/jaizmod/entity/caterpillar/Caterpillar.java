// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package jaiz.jaizmod.entity.caterpillar;
import jaiz.jaizmod.entity.animation.PlantsAndJunkModAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class Caterpillar <T extends CaterpillarEntity> extends SinglePartEntityModel<T> {

	private final ModelPart caterpillar;

	public Caterpillar(ModelPart root) {
		this.caterpillar = root.getChild("caterpillar");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData caterpillar = modelPartData.addChild("caterpillar", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData head = caterpillar.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.75F, -1.75F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 2).cuboid(1.0F, -2.75F, -1.75F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 19).cuboid(-1.5F, -0.75F, -0.75F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(15, 14).cuboid(-1.5F, 2.25F, -0.75F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.25F, -7.25F));

		ModelPartData body = caterpillar.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -3.25F, -3.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
		.uv(0, 11).cuboid(-2.0F, 0.75F, -3.5F, 4.0F, 1.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.75F, -1.5F));

		ModelPartData back = caterpillar.addChild("back", ModelPartBuilder.create().uv(17, 6).cuboid(-1.5F, -2.5F, -2.5F, 3.0F, 3.0F, 5.0F, new Dilation(0.0F))
		.uv(15, 0).cuboid(-1.5F, 0.5F, -2.5F, 3.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.5F, 4.5F));
		return TexturedModelData.of(modelData, 34, 34);
	}

	@Override
	public void setAngles(CaterpillarEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(PlantsAndJunkModAnimations.CATERPILLAR_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
	}

	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		caterpillar.render(matrices, vertexConsumer, light, overlay);
	}

	@Override
	public ModelPart getPart() {
		return caterpillar;
	}
}