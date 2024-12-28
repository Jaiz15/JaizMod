package jaiz.jaizmod.item.custom;

import jaiz.jaizmod.sound.ModSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class MayanSwordItem extends SwordItem {
    public MayanSwordItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BLOCK;
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 30;
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        if(!user.getOffHandStack().isOf(Items.SHIELD)){
            user.getItemCooldownManager().set(this, 60);
        } else{
            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.SHIELD_DRUM, SoundCategory.PLAYERS, 1.0f, user.getPitch() * -0.05f + 1f);
        }
        if (!user.getAbilities().creativeMode) {
            itemStack.damage(1, user, LivingEntity.getSlotForHand(hand));
        }
        return TypedActionResult.consume(itemStack);
    }
}
