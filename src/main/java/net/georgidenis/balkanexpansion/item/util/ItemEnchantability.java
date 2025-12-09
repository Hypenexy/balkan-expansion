package net.georgidenis.balkanexpansion.item.util;


import net.georgidenis.balkanexpansion.item.custom.LapisSword;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.enchanting.GetEnchantmentLevelEvent;


@EventBusSubscriber(modid = "balkanexpansion")
public class ItemEnchantability {
    @SubscribeEvent
    public void onGetEnchLevel(GetEnchantmentLevelEvent event) {

        ItemEnchantments.Mutable ench = event.getEnchantments();

        ItemStack stack = event.getStack();
        if (!(stack.getItem() instanceof LapisSword)) return;


        // What enchantment is being queried?
        Holder<Enchantment> target = event.getTargetEnchant();
        if (target == null) return;

        // Example: change Sharpness levels
        ResourceKey<Enchantment> SHARPNESS_KEY = Enchantments.SHARPNESS;

        // Check if this event is for Sharpness
        if (!target.is(SHARPNESS_KEY)) return;

        // Read current level
        int current = ench.getLevel(target);

        // Modify it (example: +2 levels)
        int boosted = current + 2;

        // APPLY modification correctly
        ench.set(target, boosted);   // <-- THIS IS THE CORRECT METHOD
    }
}