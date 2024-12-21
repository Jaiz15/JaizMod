package jaiz.jaizmod.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.ParticleGroup;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.MathHelper;

import java.util.Optional;

@Environment(EnvType.CLIENT)
public class FireFlyParticle extends SpriteBillboardParticle {

    FireFlyParticle(ClientWorld world, SpriteProvider spriteProvider, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        super(world, x, y - 0.125, z, velocityX, velocityY, velocityZ);
        this.setBoundingBoxSpacing(0.01F, 0.01F);
        this.setSprite(spriteProvider);
        this.scale = this.scale * 0.5f ;
        this.maxAge = (int)(16.0 / (Math.random() * 0.8 + 0.2));
        this.collidesWithWorld = false;
        this.velocityMultiplier = 1.0F;
        this.gravityStrength = 0.0F;
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_LIT;
    }

    @Override
    public int getBrightness(float tint) {
        int i = super.getBrightness(tint);
        int j = 240;
        int k = i >> 16 & 0xFF;
        return 240 | k << 16;
    }



    @Environment(EnvType.CLIENT)
    public static class FireFlyParticleFactory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public FireFlyParticleFactory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        public Particle createParticle(SimpleParticleType simpleParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
            FireFlyParticle fireflyParticle = new FireFlyParticle(clientWorld, this.spriteProvider, d, e, f, 0.0, -0.8F, 0.0) {
                @Override
                public Optional<ParticleGroup> getGroup() {
                    return Optional.of(ParticleGroup.SPORE_BLOSSOM_AIR);
                }
            };
            fireflyParticle.maxAge = MathHelper.nextBetween(clientWorld.random, 500, 1000);
            fireflyParticle.gravityStrength = 0.00F;
            return fireflyParticle;
        }
    }

}

