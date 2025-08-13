package net.eya.malachite.effect;

import net.eya.malachite.Malachite;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static final StatusEffect MAGIC_RESISTANCE = new MagicResistanceEffect();

    public static void registerEffects() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier(Malachite.MOD_ID, "magic_resistance"), MAGIC_RESISTANCE);
    }
}