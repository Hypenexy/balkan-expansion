package net.georgidenis.balkanexpansion.villager;

import com.google.common.collect.ImmutableSet;
import net.georgidenis.balkanexpansion.BalkansExpansion;
import net.georgidenis.balkanexpansion.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
        DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, BalkansExpansion.MOD_ID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
        DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, BalkansExpansion.MOD_ID);

    public static final Holder<PoiType> TURK_POI = POI_TYPES.register("turk_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.KEBAB_MASTER.get().getStateDefinition().getPossibleStates()), 1, 1));


    public static final Holder<VillagerProfession> TURK = VILLAGER_PROFESSIONS.register("turk",
            () -> new VillagerProfession("turk", holder -> holder.value() == TURK_POI.value(),
                    poiTypeHolder -> poiTypeHolder.value() == TURK_POI.value(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_ARMORER
            ));

    public static void register(IEventBus eventBus){
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }


}
