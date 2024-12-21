// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package jaiz.jaizmod.entity.firefly;
import jaiz.jaizmod.entity.animation.PlantsAndJunkModAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class Fireflies <T extends FireFlySwarmEntity> extends SinglePartEntityModel<T> {
	private final ModelPart swarm;

	public Fireflies(ModelPart root) {
		this.swarm = root.getChild("swarm");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Swarm = modelPartData.addChild("swarm", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData firefly = Swarm.addChild("firefly", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData firefly2 = Swarm.addChild("firefly2", ModelPartBuilder.create().uv(4, 8).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData firefly3 = Swarm.addChild("firefly3", ModelPartBuilder.create().uv(8, 3).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData firefly4 = Swarm.addChild("firefly4", ModelPartBuilder.create().uv(8, 2).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData firefly5 = Swarm.addChild("firefly5", ModelPartBuilder.create().uv(8, 1).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData firefly6 = Swarm.addChild("firefly6", ModelPartBuilder.create().uv(8, 0).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData firefly7 = Swarm.addChild("firefly7", ModelPartBuilder.create().uv(0, 8).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData firefly8 = Swarm.addChild("firefly8", ModelPartBuilder.create().uv(4, 7).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData firefly9 = Swarm.addChild("firefly9", ModelPartBuilder.create().uv(0, 7).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData firefly10 = Swarm.addChild("firefly10", ModelPartBuilder.create().uv(4, 6).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData firefly11 = Swarm.addChild("firefly11", ModelPartBuilder.create().uv(0, 6).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData firefly12 = Swarm.addChild("firefly12", ModelPartBuilder.create().uv(4, 5).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData firefly13 = Swarm.addChild("firefly13", ModelPartBuilder.create().uv(0, 5).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData firefly14 = Swarm.addChild("firefly14", ModelPartBuilder.create().uv(4, 4).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData firefly15 = Swarm.addChild("firefly15", ModelPartBuilder.create().uv(4, 3).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData firefly16 = Swarm.addChild("firefly16", ModelPartBuilder.create().uv(4, 2).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData firefly17 = Swarm.addChild("firefly17", ModelPartBuilder.create().uv(4, 1).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData firefly18 = Swarm.addChild("firefly18", ModelPartBuilder.create().uv(4, 0).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData firefly19 = Swarm.addChild("firefly19", ModelPartBuilder.create().uv(0, 4).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData firefly20 = Swarm.addChild("firefly20", ModelPartBuilder.create().uv(0, 3).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData firefly21 = Swarm.addChild("firefly21", ModelPartBuilder.create().uv(0, 2).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData firefly22 = Swarm.addChild("firefly22", ModelPartBuilder.create().uv(0, 1).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData firefly23 = Swarm.addChild("firefly23", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));
		return TexturedModelData.of(modelData, 16, 16);
	}
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		swarm.render(matrices, vertexConsumer, light, overlay);
	}

	@Override
	public ModelPart getPart() {
		return swarm;
	}


	@Override
	public void setAngles(FireFlySwarmEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.updateAnimation(entity.fireflyAnimationState, PlantsAndJunkModAnimations.FIRE_FLY_SWARM, ageInTicks, 1f);
	}
}