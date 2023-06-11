package xyz.przemyk.fansmod.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import xyz.przemyk.fansmod.Config;
import xyz.przemyk.fansmod.registry.FansModBlockEntities;

import java.util.List;

public class StickyFanBlockEntity extends FanBlockEntity {

    protected AABB stickyScan;

    public StickyFanBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FansModBlockEntities.STICKY_FAN_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    @Override
    protected int getMaxRange() {
        return Config.GOLD_FAN_RANGE.get();
    }

    @Override
    protected double getFanSpeed() {
        return Config.GOLD_FAN_SPEED.get();
    }

    @Override
    protected void firstTick() {
        super.firstTick();
        stickyScan = getScanDouble(Config.STICKY_RANGE.get());
    }

    @SuppressWarnings("ConstantConditions")
    protected void moveEntities() {
        List<Entity> entityList = level.getEntitiesOfClass(Entity.class, scan);
        List<Entity> stickyEntityList = level.getEntitiesOfClass(Entity.class, stickyScan);

        for (Entity entity : entityList) {
            if (/*(entity instanceof Player && ((Player) entity).abilities.flying)
                || */stickyEntityList.contains(entity)) {
                continue;
            }

            addMotion(entity);

            if (fanDirection == Direction.UP) {
                entity.fallDistance = 0;
            }
        }
    }

    @SuppressWarnings("SameParameterValue")
    protected AABB getScanDouble(double boxLength) {
        switch (fanDirection) {
            case DOWN, NORTH, WEST -> {
                Vec3 max = offsetVec3d(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(),
                        fanDirection, boxLength + 1.0).add(1.0, 1.0, 1.0);
                return new AABB(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), max.x, max.y, max.z);
            }
            default -> {
                Vec3 max2 = offsetVec3d(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(),
                        fanDirection, boxLength).add(1.0, 1.0, 1.0);
                return new AABB(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), max2.x, max2.y, max2.z);
            }
        }
    }

    public static Vec3 offsetVec3d(double x, double y, double z, Direction facing, double n) {
        return n == 0 ? new Vec3(x, y, z) : new Vec3(x + facing.getStepX() * n, y + facing.getStepY() * n, z + facing.getStepZ() * n);
    }
}
