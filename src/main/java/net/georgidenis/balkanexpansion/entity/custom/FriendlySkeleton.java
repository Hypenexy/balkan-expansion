package net.georgidenis.balkanexpansion.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class FriendlySkeleton extends Skeleton {
    public FriendlySkeleton(EntityType<? extends Skeleton> entityType, Level level) {
        super(entityType, level);
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));

        // Walk around
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1.0));

        // Look at players
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
    }

    @Override
    public boolean isAggressive() {
        return false;
    }

    @Override
    public boolean canAttack(LivingEntity target) {
        return true;
    }


}