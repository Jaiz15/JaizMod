package jaiz.jaizmod.entity;

import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.entity.bandit.BanditEntity;
import jaiz.jaizmod.entity.butterfly.ButterflyEntity;
import jaiz.jaizmod.entity.caterpillar.CaterpillarEntity;
import jaiz.jaizmod.entity.dragonfly.DragonflyEntity;
import jaiz.jaizmod.entity.firefly.FireFlySwarmEntity;
import jaiz.jaizmod.entity.fruit_bat.FruitBatEntity;
import jaiz.jaizmod.entity.mason_mouth.MasonmouthEntity;
import jaiz.jaizmod.entity.snail.SnailEntity;
import jaiz.jaizmod.entity.thrown_entity.DynamiteEntity;
import jaiz.jaizmod.entity.thrown_entity.GlowballEntity;
import jaiz.jaizmod.entity.thrown_entity.GuanoEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<MasonmouthEntity> MASON_MOUTH = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(JaizMod.MOD_ID, "mason_mouth"),
            EntityType.Builder.create(MasonmouthEntity::new, SpawnGroup.MISC).dimensions(0.875f, 1.0f).build());

    public static final EntityType<BanditEntity> BANDIT = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(JaizMod.MOD_ID, "bandit"),
            EntityType.Builder.create(BanditEntity::new, SpawnGroup.MISC).dimensions(0.6f, 1.9f).build());

    public static final EntityType<DynamiteEntity> DYNAMITE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(JaizMod.MOD_ID, "dynamite"),
            FabricEntityTypeBuilder.<DynamiteEntity>create(SpawnGroup.MISC, DynamiteEntity::new).dimensions(EntityDimensions.fixed(0.4f, 0.4f)).build());


    public static final EntityType<GuanoEntity> GUANO = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(JaizMod.MOD_ID, "guano"),
            EntityType.Builder.<GuanoEntity>create(GuanoEntity::new, SpawnGroup.MISC).dimensions(0.4f, 0.4f).build());

    public static final EntityType<GlowballEntity> GLOWBALL = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(JaizMod.MOD_ID, "glowball"),
            EntityType.Builder.<GlowballEntity>create(GlowballEntity::new, SpawnGroup.MISC).dimensions(0.4f, 0.4f).build());

    public static final EntityType<FruitBatEntity> FRUIT_BAT = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(JaizMod.MOD_ID, "fruit_bat"),
            EntityType.Builder.create(FruitBatEntity::new, SpawnGroup.AMBIENT).dimensions(0.6f, 1.0f).build());

    public static final EntityType<ButterflyEntity> BUTTERFLY = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(JaizMod.MOD_ID, "butterfly"),
        EntityType.Builder.create(ButterflyEntity::new, SpawnGroup.CREATURE).dimensions(0.6f, 0.6f).build());

    public static final EntityType<FireFlySwarmEntity> FIRE_FLY_SWARM = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(JaizMod.MOD_ID, "fire_fly_swarm"),
        EntityType.Builder.create(FireFlySwarmEntity::new, SpawnGroup.CREATURE).dimensions(1.0f, 1.0f).build());

    public static final EntityType<DragonflyEntity> DRAGONFLY = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(JaizMod.MOD_ID, "dragonfly"),
        EntityType.Builder.create(DragonflyEntity::new, SpawnGroup.CREATURE).dimensions(0.7f, 0.7f).build());

    public static final EntityType<CaterpillarEntity> CATERPILLAR = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(JaizMod.MOD_ID, "caterpillar"),
        EntityType.Builder.create(CaterpillarEntity::new, SpawnGroup.CREATURE).dimensions(0.6f, 0.4f).build());

    public static final EntityType<SnailEntity> SNAIL = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(JaizMod.MOD_ID, "snail"),
        EntityType.Builder.create(SnailEntity::new, SpawnGroup.CREATURE).dimensions(.4f, .4f).build());
}

