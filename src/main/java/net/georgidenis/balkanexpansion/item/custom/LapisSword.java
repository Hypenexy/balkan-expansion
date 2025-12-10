package net.georgidenis.balkanexpansion.item.custom;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;


public class LapisSword extends SwordItem {

    public LapisSword(Tier tier, Properties properties) {
        super(tier, properties);
    }
    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantmentValue() {
        return this.getTier().getEnchantmentValue();
    }
}