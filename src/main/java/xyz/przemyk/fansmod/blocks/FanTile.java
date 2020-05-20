package xyz.przemyk.fansmod.blocks;

import net.minecraft.entity.Entity;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import xyz.przemyk.fansmod.FansMod;

import java.util.List;

public class FanTile extends TileEntity implements ITickableTileEntity {

    public FanTile() {
        super(ModBlocks.FAN_TILE);
    }

    private boolean firstTick = true;

    private double fanSpeed;
    private double boxLength;

    private Direction fanDirection;
    private AxisAlignedBB scan;

    @Override
    public void tick() {
        if (world != null) {

            // Cannot override onLoad because this code needs to get block state
            if (firstTick) {
                firstTick = false;

                switch (getBlockState().getBlock().getRegistryName().toString()) {
                    case FansMod.MODID + ":iron_fan":
                        fanSpeed = 0.08;
                        boxLength = 8;
                        break;
                    case FansMod.MODID + ":gold_fan":
                        fanSpeed = 0.1;
                        boxLength = 10;
                        break;
                    case FansMod.MODID + ":diamond_fan":
                        fanSpeed = 0.15;
                        boxLength = 12;
                        break;
                    case FansMod.MODID + ":emerald_fan":
                        fanSpeed = 0.2;
                        boxLength = 16;
                        break;
                    case FansMod.MODID + ":redstone_fan":
                        fanSpeed = 0.13;
                        boxLength = 10;
                        break;
                }

                fanDirection = getBlockState().get(BlockStateProperties.FACING);
                scan = new AxisAlignedBB(pos, pos.offset(fanDirection, (int) boxLength).add(1.0, 1.0, 1.0));
            }

            List<Entity> entityList = world.getEntitiesWithinAABB(Entity.class, scan);

            for (Entity entity : entityList) {
                addMotion(entity);
                if (fanDirection == Direction.UP) {
                    entity.fallDistance = 0;
                }
            }
        }
    }

    private void addMotion(Entity entity) {
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
