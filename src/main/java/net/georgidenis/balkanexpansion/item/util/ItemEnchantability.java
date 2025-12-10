package net.georgidenis.balkanexpansion.item.util;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.enchanting.GetEnchantmentLevelEvent;
import org.apache.commons.lang3.mutable.Mutable;


@EventBusSubscriber(modid = "balkanexpansion")
public class ItemEnchantability {
    public static void onEnchantCheck(GetEnchantmentLevelEvent event){
        ItemEnchantments.Mutable enchantments = event.getEnchantments();

        

        System.out.println(enchantments);
    }
}