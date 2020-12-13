package xyz.przemyk.fansmod.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import xyz.przemyk.fansmod.registry.Items;

import java.util.List;

public class LeafBlowerItem extends Item {

    public LeafBlowerItem() {
        super(new Properties().group(Items.FANS_ITEM_GROUP).maxStackSize(1));
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return Integer.MAX_VALUE;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.setActiveHand(handIn);
        return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
    }

    @Override
    public void onUsingTick(ItemStack stack, LivingEntity player, int count) {
        double yaw = Math.toRadians(player.rotationYaw);
        double pitch = Math.toRadians(player.rotationPitch);
        Vector3d front = new Vector3d(-Math.sin(yaw) * Math.cos(pitch), -Math.sin(pitch), Math.cos(yaw) * Math.cos(pitch));
        player.setMotion(player.getMotion().subtract(front.scale(0.05)));

        List<Entity> entitiesAroundPlayer = player.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(player.getPosX() - 5, player.getPosY() - 5, player.getPosZ() - 5, player.getPosX() + 5, player.getPosY() + 5, player.getPosZ() + 5));
        entitiesAroundPlayer.remove(player);
        for (Entity entity : entitiesAroundPlayer) {
            Vector3d relativePos = entity.getPositionVec().subtract(player.getPositionVec());
            if (relativePos.dotProduct(front) > 0.9) {
                entity.setMotion(entity.getMotion().add(relativePos.normalize().scale((Math.tanh(relativePos.length()) + 1.0) / 4)));
            }
        }
    }
}
