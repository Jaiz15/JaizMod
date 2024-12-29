package jaiz.jaizmod.entity.thrown_entity;

import jaiz.jaizmod.entity.ModEntities;
import jaiz.jaizmod.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;


public class DynamiteEntity extends ThrownItemEntity {
    public DynamiteEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }



    public int k = 120;

    public DynamiteEntity(LivingEntity livingEntity, World world) {
        super(jaiz.jaizmod.entity.ModEntities.DYNAMITE, livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return jaiz.jaizmod.item.ModItems.DYNAMITE;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        this.explode();
        entity.damage(this.getDamageSources().explosion(null,
                null), 12);
        super.onEntityHit(entityHitResult);
    }

    private void explode() {
        if (!this.getWorld().isClient) {
            this.getWorld().createExplosion(this, this.getX(), this.getY(),
                    this.getZ(), 2, World.ExplosionSourceType.TNT);
            this.discard();
        }
    }


    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.explode();
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.getWorld().isClient) {
            this.getWorld().addParticle(ParticleTypes.SMALL_FLAME, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
            if(k == 0) {
                this.explode();
            } else {
                k --;
            }
        }
    }

    @Override
    public boolean isPushedByFluids() {
        return false;
    }

}
