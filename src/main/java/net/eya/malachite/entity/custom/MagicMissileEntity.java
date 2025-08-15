package net.eya.malachite.entity.custom;


import net.eya.malachite.entity.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MagicMissileEntity extends PersistentProjectileEntity {
    public MagicMissileEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }


    @Override
    public boolean hasNoGravity() {
        return true;
    }


    @Override
    protected ItemStack asItemStack() {
        return null;
    }
    }


