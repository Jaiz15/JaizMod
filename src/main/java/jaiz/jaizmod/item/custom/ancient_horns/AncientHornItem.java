package jaiz.jaizmod.item.custom.ancient_horns;

import jaiz.jaizmod.sound.ModSounds;
import jaiz.jaizmod.statuseffects.ModStatusEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.WindChargeEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;

import java.util.List;

import static net.minecraft.entity.projectile.AbstractWindChargeEntity.EXPLOSION_BEHAVIOR;

public class AncientHornItem extends GoatHornItem {


    public AncientHornItem(Settings settings, TagKey<Instrument> instrumentTag) {
        super(settings, instrumentTag);
    }


    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        MutableText mutableText = Text.translatable(Util.createTranslationKey("instrument", Identifier.of("ancient_horn")));
        tooltip.add(mutableText.formatted(Formatting.GRAY));
    }


    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.TOOT_HORN;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        if (!user.getAbilities().creativeMode) {
            itemStack.damage(1, user, LivingEntity.getSlotForHand(hand));
        }
        world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.ANCIENT_HORN, SoundCategory.PLAYERS, 15.0f, user.getPitch() * -0.05f + 1f);

        if(user.isSneaking()){
            user.getItemCooldownManager().set(this, 320);
            user.clearStatusEffects();
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 180, 1, false, true));

        }
        else
        {
            if (world instanceof ServerWorld) {
                BlockState blockState = world.getBlockState(user.getBlockPos().down());
                BlockState blockState2 = world.getBlockState(user.getBlockPos());
                BlockState blockState3 = world.getBlockState(user.getBlockPos().up());
                if (blockState3.getBlock() instanceof Fertilizable fertilizable && fertilizable.isFertilizable(world, user.getBlockPos().up(), blockState3)) {
                    if (fertilizable.canGrow(world, world.random, user.getBlockPos().up(), blockState3)) {
                        fertilizable.grow((ServerWorld)world, world.random, user.getBlockPos().up(), blockState3);
                    }
                }
                else if (blockState2.getBlock() instanceof Fertilizable fertilizable && fertilizable.isFertilizable(world, user.getBlockPos(), blockState2)) {
                    if (fertilizable.canGrow(world, world.random, user.getBlockPos(), blockState2)) {
                        fertilizable.grow((ServerWorld)world, world.random, user.getBlockPos(), blockState2);
                    }
                }
                else if (blockState.getBlock() instanceof Fertilizable fertilizable && fertilizable.isFertilizable(world, user.getBlockPos().down(), blockState)) {
                    if (fertilizable.canGrow(world, world.random, user.getBlockPos().down(), blockState)) {
                    fertilizable.grow((ServerWorld)world, world.random, user.getBlockPos().down(), blockState);
                }
                }
            }
            int o = user.getRandom().nextInt(9) + 3;
            for (int i = 0; i < o; i++) {
                user.getWorld().addParticle(ParticleTypes.HAPPY_VILLAGER, user.getParticleX(1.2), user.getRandomBodyY(), user.getParticleZ(1.2), 0.0, 0.0, 0.0);
            }

            user.getItemCooldownManager().set(this, 120);
        }

        return TypedActionResult.fail(itemStack);
    }
}
