package net.georgidenis.balkanexpansion.item.util;

import net.georgidenis.balkanexpansion.item.ModItems;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {

    public static final Tier LAPIS = new SimpleTier(
            ModTags.Blocks.INCORRECT_FOR_LAPIS,   // <-- MUST be a TagKey<Block>
            3,                                     // uses
            5.0F,                                  // speed
            2.0F,                                  // damage
            22,                                    // enchant value
            () -> Ingredient.of(Items.LAPIS_LAZULI)
    );
}