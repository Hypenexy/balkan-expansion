package net.georgidenis.balkanexpansion.entity.client;

import net.georgidenis.balkanexpansion.entity.custom.FriendlySkeleton;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.resources.ResourceLocation;

public class FriendlySkeletonRenderer extends HumanoidMobRenderer<FriendlySkeleton, HumanoidModel<FriendlySkeleton>> {

    public FriendlySkeletonRenderer(EntityRendererProvider.Context context) {
        super(context,
                new HumanoidModel<>(context.bakeLayer(ModelLayers.SKELETON)), // or PLAYER, or custom
                0.5f
        );
    }

    @Override
    public ResourceLocation getTextureLocation(FriendlySkeleton entity) {
        return ResourceLocation.fromNamespaceAndPath(
                "minecraft",
                "textures/entity/skeleton/skeleton.png"
        );
    }
}