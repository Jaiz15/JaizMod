// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package jaiz.jaizmod.entity.dragonfly;

import jaiz.jaizmod.entity.animation.PlantsAndJunkModAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class DragonFly <T extends DragonflyEntity> extends SinglePartEntityModel<T> {
	private final ModelPart dragonFly;


	public DragonFly(ModelPart root) {
		this.dragonFly = root.getChild("dragonFly");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData DragonFly = modelPartData.addChild("dragonFly", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = DragonFly.addChild("body", ModelPartBuilder.create().uv(0, 4).mirrored().cuboid(1.5F, 2.0F, -2.5F, 0.0F, 3.0F, 5.0F, new Dilation(0.0F)).mirrored(false)
		.uv(0, 4).cuboid(-1.5F, 2.0F, -2.5F, 0.0F, 3.0F, 5.0F, new Dilation(0.0F))
		.uv(15, 9).cuboid(-1.5F, -1.0F, -2.0F, 3.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.0F, -2.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 22).cuboid(-2.0F, -1.5F, -3.0F, 4.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.5F, -2.0F));

		ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(0, 9).cuboid(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 2.0F));

		ModelPartData left_wings = body.addChild("left_wings", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 2.0F, 2.0F));

		ModelPartData l_1 = left_wings.addChild("l_1", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, 0.0F, 0.0F, 14.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, -3.0F, -4.0F));

		ModelPartData l_2 = left_wings.addChild("l_2", ModelPartBuilder.create().uv(0, 5).mirrored().cuboid(0.0F, 0.1F, 0.0F, 14.0F, 0.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(1.5F, -3.0F, -1.0F));

		ModelPartData right_wings = body.addChild("right_wings", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 2.0F, 2.0F));

		ModelPartData r_1 = right_wings.addChild("r_1", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-14.0F, 0.0F, 0.0F, 14.0F, 0.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-1.5F, -3.0F, -4.0F));

		ModelPartData r_2 = right_wings.addChild("r_2", ModelPartBuilder.create().uv(0, 5).cuboid(-14.0F, 0.1F, 0.0F, 14.0F, 0.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, -3.0F, -1.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}


	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		dragonFly.render(matrices, vertexConsumer, light, overlay);
	}

	@Override
	public ModelPart getPart() {
		return dragonFly;
	}

	@Override
	public void setAngles(DragonflyEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.updateAnimation(entity.dragonflyAnimationState, PlantsAndJunkModAnimations.DRAGONFLY_FLY, ageInTicks, 1.5f);
	}
}