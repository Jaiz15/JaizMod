package jaiz.jaizmod.item.custom.teas;


import jaiz.jaizmod.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;

public class GunPowderTeaItem
        extends TeaItem {
    public GunPowderTeaItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!user.getWorld().isClient) {
            user.emitGameEvent(GameEvent.DRINK);
            user.getWorld().createExplosion(user, user.getX(), user.getY(),
                    user.getZ(), 3, World.ExplosionSourceType.TNT);
            if (user instanceof PlayerEntity && !((PlayerEntity) user)
                    .getAbilities().creativeMode) {
                user.damage(user.getDamageSources().explosion(null), 20);
            }
        }
        ItemStack itemStack = super.finishUsing(stack, world, user);
        if (user instanceof PlayerEntity && ((PlayerEntity) user).getAbilities().creativeMode) {
            user.emitGameEvent(GameEvent.DRINK);
            return itemStack;
        }
        return new ItemStack(ModItems.TEA_CUP);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

}