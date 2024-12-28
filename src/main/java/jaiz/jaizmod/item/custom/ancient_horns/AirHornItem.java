package jaiz.jaizmod.item.custom.ancient_horns;

import jaiz.jaizmod.sound.ModSounds;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.WindChargeEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.List;

import static net.minecraft.entity.projectile.AbstractWindChargeEntity.EXPLOSION_BEHAVIOR;

public class AirHornItem extends GoatHornItem {


    public AirHornItem(Settings settings, TagKey<Instrument> instrumentTag) {
        super(settings, instrumentTag);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        MutableText mutableText = Text.translatable(Util.createTranslationKey("instrument", Identifier.of("air_horn")));
        tooltip.add(mutableText.formatted(Formatting.GRAY));
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        if (!user.getAbilities().creativeMode) {
            itemStack.damage(1, user, LivingEntity.getSlotForHand(hand));
        }
        world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.AIR_HORN, SoundCategory.PLAYERS, 15.0f, user.getPitch() * -0.05f + 1f);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_BREEZE_IDLE_GROUND, SoundCategory.PLAYERS, 3.0f, user.getPitch() * -0.05f + 1f);


        if(user.isSneaking()){
            user.getItemCooldownManager().set(this, 320);
            if(user.getWorld().getBlockState(user.getBlockPos().down()).isAir()){
            user.addVelocity(0, 1.5, 0);} else{
            WindChargeEntity windChargeEntity = new WindChargeEntity(user, world, user.getPos().getX(), user.getEyePos().getY(), user.getPos().getZ());
            windChargeEntity.setVelocity(user, 90, 90, 0.0F, 1.5F, 1.0F);
            world.spawnEntity(windChargeEntity);}
        }else{
            user.setVelocity(user.getVelocity().withAxis(Direction.Axis.Y, 0.01F));
            user.getWorld()
                    .createExplosion(
                            user,
                            null,
                            EXPLOSION_BEHAVIOR,
                            user.getX(),
                            user.getY(),
                            user.getZ(),
                            9.0F,
                            false,
                            World.ExplosionSourceType.TRIGGER,
                            ParticleTypes.GUST_EMITTER_SMALL,
                            ParticleTypes.GUST_EMITTER_LARGE,
                            SoundEvents.ENTITY_WIND_CHARGE_WIND_BURST
                    );
            user.getItemCooldownManager().set(this, 120);
        }
        return TypedActionResult.fail(itemStack);
    }
}
