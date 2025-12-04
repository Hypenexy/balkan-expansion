package net.georgidenis.balkanexpansion.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperty {
    public static  final FoodProperties DONER = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(20f)
            .build();
}
