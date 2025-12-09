package net.georgidenis.balkanexpansion.item.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> INCORRECT_FOR_LAPIS =
                TagKey.create(
                        Registries.BLOCK,
                        ResourceLocation.fromNamespaceAndPath("balkanexpansion", "incorrect_for_lapis")
                );
    }
}