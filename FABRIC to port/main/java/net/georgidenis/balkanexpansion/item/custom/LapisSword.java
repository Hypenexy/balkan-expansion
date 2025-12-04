package net.georgidenis.balkanexpansion.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;

public class LapisSword extends Item {

    public LapisSword(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        // swing animation + print message in console
        if (!world.isClient()) {
            System.out.println("Lapis me4!");
        }

        user.swingHand(hand);

        return ActionResult.SUCCESS;
    }
}
