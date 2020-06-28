package xyz.przemyk.fansmod.blocks;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import xyz.przemyk.fansmod.Config;
import xyz.przemyk.fansmod.registry.TileEntities;

import java.util.List;

public class StickyFanTile extends FanTile {

    //TODO: move stickyRange to config
    @SuppressWarnings("FieldCanBeLocal")
    private final double stickyRange = 0.1;
    protected AxisAlignedBB stickyScan;

    public StickyFanTile() {
        super(TileEntities.STICKY_FAN_TILE.get());
        fanSpeed = Config.GOLD_FAN_SPEED.get();
        maxRange = Config.GOLD_FAN_RANGE.get();
    }

    @Override
    public void tick() {
        if (world != null) {
            if (firstTick) {
                firstTick = false;

                getDirection();
                stickyScan = getScanDouble(stickyRange);
            }

            getRange();
            if (range > 0) {
                scan = getScan(range);
                moveEntities();
            }
        }
    }

    protected void moveEntities() {
        List<Entity> entityList = world.getEntitiesWithinAABB(Entity.class, scan);
        List<Entity> stickyEntityList = world.getEntitiesWithinAABB(Entity.class, stickyScan);

        for (Entity entity : entityList) {
            if ((entity instanceof PlayerEntity && ((PlayerEntity) entity).abilities.isFlying)
                || stickyEntityList.contains(entity)) {
                continue;
            }

            addMotion(entity);

            if (fanDirection == Direction.UP) {
                entity.fallDistance = 0;
            }
        }
    }

    @SuppressWarnings("SameParameterValue")
    protected AxisAlignedBB getScanDouble(double boxLength) {
        switch (fanDirection) {
            case DOWN:
            case NORTH:
            case WEST:
                Vector3d max = offsetVec3d(pos.getX(), pos.getY(), pos.getZ(),
                        fanDirection, boxLength + 1.0).add(1.0, 1.0, 1.0);
                return new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), max.x, max.y, max.z);
            default:
                Vector3d max2 = offsetVec3d(pos.getX(), pos.getY(), pos.getZ(),
                        fanDirection, boxLength).add(1.0, 1.0, 1.0);
                return new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), max2.x, max2.y, max2.z);
        }
    }

    public static Vector3d offsetVec3d(double x, double y, double z, Direction facing, double n) {
        return n == 0 ? new Vector3d(x, y, z) : new Vector3d(x + facing.getXOffset() * n, y + facing.getYOffset() * n, z + facing.getZOffset() * n);
    }
}
