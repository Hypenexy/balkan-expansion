//package net.georgidenis.balkanexpansion.item.util;
//import net.georgidenis.balkanexpansion.item.custom.LapisSword;
//import net.minecraft.core.Holder;
//import net.minecraft.core.component.DataComponents;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.enchantment.Enchantment;
//import net.minecraft.world.item.enchantment.Enchantments;
//import net.minecraft.world.item.enchantment.EnchantmentHelper;
//import net.minecraft.world.item.enchantment.ItemEnchantments;
//import net.neoforged.bus.api.SubscribeEvent;
//import net.neoforged.fml.common.EventBusSubscriber;
//import net.neoforged.neoforge.event.AnvilUpdateEvent;
//import net.neoforged.neoforge.event.enchanting.GetEnchantmentLevelEvent;
//import net.neoforged.neoforge.event.entity.player.AnvilRepairEvent;
//import org.apache.commons.lang3.mutable.Mutable;
//
//
//@EventBusSubscriber(modid = "balkanexpansion")
//public class ItemEnchantability {
////    @SubscribeEvent
////    public static void onEnchantCheck(GetEnchantmentLevelEvent event){
////        ItemEnchantments.Mutable enchantments = event.getEnchantments();
////
////
////
////        System.out.println(enchantments);
////    }
//
//    @SubscribeEvent
//    public void onAnvilUpdate(AnvilUpdateEvent event) {
//        ItemStack left = event.getLeft();
//        ItemStack right = event.getRight();
//
//        if (!(left.getItem() instanceof LapisSword)) return;
//
//        ItemStack out = left.copy();
//
//        // Merge enchantments
//        EnchantmentHelper.updateEnchantments(out, ench -> {
//            ItemEnchantments rightEnchs =
//                    right.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
//
//            for (var e : rightEnchs.entrySet()) {
//                var enchType = e.getKey();
//                int rightLevel = e.getIntValue();
//                int currentLevel = ench.getLevel(enchType);
//                ench.set(enchType, currentLevel + rightLevel); // no max cap
//            }
//        });
//
//        event.setOutput(out);
//        event.setCost(5);
//        event.setMaterialCost(1);
//        event.setCanceled(true);
//    }
//
//    @SubscribeEvent
//    public void onAnvilRepair(AnvilRepairEvent event) {
//        ItemStack out = event.getOutput();
//
//        // SAME MERGE LOGIC AGAIN — THIS TIME OVERWRITING VANILLA'S FINAL CHECK
//        EnchantmentHelper.updateEnchantments(out, ench -> {
//            ItemEnchantments rightEnchs =
//                    event.getRight().getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
//
//            for (var e : rightEnchs.entrySet()) {
//                var enchType = e.getKey();
//                int rightLevel = e.getIntValue();
//                int currentLevel = ench.getLevel(enchType);
//                ench.set(enchType, currentLevel + rightLevel);
//            }
//        });
//
//        event.setOutput(out);
//    }
//}