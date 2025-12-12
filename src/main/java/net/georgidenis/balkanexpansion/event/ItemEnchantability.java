package net.georgidenis.balkanexpansion.event;

import net.georgidenis.balkanexpansion.item.custom.LapisSword;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AnvilUpdateEvent;

import java.io.Console;

@EventBusSubscriber(modid = "balkansexpansion")
public class ItemEnchantability {

    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {

        //gets items one the left and right slots
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();

        // This checks if the lapis sword
        // is on the left and if the right side is not empty
        if (!(left.getItem() instanceof LapisSword)) return;
        if (right.isEmpty()) return;


        ItemEnchantments rightEnchs;

        if (right.getItem().toString().equals("minecraft:enchanted_book")){
            System.out.println("WE GOT A BOOK");
            System.out.println("WE GOT A BOOK");
            System.out.println("WE GOT A BOOK");

            rightEnchs =
                    right.getOrDefault(DataComponents.STORED_ENCHANTMENTS, ItemEnchantments.EMPTY);

        } else if (right.getItem().toString().equals("balkansexpansion:lapis_sword")) {
            System.out.println("WE GOT A SWORD");
            System.out.println("WE GOT A SWORD");
            System.out.println("WE GOT A SWORD");
            rightEnchs =
                    right.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
        }
        else {
            return;
        }

        //right side has enchantments check
        if (rightEnchs.isEmpty()) return;

        //Copies the left items so that I can change its output
        ItemStack out = left.copy();
        final ItemEnchantments finalRightEnchs = rightEnchs;

        int increaseNCost[] = {0};

        //for each enchantment in the right item.
        // Increase the output level for the lapis sword
        EnchantmentHelper.updateEnchantments(out, ench -> {
            for (var entry : finalRightEnchs.entrySet()) {
                if (ench.getLevel(entry.getKey()) == entry.getIntValue()){
                    ench.set(entry.getKey(),
                            ench.getLevel(entry.getKey()) + 1);
                }
                else{
                    ench.set(entry.getKey(),
                            ench.getLevel(entry.getKey()) + entry.getIntValue() - ench.getLevel(entry.getKey()));

                }
                increaseNCost[0] += (entry.getIntValue() + ench.getLevel(entry.getKey()));
            }
        });

        System.out.println();
        // These 3 lines are all you need:
        event.setOutput(out);
        event.setCost(increaseNCost[0]);
        event.setMaterialCost(1);
    }
}