package net.georgidenis.balkanexpansion.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.georgidenis.balkanexpansion.BalkanExpansion;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup THE_BALKANS_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BalkanExpansion.MOD_ID, "the_balkans_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.DONER))
                    .displayName(Text.translatable("itemgroup.balkan-expansion.the_balkans_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.DONER);
                        entries.add(ModItems.LAPIS_SWORD);
                        entries.add(ModItems.NECROMANCER_SCROLL);
                    }).build());

    public static void registerItemGroups(){
        BalkanExpansion.LOGGER.info("Registering Item Groups for " + BalkanExpansion.MOD_ID);
    }
}
