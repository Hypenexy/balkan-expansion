package net.georgidenis.balkanexpansion;

import net.fabricmc.api.ModInitializer;

import net.georgidenis.balkanexpansion.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BalkanExpansion implements ModInitializer {
	public static final String MOD_ID = "balkan-expansion";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerModItems();
	}
}