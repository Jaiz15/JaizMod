package jaiz.jaizmod.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import jaiz.jaizmod.entity.ModEntities;
import jaiz.jaizmod.entity.bandit.BanditEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(IronGolemEntity.class)
public class IronGolemEntityMixin extends GolemEntity {
    protected IronGolemEntityMixin(EntityType<? extends GolemEntity> entityType, World world) {
        super(entityType, world);
    }


    @ModifyReturnValue(at = @At("TAIL"), method = "canTarget")
    public boolean canTarget(boolean original, EntityType<?> type) {
        if(type == ModEntities.BANDIT){
        return false;
        }
        return original;
    }

}
