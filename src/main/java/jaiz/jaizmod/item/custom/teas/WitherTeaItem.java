package jaiz.jaizmod.item.custom.teas;


import jaiz.jaizmod.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class WitherTeaItem
        extends TeaItem {
    public WitherTeaItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack itemStack = super.finishUsing(stack, world, user);
        if (user instanceof PlayerEntity && ((PlayerEntity)user).getAbilities().creativeMode) {
            user.emitGameEvent(GameEvent.DRINK);
            return itemStack;
        }
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 2, 1));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 120, 255));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 600, 255));
        return new ItemStack(ModItems.TEA_CUP);
    }
}
