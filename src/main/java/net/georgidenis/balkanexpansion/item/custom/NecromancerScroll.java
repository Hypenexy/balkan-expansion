package net.georgidenis.balkanexpansion.item.custom;

import net.georgidenis.balkanexpansion.entity.ModEntities;
import net.georgidenis.balkanexpansion.entity.custom.FriendlySkeleton;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class NecromancerScroll extends Item {

    public NecromancerScroll(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (level.isClientSide()) return InteractionResult.SUCCESS;

        Player player = context.getPlayer();
        BlockPos pos = context.getClickedPos().relative(context.getClickedFace());

        FriendlySkeleton skeleton = ModEntities.FRIENDLY_SKELETON.get().create(level);
        if (skeleton == null) return InteractionResult.FAIL;

        skeleton.moveTo(
                pos.getX() + 0.5,
                pos.getY(),
                pos.getZ() + 0.5,
                level.random.nextFloat() * 360F,
                0
        );

        skeleton.tame(player);
        skeleton.setOwnerUUID(player.getUUID());
        skeleton.setOrderedToSit(false);

        level.addFreshEntity(skeleton);

        // consume item unless creative
        if (!player.getAbilities().instabuild) {
            context.getItemInHand().shrink(1);
        }

        return InteractionResult.SUCCESS;
    }
}
