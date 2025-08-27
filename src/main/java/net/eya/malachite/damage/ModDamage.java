package net.eya.malachite.damage;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;

public class ModDamage {
    public static DamageSource energy(LivingEntity attacker) {
        return new DamageSource("energy").setBypassesArmor().setUnblockable();
    }
}
