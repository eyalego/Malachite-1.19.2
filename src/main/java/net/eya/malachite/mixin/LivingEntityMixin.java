package net.eya.malachite.mixin;

import net.eya.malachite.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Inject(method = "damage", at = @At("HEAD"))
    private void applyOverchargedDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity)(Object)this;
        if (self.hasStatusEffect(ModEffects.OVERCHARGED)) {
            self.setHealth(self.getHealth() - 2.0F);

            Vec3d velocity = self.getVelocity();
            self.setVelocity(velocity.x * 2, velocity.y, velocity.z * 2);
        }
    }
}

