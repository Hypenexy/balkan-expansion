package net.georgidenis.balkanexpansion.item.util;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {

    public static final Tier LAPIS = new SimpleTier(
            ModTags.Blocks.INCORRECT_NEEDS_LAPIS,
            1124,
            5.0F,
            1F,
            30,
            () -> Ingredient.of(Items.LAPIS_LAZULI)
    );

}