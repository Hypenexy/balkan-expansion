package net.georgidenis.balkanexpansion.item;

import net.georgidenis.balkanexpansion.BalkansExpansion;
import net.georgidenis.balkanexpansion.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BalkansExpansion.MOD_ID);

    // The Balkans' Items Creative tab menu
    public static final Supplier<CreativeModeTab> BALKANS_ITEMS_TAB = CREATIVE_MODE_TAB.register("balkans_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DONER.get()))
                    .title(Component.translatable("itemgroup.balkansexpansion.the_balkans_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.DONER);
                        output.accept(ModBlocks.KEBAB_MASTER);
                        output.accept(ModItems.NECROMANCER_SCROLL);
                        output.accept(ModBlocks.BRONZE_ORE);
                        output.accept(ModBlocks.FRIDGE.get());
                        output.accept(ModItems.FRIENDLY_SKELETON_SPAWN_EGG);
                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
