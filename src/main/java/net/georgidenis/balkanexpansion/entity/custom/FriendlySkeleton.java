package net.georgidenis.balkanexpansion.entity.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

import static net.minecraft.world.item.Items.BONE;


// Extends tamable animle because when you summon said animal you want it to
// NOT attack you and basically act like the dog entity
public class FriendlySkeleton extends TamableAnimal {
    //Creates a Constructor for the extended Tamable animal subclass
    public FriendlySkeleton(EntityType<? extends FriendlySkeleton> type, Level level) {
        super(type, level);
    }

    //Stats for the mob
    public static AttributeSupplier.Builder createAttributes() {
        return TamableAnimal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ATTACK_DAMAGE, 3.0D)
                .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    // attacks only hostile mobs
    private boolean isValidTarget(LivingEntity target) {
        return target instanceof Monster;
    }

    //Checks to actually do damage to the enemy
    @Override
    public boolean doHurtTarget(Entity target) {
        boolean success = super.doHurtTarget(target);
        if (success) {
            // Optional: add knockback
            double strength = 0.4D;
            target.push(
                    -Math.sin(this.getYRot() * (Math.PI / 180F)) * strength,
                    0.1D,
                    Math.cos(this.getYRot() * (Math.PI / 180F)) * strength
            );
        }
        return success;
    }

    //Adds goals to the ai so that it does actions
    @Override
    protected void registerGoals() {
        // Standard mob behavior, The goal names explain what they do
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.1D, 20.0F, 2.0F));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));


        // Goals for targeting
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, LivingEntity.class, true, this::isValidTarget));
    }

    // isFood is an abstract method from isTamable so I just dont touch it
    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
    }

    //Adds default Skeleton sounds
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SKELETON_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_34172_) {
        return SoundEvents.SKELETON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SKELETON_DEATH;
    }

    //adds player interaction between the player and mob
    public InteractionResult mobInteract(Player player, InteractionHand hand) {

        //gets hand position
        ItemStack itemstack = player.getItemInHand(hand);
        //gets item in hand
        Item item = itemstack.getItem();

        //if the mod is serverside and the item in hand is a bone
        if (!this.level().isClientSide && (itemstack.is(Items.BONE))) {

            // if skeleton is yours
            if (this.isTame()) {
                // if the hp is lower than max hp
                if (this.getHealth() < this.getMaxHealth()) {
                    this.heal(5);
                    itemstack.consume(1, player);
                    this.gameEvent(GameEvent.EAT);
                    return InteractionResult.sidedSuccess(this.level().isClientSide());
                }
            }
        }
        //if it doesnt work it just doesnt do anything
        return InteractionResult.FAIL;
    }

    //Because this counts as an animal it is required to have a breeding offspring
    //option, but I WILL NOT implement it and it WILL return null
    @Nullable
    @Override
    public TamableAnimal getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return null;
    }
}
