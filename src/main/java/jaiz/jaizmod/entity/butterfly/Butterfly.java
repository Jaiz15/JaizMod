// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package jaiz.jaizmod.entity.butterfly;

import jaiz.jaizmod.entity.animation.PlantsAndJunkModAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class Butterfly <T extends ButterflyEntity> extends SinglePartEntityModel<T> {

	private final ModelPart butterfly;
	public Butterfly(ModelPart root) {
		this.butterfly = root.getChild("butterfly");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Butterfly = modelPartData.addChild("butterfly", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = Butterfly.addChild("body", ModelPartBuilder.create().uv(0, 18).cuboid(-1.0F, -1.5F, -4.0F, 2.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.5F, 0.0F));

		ModelPartData wing_l = body.addChild("wing_l", ModelPartBuilder.create().uv(0, 13).cuboid(0.0F, 0.0F, -5.0F, 9.0F, 0.0F, 13.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.5F, -1.0F));

		ModelPartData wing_r = body.addChild("wing_r", ModelPartBuilder.create().uv(0, 0).cuboid(-9.0F, 0.0F, -5.0F, 9.0F, 0.0F, 13.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.5F, -1.0F));

		ModelPartData legs_l = body.addChild("legs_l", ModelPartBuilder.create().uv(2, 2).cuboid(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(2, 1).cuboid(0.0F, 0.0F, -2.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(2, 0).cuboid(0.0F, 0.0F, 1.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, 0.5F, 0.5F));

		ModelPartData leg_r = body.addChild("leg_r", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, 0.0F, -2.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 1).cuboid(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 2).cuboid(0.0F, 0.0F, 1.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 0.5F, 0.5F));

		ModelPartData antenna_r = body.addChild("antenna_r", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, 0.0F, -3.0F, 1.0F, 0.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, -1.5F, -4.0F));

		ModelPartData antenna_l = body.addChild("antenna_l", ModelPartBuilder.create().uv(2, 0).cuboid(-0.5F, 0.0F, -3.0F, 1.0F, 0.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -1.5F, -4.0F));
		return TexturedModelData.of(modelData, 38, 38);
	}

	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		butterfly.render(matrices, vertexConsumer, light, overlay);
	}

	@Override
	public ModelPart getPart() {
		return butterfly;
		}

	@Override
	public void setAngles(ButterflyEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.updateAnimation(entity.butterflyAnimationState, PlantsAndJunkModAnimations.BUTTERFLY, ageInTicks, 1f);
		this.updateAnimation(entity.idlebutterflyAnimationState, PlantsAndJunkModAnimations.BUTTERLY_IDLE, ageInTicks, 1f);
	}
}