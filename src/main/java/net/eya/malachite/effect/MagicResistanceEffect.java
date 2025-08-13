package net.eya.malachite.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

import java.util.UUID;

public class MagicResistanceEffect extends StatusEffect {
    public MagicResistanceEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0x38624b);
    }
}
