package jaiz.jaizmod.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.item.SpyglassItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GlowingSpyGlassItem extends SpyglassItem {

    public GlowingSpyGlassItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.getItemCooldownManager().set(this, 60);
        int o = user.getRandom().nextInt(9) + 3;
        for (int i = 0; i < o; i++) {
            user.getWorld().addParticle(ParticleTypes.GLOW, user.getParticleX(1.2), user.getRandomBodyY(), user.getParticleZ(1.2), 0.0, 0.0, 0.0);
        }
        if(user.getRandom().nextInt(150) == 1){
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.PLAYERS, 1.0f, user.getRandom().nextInt(3) * -0.05f + 1f);
            user.getStackInHand(hand).decrement(1);
            user.removeStatusEffect(StatusEffects.NIGHT_VISION);
            user.giveItemStack(Items.SPYGLASS.getDefaultStack());
        } else{
        user.playSound(SoundEvents.ENTITY_GLOW_SQUID_AMBIENT, 1.0F, 1.0F);
        user.playSound(SoundEvents.ITEM_SPYGLASS_USE, 1.0F, 1.0F);
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1200, 0, false, false));
        }
        return ItemUsage.consumeHeldItem(world, user, hand);
    }


    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        user.removeStatusEffect(StatusEffects.NIGHT_VISION);
        this.playStopUsingSound(user);
    }

    private void playStopUsingSound(LivingEntity user) {
        user.playSound(SoundEvents.ITEM_SPYGLASS_STOP_USING, 1.0F, 1.0F);
        user.playSound(SoundEvents.ENTITY_GLOW_SQUID_AMBIENT, 1.0F, 0.7F);
    }

}
