package xyz.przemyk.fansmod.blocks;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import xyz.przemyk.fansmod.Config;
import xyz.przemyk.fansmod.FansMod;

import java.util.List;

public class FanTile extends TileEntity implements ITickableTileEntity {

    public FanTile() {
        super(ModBlocks.FAN_TILE);
    }

    protected FanTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    protected boolean firstTick = true;

    protected double fanSpeed;
    protected int range;

    protected Direction fanDirection;
    protected AxisAlignedBB scan;

    @Override
    public void tick() {
        if (world != null) {

            // Cannot override onLoad because this code needs to get block state
            if (firstTick) {
                firstTick = false;

                switch (getBlockState().getBlock().getRegistryName().toString()) {
                    case FansMod.MODID + ":iron_fan":
                        fanSpeed = Config.IRON_FAN_SPEED.get();
                        range = Config.IRON_FAN_RANGE.get();
                        break;
                    case FansMod.MODID + ":gold_fan":
                        fanSpeed = Config.GOLD_FAN_SPEED.get();
                        range = Config.GOLD_FAN_RANGE.get();
                        break;
                    case FansMod.MODID + ":diamond_fan":
                        fanSpeed = Config.DIAMOND_FAN_SPEED.get();
                        range = Config.DIAMOND_FAN_RANGE.get();
                        break;
                    case FansMod.MODID + ":emerald_fan":
                        fanSpeed = Config.EMERALD_FAN_SPEED.get();
                        range = Config.EMERALD_FAN_RANGE.get();
                        break;
                }

                getDirection();
                scan = getScan(range);
            }

            moveEntities();
        }
    }

    protected void getDirection() {
        fanDirection = getBlockState().get(BlockStateProperties.FACING);
    }

    protected AxisAlignedBB getScan(int boxLength) {
        switch (fanDirection) {
            case DOWN:
            case NORTH:
            case WEST:
                return new AxisAlignedBB(pos, pos.offset(fanDirection, boxLength + 1).add(1.0, 1.0, 1.0));
            default:
                return new AxisAlignedBB(pos, pos.offset(fanDirection, boxLength).add(1.0, 1.0, 1.0));
        }
    }

    protected void moveEntities() {
        List<Entity> entityList = world.getEntitiesWithinAABB(Entity.class, scan);

        for (Entity entity : entityList) {
            if (!( entity instanceof PlayerEntity && ((PlayerEntity) entity).abilities.isFlying)) {
                addMotion(entity);
            }
            if (fanDirection == Direction.UP) {
                entity.fallDistance = 0;
            }
        }
    }

    protected void addMotion(Entity entity) {
        switch (fanDirection) {
            case DOWN:
                entity.setMotion(entity.getMotion().x, entity.getMotion().y - fanSpeed, entity.getMotion().z);
                break;
            case UP:
                entity.setMotion(entity.getMotion().x, entity.getMotion().y + fanSpeed, entity.getMotion().z);
                break;
            case NORTH:
                entity.setMotion(entity.getMotion().x, entity.getMotion().y, entity.getMotion().z - fanSpeed);
                break;
            case SOUTH:
                entity.setMotion(entity.getMotion().x, entity.getMotion().y, entity.getMotion().z + fanSpeed);
                break;
            case WEST:
                entity.setMotion(entity.getMotion().x - fanSpeed, entity.getMotion().y, entity.getMotion().z);
                break;
            case EAST:
                entity.setMotion(entity.getMotion().x + fanSpeed, entity.getMotion().y, entity.getMotion().z);
                break;
        }
    }
}
