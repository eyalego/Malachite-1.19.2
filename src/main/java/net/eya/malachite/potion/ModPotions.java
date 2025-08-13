package net.eya.malachite.potion;

import net.eya.malachite.Malachite;
import net.eya.malachite.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModPotions {
    public static final Potion MAGIC_RESISTANCE_POTION = new Potion(new StatusEffectInstance(ModEffects.MAGIC_RESISTANCE, 3600));
    public static final Potion LONG_MAGIC_RESISTANCE_POTION = new Potion(new StatusEffectInstance(ModEffects.MAGIC_RESISTANCE, 9600));

    public static void registerPotions() {
        Registry.register(Registry.POTION, new Identifier(Malachite.MOD_ID, "magic_resistance"), MAGIC_RESISTANCE_POTION);
        Registry.register(Registry.POTION, new Identifier(Malachite.MOD_ID, "long_magic_resistance"), LONG_MAGIC_RESISTANCE_POTION);
    }
}
