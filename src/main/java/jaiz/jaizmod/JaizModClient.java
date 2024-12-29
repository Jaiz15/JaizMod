package jaiz.jaizmod;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.entity.ModEntities;
import jaiz.jaizmod.entity.ModModelLayers;
import jaiz.jaizmod.entity.bandit.Bandit;
import jaiz.jaizmod.entity.bandit.BanditRenderer;
import jaiz.jaizmod.entity.boats.ModBoats;
import jaiz.jaizmod.entity.butterfly.Butterfly;
import jaiz.jaizmod.entity.butterfly.ButterflyRenderer;
import jaiz.jaizmod.entity.caterpillar.Caterpillar;
import jaiz.jaizmod.entity.caterpillar.CaterpillarRenderer;
import jaiz.jaizmod.entity.dragonfly.DragonFly;
import jaiz.jaizmod.entity.dragonfly.DragonflyRenderer;
import jaiz.jaizmod.entity.firefly.Fireflies;
import jaiz.jaizmod.entity.firefly.FireflyRenderer;
import jaiz.jaizmod.entity.fruit_bat.FruitBat;
import jaiz.jaizmod.entity.fruit_bat.FruitBatRenderer;
import jaiz.jaizmod.entity.mason_mouth.MasonMouthRenderer;
import jaiz.jaizmod.entity.mason_mouth.Masonmouth;
import jaiz.jaizmod.entity.snail.Snail;
import jaiz.jaizmod.entity.snail.SnailRenderer;
import jaiz.jaizmod.particle.FireFlyParticle;
import jaiz.jaizmod.util.ModModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.particle.AshParticle;
import net.minecraft.client.particle.EndRodParticle;
import net.minecraft.client.particle.RainSplashParticle;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.item.Item;
import net.minecraft.world.biome.FoliageColors;

public class JaizModClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {

		ModModelPredicateProvider.registerModModels();

		TerraformBoatClientHelper.registerModelLayers(ModBoats.MAHOGANY_BOAT_ID, false);
		TerraformBoatClientHelper.registerModelLayers(ModBoats.MAHOGANY_CHEST_BOAT_ID, false);
		TerraformBoatClientHelper.registerModelLayers(ModBoats.ROTTEN_BOAT_ID, false);
		TerraformBoatClientHelper.registerModelLayers(ModBoats.ROTTEN_CHEST_BOAT_ID, false);
		TerraformBoatClientHelper.registerModelLayers(ModBoats.DESERT_OAK_BOAT_ID, false);
		TerraformBoatClientHelper.registerModelLayers(ModBoats.DESERT_OAK_CHEST_BOAT_ID, false);

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TEAPOTBLOCK, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FIREFLY_BOTTLE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COLUMBINE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ROTTEN_LOG, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.IVY, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.UNDERGROWTH, RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BIOLUMINESCENT_BOTTLE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WATER_TORCH, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WALL_WATER_TORCH, RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CALLALILY_WHITE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CALLALILY_LILAC, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CALLALILY_PINK, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CALLALILY_PURPLE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CALLALILY_YELLOW, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WATER_TEMPORARY_LIGHT, RenderLayer.getCutout());

		EntityRendererRegistry.register(ModEntities.BUTTERFLY, ButterflyRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BUTTERFLY, Butterfly::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.CATERPILLAR, CaterpillarRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CATERPILLAR, Caterpillar::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.DRAGONFLY, DragonflyRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.DRAGONFLY, DragonFly::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.FIRE_FLY_SWARM, FireflyRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.FIRE_FLY_SWARM, Fireflies::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.SNAIL, SnailRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SNAIL, Snail::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.GUANO, FlyingItemEntityRenderer::new);
		EntityRendererRegistry.register(ModEntities.GLOWBALL, FlyingItemEntityRenderer::new);
		EntityRendererRegistry.register(ModEntities.DYNAMITE, FlyingItemEntityRenderer::new);

		EntityRendererRegistry.register(ModEntities.FRUIT_BAT, FruitBatRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.FRUIT_BAT, FruitBat::getTexturedModelData);

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAHOGANY_LEAVES, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SLIME_DRIP, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GUANO_PILE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAHOGANY_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAHOGANY_TRAPDOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAHOGANY_SAPLING, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMETHYST_THORN, RenderLayer.getCutout());

		registerBlockColor(ModBlocks.MAHOGANY_LEAVES);
		registerItemColor(ModBlocks.MAHOGANY_LEAVES.asItem());
		registerBlockColor(ModBlocks.IVY);
		registerBlockColor(ModBlocks.UNDERGROWTH);
		registerBlockColor(ModBlocks.DESERT_OAK_LEAVES);
		registerBlockColor(Blocks.LILY_PAD);
		registerItemColor(ModBlocks.DESERT_OAK_LEAVES.asItem());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DESERT_OAK_LEAVES, RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DESERT_OAK_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DESERT_OAK_TRAPDOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DESERT_OAK_SAPLING, RenderLayer.getCutout());

		EntityRendererRegistry.register(ModEntities.MASON_MOUTH, MasonMouthRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.MASON_MOUTH, Masonmouth::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.BANDIT, BanditRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BANDIT, Bandit::getTexturedModelData);

		ParticleFactoryRegistry.getInstance().register(JaizMod.STINK_PARTICLE, AshParticle.Factory::new);
		ParticleFactoryRegistry.getInstance().register(JaizMod.STINK_ITEM_PARTICLE, RainSplashParticle.Factory::new);
		ParticleFactoryRegistry.getInstance().register(JaizMod.SLIME_DRIP_PARTICLE, RainSplashParticle.Factory::new);
		ParticleFactoryRegistry.getInstance().register(JaizMod.AMETHYST_SPARKLE_PARTICLE, EndRodParticle.Factory::new);
		ParticleFactoryRegistry.getInstance().register(JaizMod.FIREFLY_PARTICLE, FireFlyParticle.FireFlyParticleFactory::new);

	}


	private void registerBlockColor(Block block) {
		registerItemColor(block.asItem());
		ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.getBirchColor(),
				ModBlocks.MAHOGANY_LEAVES, ModBlocks.DESERT_OAK_LEAVES, ModBlocks.IVY, ModBlocks.UNDERGROWTH, Blocks.LILY_PAD);
	}

	private void registerItemColor(Item item) {
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> FoliageColors.getBirchColor(),
				ModBlocks.MAHOGANY_LEAVES.asItem(), ModBlocks.DESERT_OAK_LEAVES.asItem());
	}
}