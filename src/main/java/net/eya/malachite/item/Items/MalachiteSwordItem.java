package net.eya.malachite.item.Items;

import net.eya.malachite.damage.ModDamage;
import net.eya.malachite.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.TridentItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class MalachiteSwordItem extends SwordItem {
    public MalachiteSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
    private static final String CHARGE_KEY = "Charge";
    private static final int MAX_CHARGE = 5;


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        NbtCompound nbt = stack.getOrCreateNbt();
        int charge = nbt.getInt(CHARGE_KEY);
        if (charge < MAX_CHARGE) {
            nbt.putInt(CHARGE_KEY, charge + 1);
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        assert stack.getNbt() != null;
        int charge = stack.getNbt().getInt(CHARGE_KEY);
        if (charge == MAX_CHARGE) {
            return UseAction.SPEAR;
        } else {
            return null;
        }
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!(user instanceof PlayerEntity playerEntity)) return;

        int i = this.getMaxUseTime(stack) - remainingUseTicks;
        if (i < 10) return;

        float f = playerEntity.getYaw();
        float g = playerEntity.getPitch();
        float h = -MathHelper.sin(f * ((float) Math.PI / 180.0F)) * MathHelper.cos(g * ((float) Math.PI / 180.0F));
        float k = -MathHelper.sin(g * ((float) Math.PI / 180.0F));
        float l = MathHelper.cos(f * ((float) Math.PI / 180.0F)) * MathHelper.cos(g * ((float) Math.PI / 180.0F));
        float m = MathHelper.sqrt(h * h + k * k + l * l);
        float n = 3.0F * ((1.0F * 2) / 4.0F);
        h = n / m;
        k= n / m;
        l *= n / m;

        playerEntity.addVelocity(h, k, l);
        playerEntity.useRiptide(15);
        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }
}



