//package net.georgidenis.balkanexpansion.entity.client;
//
//import net.georgidenis.balkanexpansion.BalkansExpansion;
//import net.georgidenis.balkanexpansion.entity.custom.FriendlySkeleton;
//import net.georgidenis.balkanexpansion.entity.ModEntities;
//
//import net.minecraft.client.renderer.entity.SkeletonRenderer;
//import net.neoforged.api.distmarker.Dist;
//import net.neoforged.bus.api.SubscribeEvent;
//import net.neoforged.fml.common.EventBusSubscriber;
//import net.neoforged.neoforge.client.event.EntityRenderersEvent;
//
//@EventBusSubscriber(modid = BalkansExpansion.MOD_ID, value = Dist.CLIENT)
//public final class ModEntityRenderers {
//
//    @SubscribeEvent
//    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
//        event.registerEntityRenderer(
//                ModEntities.FRIENDLY_SKELETON.get(),
//                SkeletonRenderer::new
//        );
//    }
//}

package net.georgidenis.balkanexpansion.entity.client;

import net.georgidenis.balkanexpansion.BalkansExpansion;
import net.georgidenis.balkanexpansion.entity.ModEntities;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = BalkansExpansion.MOD_ID, value = Dist.CLIENT)
public final class ModEntityRenderers {

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // register renderer using the registered entity type
        event.registerEntityRenderer(ModEntities.FRIENDLY_SKELETON.get(), SkeletonRenderer::new);
    }
}