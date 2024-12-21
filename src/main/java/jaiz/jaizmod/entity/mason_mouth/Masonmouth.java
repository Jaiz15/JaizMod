package jaiz.jaizmod.entity.mason_mouth;

import jaiz.jaizmod.entity.animation.DunesAndDroughtAnimations;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class Masonmouth <T extends MasonmouthEntity> extends SinglePartEntityModel<T> {
	private final ModelPart masonmouth;

	public Masonmouth(ModelPart root) {
		this.masonmouth = root.getChild("masonmouth");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData MasonMouth = modelPartData.addChild("masonmouth", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData pot = MasonMouth.addChild("pot", ModelPartBuilder.create().uv(0, 0).cuboid(-7.0F, -16.0F, -7.0F, 14.0F, 16.0F, 14.0F, new Dilation(0.0F))
		.uv(0, 41).cuboid(-3.5F, -17.0F, -3.5F, 7.0F, 1.0F, 7.0F, new Dilation(0.0F))
		.uv(0, 30).cuboid(-4.0F, -20.0F, -4.0F, 8.0F, 3.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData mouth = MasonMouth.addChild("mouth", ModelPartBuilder.create().uv(32, 30).cuboid(-3.0F, -5.5F, -3.0F, 6.0F, 11.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.5F, 0.0F));

		ModelPartData jaw_1 = mouth.addChild("jaw_1", ModelPartBuilder.create().uv(22, 47).cuboid(0.0F, -4.0F, -3.0F, 3.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -5.5F, 0.0F));

		ModelPartData tooth_1 = jaw_1.addChild("tooth_1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -4.0F, 0.0F));

		ModelPartData tooth_1_r1 = tooth_1.addChild("tooth_1_r1", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, 0.0F, -3.0F, 3.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		ModelPartData jaw_2 = mouth.addChild("jaw_2", ModelPartBuilder.create().uv(42, 0).cuboid(-3.0F, -4.0F, -3.0F, 3.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -5.5F, 0.0F));

		ModelPartData tooth_2 = jaw_2.addChild("tooth_2", ModelPartBuilder.create(), ModelTransform.pivot(0.0057F, -3.9807F, 0.0F));

		ModelPartData tooth_2_r1 = tooth_2.addChild("tooth_2_r1", ModelPartBuilder.create().uv(0, 6).cuboid(-3.0F, 0.0F, -3.0F, 3.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-0.0057F, -0.0193F, 0.0F, 0.0F, 0.0F, 0.0873F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		masonmouth.render(matrices, vertexConsumer, light, overlay);
	}

	@Override
	public void setAngles(MasonmouthEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.updateAnimation(entity.idleAnimationState, DunesAndDroughtAnimations.MASON_MOUTH_IDLE, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, DunesAndDroughtAnimations.MASON_MOUTH_ATTACK, ageInTicks, 1f);
		}


	@Override
	public ModelPart getPart() {
		return masonmouth;
	}

}