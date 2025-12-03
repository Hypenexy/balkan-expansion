package net.georgidenis.balkanexpansion.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.georgidenis.balkanexpansion.BalkanExpansion;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item DONER = registerItem("doner", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(BalkanExpansion.MOD_ID,"doner")))));
    public static final Item LAPIS_SWORD = registerItem("lapis_sword", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(BalkanExpansion.MOD_ID,"lapis_sword")))));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(BalkanExpansion.MOD_ID, name), item);
    }

    public static void registerModItems(){
        BalkanExpansion.LOGGER.info("Registering Mod Items for " + BalkanExpansion.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(DONER);
            entries.add(LAPIS_SWORD);
        });
    }
}
