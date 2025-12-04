package net.georgidenis.balkanexpansion.item;

import net.georgidenis.balkanexpansion.BalkansExpansion;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    // Basically a list of all the items we want to register
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BalkansExpansion.MOD_ID);

    // Registers the item and sets its name: that is used for us to call it
    public static final DeferredItem<Item> DONER = ITEMS.register("doner",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NECROMANCER_SCROLL = ITEMS.register("necromancer_scroll",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}