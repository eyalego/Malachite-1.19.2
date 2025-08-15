package net.eya.malachite;

import net.eya.malachite.effect.ModEffects;
import net.eya.malachite.entity.ModEntities;
import net.eya.malachite.item.ModItems;
import net.eya.malachite.potion.ModPotions;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Malachite implements ModInitializer {
	public static final String MOD_ID = "malachite";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModEntities.register();
		LOGGER.info("Hello Fabric world!");
	}
}