package net.georgidenis.balkanexpansion.item;

import net.minecraft.component.type.FoodComponent;
//import net.minecraft.entity.effect.StatusEffectInstance;
//import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent DONER = new FoodComponent.Builder()
            .nutrition(8)
            .saturationModifier(0.5f)
//            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200), 0.15f) Implementaciqta e druga
            //ENCHANTED_GOLDEN_APPLE = food().consumeEffect(new ApplyEffectsConsumeEffect(List.of(new StatusEffectInstance(StatusEffects.REGENERATION, 400, 1), new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 0), new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0), new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 3)))).build();
            .build();


}
