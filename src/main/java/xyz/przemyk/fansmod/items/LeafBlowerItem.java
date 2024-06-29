package xyz.przemyk.fansmod.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class LeafBlowerItem extends Item {

    public LeafBlowerItem() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity p_344979_) {
        return Integer.MAX_VALUE;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        playerIn.startUsingItem(handIn);
        return InteractionResultHolder.success(playerIn.getItemInHand(handIn));
    }

    @Override
    public void onUseTick(Level level, LivingEntity player, ItemStack stack, int count) {
        double yaw = Math.toRadians(player.getYRot());
        double pitch = Math.toRadians(player.getXRot());
        Vec3 front = new Vec3(-Math.sin(yaw) * Math.cos(pitch), -Math.sin(pitch), Math.cos(yaw) * Math.cos(pitch));
        player.setDeltaMovement(player.getDeltaMovement().subtract(front.scale(0.05)));

        List<Entity> entitiesAroundPlayer = level.getEntitiesOfClass(Entity.class, new AABB(player.getX() - 5, player.getY() - 5, player.getZ() - 5, player.getX() + 5, player.getY() + 5, player.getZ() + 5));
        entitiesAroundPlayer.remove(player);
        for (Entity entity : entitiesAroundPlayer) {
            Vec3 relativePos = entity.position().subtract(player.position());
            if (relativePos.dot(front) > 0.9) {
                entity.setDeltaMovement(entity.getDeltaMovement().add(relativePos.normalize().scale((Math.tanh(relativePos.length()) + 1.0) / 4)));
            }
        }
    }
}
