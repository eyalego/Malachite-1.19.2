package net.eya.malachite.mixin;

import net.eya.malachite.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class MagicResistanceMixin {
    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    private void ignoreMagicDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (source.isMagic()) {
            if (self.hasStatusEffect(ModEffects.MAGIC_RESISTANCE)) { // Replace with your effect
                cir.setReturnValue(false); // Cancel damage
            }
        }
    }
}
