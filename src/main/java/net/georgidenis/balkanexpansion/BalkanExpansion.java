package net.georgidenis.balkanexpansion;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.georgidenis.balkanexpansion.block.ModBlocks;
import net.georgidenis.balkanexpansion.item.ModItemGroups;
import net.georgidenis.balkanexpansion.item.ModItems;
import net.georgidenis.balkanexpansion.villager.ModVillagers;
import net.minecraft.item.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BalkanExpansion implements ModInitializer {
	public static final String MOD_ID = "balkan-expansion";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();

        ModItems.registerModItems();

        ModItems.registerFuels();

        ModBlocks.registerModBlocks();

        ModVillagers.registerVillagers();
	}
}