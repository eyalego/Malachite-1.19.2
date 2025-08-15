package net.eya.malachite.entity;

import net.eya.malachite.Malachite;
import net.eya.malachite.entity.custom.MagicMissileEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<MagicMissileEntity> MAGIC_MISSILE = net.minecraft.util.registry.Registry.register(net.minecraft.util.registry.Registry.ENTITY_TYPE,
            new Identifier(Malachite.MOD_ID, "magic_missile"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, MagicMissileEntity::new).dimensions(EntityDimensions.fixed(0.1f, 0.1f)).build());
public static void register(){}
}
