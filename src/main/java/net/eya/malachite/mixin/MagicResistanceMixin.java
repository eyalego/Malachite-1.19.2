package net.eya.malachite.mixin;

import net.eya.malachite.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class MagicResistanceMixin {
    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    private float ignoreMagicDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;
        double reducedDamage = amount * 0.25;
        if (source.isMagic()) {
            if (self.hasStatusEffect(ModEffects.MAGIC_RESISTANCE)) {
                return (float) reducedDamage;
            }
        }
        return amount;
    }
}
