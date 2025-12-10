package net.georgidenis.balkanexpansion.mixin;

import net.georgidenis.balkanexpansion.item.custom.LapisSword;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnvilMenu.class)
public class AnvilMenuMixin {
    @Inject(method = "createResult", at = @At("HEAD"), cancellable = true)
    private void apoth_allowHighLevels(CallbackInfo ci) {
        // get left/right slots from the menu (field names depend on mappings)
        ItemStack left = ((AnvilMenu)(Object)this).getSlot(0).getItem();
        ItemStack right = ((AnvilMenu)(Object)this).getSlot(1).getItem();

        if (left.getItem() instanceof LapisSword) {
            ItemStack out = left.copy();
            // merge enchantments (use EnchantmentHelper.updateEnchantments)
            EnchantmentHelper.updateEnchantments(out, ench -> {
                ItemEnchantments rightEnchs = right.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
                for (var entry : rightEnchs.entrySet()) {
                    var type = entry.getKey();
                    int lvl = entry.getIntValue();
                    ench.set(type, ench.getLevel(type) + lvl); // no clamp
                }
            });

            // set the anvil menu's output slot directly
            ((AnvilMenu)(Object)this).getSlot(2).set(out); // or menu.setItem(2, out)
            // cancel vanilla so we don't run their clamping logic
            ci.cancel();
        }
    }
}