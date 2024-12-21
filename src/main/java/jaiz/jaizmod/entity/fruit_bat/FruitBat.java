package jaiz.jaizmod.entity.fruit_bat;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class FruitBat <T extends FruitBatEntity> extends SinglePartEntityModel<T> {
	private final ModelPart fruitbat;
	private final ModelPart head;

	public FruitBat(ModelPart root) {
		this.fruitbat = root.getChild("fruitbat");
		this.head = fruitbat.getChild("body").getChild("head");
	}


	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData fruitbat = modelPartData.addChild("fruitbat", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = fruitbat.addChild("body", ModelPartBuilder.create().uv(0, 8).cuboid(-2.0F, 0.0F, -1.5F, 4.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -13.0F, 0.0F));

		ModelPartData body_lower = body.addChild("body_lower", ModelPartBuilder.create().uv(12, 24).cuboid(-1.5F, 0.0F, -1.0F, 3.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.0F, 0.0F));

		ModelPartData legs = body_lower.addChild("legs", ModelPartBuilder.create().uv(16, 29).cuboid(0.5F, -2.0F, -1.0F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F))
				.uv(16, 29).mirrored().cuboid(-1.5F, -2.0F, -1.0F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 3.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-2.5F, -4.0F, -2.0F, 5.0F, 4.0F, 4.0F, new Dilation(0.0F))
				.uv(8, 29).cuboid(-1.5F, -2.0F, -3.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData ear_l = head.addChild("ear_l", ModelPartBuilder.create().uv(22, 25).cuboid(-1.5F, -3.0F, 0.0F, 3.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(2.5F, -4.0F, 0.0F));

		ModelPartData ear_r = head.addChild("ear_r", ModelPartBuilder.create().uv(22, 25).mirrored().cuboid(-1.5F, -3.0F, 0.0F, 3.0F, 5.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-2.5F, -4.0F, 0.0F));

		ModelPartData wing_l = body.addChild("wing_l", ModelPartBuilder.create().uv(0, 18).cuboid(0.0F, -4.0F, 0.0F, 6.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 3.0F, 1.5F));

		ModelPartData wing_l2 = wing_l.addChild("wing_l2", ModelPartBuilder.create().uv(14, 16).cuboid(0.0F, -4.0F, 0.0F, 8.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, 0.0F, 0.0F));

		ModelPartData wing_r = body.addChild("wing_r", ModelPartBuilder.create().uv(0, 18).mirrored().cuboid(-6.0F, -4.0F, 0.0F, 6.0F, 8.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-2.0F, 3.0F, 1.5F));

		ModelPartData wing_r2 = wing_r.addChild("wing_r2", ModelPartBuilder.create().uv(14, 16).mirrored().cuboid(-8.0F, -4.0F, 0.0F, 8.0F, 8.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-6.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 48, 48);
	}

	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		fruitbat.render(matrices, vertexConsumer, light, overlay);
	}

	@Override
	public ModelPart getPart() {
		return fruitbat;
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -20.0f, 20.0f);
		headPitch = MathHelper.clamp(headPitch, -20.0f, 20.0f);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;

	}


	@Override
	public void setAngles(FruitBatEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.updateAnimation(entity.flyingAnimationState, FruitBatAnimations.FLY, ageInTicks, 1.0F);
		this.updateAnimation(entity.roostingAnimationState, FruitBatAnimations.ROOST, ageInTicks, 1.0F);

	}
}