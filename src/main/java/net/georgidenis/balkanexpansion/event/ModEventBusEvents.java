/*package net.georgidenis.balkanexpansion.event;

import net.georgidenis.balkanexpansion.BalkansExpansion;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = BalkansExpansion.MOD_ID)
public class ModEventBusEvents {

}*/
package net.georgidenis.balkanexpansion.event;

import net.georgidenis.balkanexpansion.entity.ModEntities;
import net.georgidenis.balkanexpansion.entity.custom.FriendlySkeleton;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

@EventBusSubscriber
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent event) {
        event.put(ModEntities.FRIENDLY_SKELETON.get(), FriendlySkeleton.createAttributes().build());
    }
}