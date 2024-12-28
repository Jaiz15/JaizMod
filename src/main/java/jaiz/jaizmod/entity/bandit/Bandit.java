package jaiz.jaizmod.entity.bandit;


import jaiz.jaizmod.entity.animation.DunesAndDroughtAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import net.minecraft.util.math.MathHelper;

public class Bandit <T extends BanditEntity> extends SinglePartEntityModel<T> implements ModelWithArms {
	private final ModelPart bandit;
	private final ModelPart head;
	private final ModelPart hands;

	public Bandit(ModelPart root) {
		this.bandit = root.getChild("bandit");
		this.hands = root.getChild("bandit").getChild("body").getChild("arms").getChild("item");
		this.head = bandit.getChild("body").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bandit = modelPartData.addChild("bandit", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData leg_l = bandit.addChild("leg_l", ModelPartBuilder.create().uv(28, 36).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -12.0F, 0.0F));

		ModelPartData leg_r = bandit.addChild("leg_r", ModelPartBuilder.create().uv(44, 36).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -12.0F, 0.0F));

		ModelPartData body = bandit.addChild("body", ModelPartBuilder.create().uv(0, 36).cuboid(-4.0F, -12.0F, -3.0F, 8.0F, 12.0F, 6.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-4.0F, -12.0F, -3.0F, 8.0F, 20.0F, 6.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(20, 18).cuboid(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new Dilation(0.0F))
				.uv(22, 0).cuboid(-1.0F, -3.0F, -6.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F))
				.uv(28, 0).cuboid(-4.0F, -9.25F, -4.0F, 8.0F, 7.0F, 8.0F, new Dilation(0.51F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));


		ModelPartData arms = body.addChild("arms", ModelPartBuilder.create().uv(44, 15).cuboid(-4.0F, 2.7F, -2.55F, 8.0F, 4.0F, 4.0F, new Dilation(0.0F))
				.uv(24, 52).cuboid(-8.0F, -1.3F, -2.55F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F))
				.uv(52, 23).cuboid(4.0F, -1.3F, -2.55F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -9.25F, -0.5F, -0.7418F, 0.0F, 0.0F));

		ModelPartData item = arms.addChild("item", ModelPartBuilder.create(), ModelTransform.of(0.0F, 3.0F, 3.0F, -19.9F, 0.0F, 0.0F));


		return TexturedModelData.of(modelData, 72, 72);
	}

	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bandit.render(matrices, vertexConsumer, light, overlay);
	}

	@Override
	public void setAngles(BanditEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(DunesAndDroughtAnimations.BANDIT_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.attackAnimationState, DunesAndDroughtAnimations.BANDIT_ATTACK, ageInTicks, 1f);
		this.updateAnimation(entity.tradeAnimationState, DunesAndDroughtAnimations.BANDIT_ATTACK, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -20.0f, 20.0f);
		headPitch = MathHelper.clamp(headPitch, -20.0f, 20.0f);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;

	}

	@Override
	public ModelPart getPart() {
		return bandit;
	}

	@Override
	public void setArmAngle(Arm arm, MatrixStack matrices) {
		this.hands.rotate(matrices);
	}
}