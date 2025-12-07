package net.georgidenis.balkanexpansion.item;

import net.georgidenis.balkanexpansion.BalkansExpansion;
import net.georgidenis.balkanexpansion.entity.ModEntities;
import net.georgidenis.balkanexpansion.item.custom.LapisSword;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.SwordItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.minecraft.world.item.Tiers.NETHERITE;

public class ModItems {
    // Basically a list of all the items we want to register
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BalkansExpansion.MOD_ID);

    // Registers the item and sets its name: that is used for us to call it
    public static final DeferredItem<Item> DONER = ITEMS.register("doner",
            () -> new Item(new Item.Properties().food(ModFoodProperty.DONER)));

    public static final DeferredItem<Item> NECROMANCER_SCROLL = ITEMS.register("necromancer_scroll",
            () -> new Item(new Item.Properties()));

    // Assuming ITEMS is a DeferredRegister<Item>
    public static final Supplier<LapisSword> LAPIS_SWORD = ITEMS.register("lapis_sword", () -> new LapisSword(
            NETHERITE, // Your custom or vanilla Tier object
            new Item.Properties().attributes(
                    LapisSword.createAttributes(
                            NETHERITE, // Must match the tier used in the constructor
                            1.0f,    // Base attack damage bonus for swords
                            -1.6f     // Base attack speed bonus for swords // Nerfed by georgi
                    )
            )
    ));

    public static final DeferredItem<Item> FRIENDLY_SKELETON_SPAWN_EGG = ITEMS.register("friendly_skeleton_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.FRIENDLY_SKELETON, 0x31afaf, 0xffac00,
                    new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}