package net.georgidenis.balkanexpansion.item;

import net.georgidenis.balkanexpansion.BalkansExpansion;
import net.georgidenis.balkanexpansion.entity.ModEntities;
import net.georgidenis.balkanexpansion.item.custom.LapisSword;
import net.georgidenis.balkanexpansion.item.custom.NecromancerScroll;
import net.georgidenis.balkanexpansion.item.util.ModToolTiers;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModItems {
    // Basically a list of all the items we want to register
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BalkansExpansion.MOD_ID);

    // Registers the item and sets its name: that is used for us to call it
    public static final DeferredItem<Item> DONER = ITEMS.register("doner",
            () -> new Item(new Item.Properties().food(ModFoodProperty.DONER)));

    public static final DeferredItem<NecromancerScroll> NECROMANCER_SCROLL = ITEMS.register("necromancer_scroll",
            () -> new NecromancerScroll(new NecromancerScroll.Properties()));


    // THE LAPIS SWORD I NEED HELP WITH
    public static final DeferredItem<LapisSword> LAPIS_SWORD = ITEMS.register("lapis_sword",
            () -> new LapisSword(
                    ModToolTiers.LAPIS,
                    new Item.Properties()
                            .attributes(LapisSword.createAttributes(
                                    ModToolTiers.LAPIS, 2, -2f))
            )
    );

    public static final DeferredItem<Item> FRIENDLY_SKELETON_SPAWN_EGG = ITEMS.register("friendly_skeleton_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.FRIENDLY_SKELETON, 0x31afaf, 0xffac00,
                    new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}