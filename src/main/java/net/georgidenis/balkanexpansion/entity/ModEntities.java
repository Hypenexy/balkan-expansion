package net.georgidenis.balkanexpansion.entity;

import net.georgidenis.balkanexpansion.BalkansExpansion;
import net.georgidenis.balkanexpansion.entity.custom.FriendlySkeleton;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

//In here you register entities MANDATORY IF YOU WANT TO SEE THEM IN GAME
public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, BalkansExpansion.MOD_ID);


    public static final DeferredHolder<EntityType<?>, EntityType<FriendlySkeleton>> FRIENDLY_SKELETON =
            ENTITY_TYPES.register("friendly_skeleton",
                    () -> EntityType.Builder.<FriendlySkeleton>of(FriendlySkeleton::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.99f)
                            .build(
                                    ResourceLocation.fromNamespaceAndPath(
                                            BalkansExpansion.MOD_ID,
                                            "friendly_skeleton"
                                    ).toString()
                            )
            );

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}