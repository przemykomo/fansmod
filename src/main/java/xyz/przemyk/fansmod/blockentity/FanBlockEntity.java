package xyz.przemyk.fansmod.blockentity;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import xyz.przemyk.fansmod.registry.FansModItems;

import java.util.List;

public abstract class FanBlockEntity extends BlockEntity {

    protected FanBlockEntity(BlockEntityType<? extends FanBlockEntity> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    protected boolean firstTick = true;

    protected int range;

    protected Direction fanDirection;
    protected AABB scan;

    protected abstract double getFanSpeed();
    protected abstract int getMaxRange();

    public static void tick(FanBlockEntity fanBlockEntity) {
        if (fanBlockEntity.level != null) {

            // Cannot override onLoad because this code needs to get block state
            if (fanBlockEntity.firstTick) {
                fanBlockEntity.firstTick = false;
                fanBlockEntity.firstTick();
            }

            fanBlockEntity.getRange();
            if (fanBlockEntity.range > 0) {
                fanBlockEntity.scan = fanBlockEntity.getScan(fanBlockEntity.range);
                fanBlockEntity.moveEntities();
            }
        }
    }

    protected void firstTick() {
        getDirection();
    }

    protected void getRange() {
        for (int i = 1; i <= getMaxRange(); ++i) {
            BlockPos scanPos = worldPosition.relative(fanDirection, i);
            BlockState blockState =  level.getBlockState(scanPos);
            if (blockState.isFaceSturdy(level, scanPos, fanDirection.getOpposite())
            ||  blockState.isFaceSturdy(level, scanPos, fanDirection)) {
                range = i - 1;
                return;
            }
        }
        range = getMaxRange();
    }

    protected void getDirection() {
        fanDirection = getBlockState().getValue(BlockStateProperties.FACING);
    }

    protected AABB getScan(int boxLength) {
        return switch (fanDirection) {
            case DOWN, NORTH, WEST -> AABB.encapsulatingFullBlocks(worldPosition, worldPosition.relative(fanDirection, boxLength + 1));
            default -> AABB.encapsulatingFullBlocks(worldPosition, worldPosition.relative(fanDirection, boxLength));
        };
    }

    protected void moveEntities() {
        List<Entity> entityList = level.getEntitiesOfClass(Entity.class, scan);

        for (Entity entity : entityList) {
//            if (!(entity instanceof Player && ((Player) entity).abilities.flying)) {
                addMotion(entity);
//            }
            if (fanDirection == Direction.UP) {
                entity.fallDistance = 0;
            }
        }
    }

    protected void addMotion(Entity entity) {
        if (entity instanceof Player &&
                ((Player) entity).getItemBySlot(EquipmentSlot.FEET).getItem() == FansModItems.STICKY_BOOTS_ITEM.get()
                && entity.onGround()) {
            return;
        }

        Vec3 motion = entity.getDeltaMovement();
        switch (fanDirection) {
            case DOWN -> entity.setDeltaMovement(motion.x, motion.y - getFanSpeed(), motion.z);
            case UP -> entity.setDeltaMovement(motion.x, motion.y + getFanSpeed(), motion.z);
            case NORTH -> entity.setDeltaMovement(motion.x, motion.y, motion.z - getFanSpeed());
            case SOUTH -> entity.setDeltaMovement(motion.x, motion.y, motion.z + getFanSpeed());
            case WEST -> entity.setDeltaMovement(motion.x - getFanSpeed(), motion.y, motion.z);
            case EAST -> entity.setDeltaMovement(motion.x + getFanSpeed(), motion.y, motion.z);
        }
    }
}
