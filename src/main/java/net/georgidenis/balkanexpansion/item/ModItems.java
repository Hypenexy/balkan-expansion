package net.georgidenis.balkanexpansion.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.georgidenis.balkanexpansion.BalkanExpansion;
import net.georgidenis.balkanexpansion.block.ModBlocks;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item DONER = registerItem("doner", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(BalkanExpansion.MOD_ID, "doner")))));
    public static final Item LAPIS_SWORD = registerItem("lapis_sword", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(BalkanExpansion.MOD_ID, "lapis_sword")))));
    public static final Item RAW_BRONZE = registerItem("raw_bronze", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(BalkanExpansion.MOD_ID, "raw_bronze")))));
    public static final Item BRONZE_HELMET = registerItem("bronze_helmet", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(BalkanExpansion.MOD_ID, "bronze_helmet")))));
    public static final Item NECROMANCER_SCROLL = registerItem("necromancer_scroll", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(BalkanExpansion.MOD_ID, "necromancer_scroll")))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BalkanExpansion.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BalkanExpansion.LOGGER.info("Registering Mod Items for " + BalkanExpansion.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAW_BRONZE);


//            entries.add(ModBlocks.KEBAB_MASTER);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(LAPIS_SWORD);
            entries.add(BRONZE_HELMET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(NECROMANCER_SCROLL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(DONER);
        });


    }

    public static void registerFuels() {
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            // You can add multiple items at once in this lambda.
            builder.add(ModItems.NECROMANCER_SCROLL, 300);
        });
    }
}