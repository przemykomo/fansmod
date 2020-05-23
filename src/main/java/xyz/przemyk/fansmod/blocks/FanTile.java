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
    protected int boxLength;

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
                        boxLength = Config.IRON_FAN_RANGE.get();
                        break;
                    case FansMod.MODID + ":gold_fan":
                        fanSpeed = Config.GOLD_FAN_SPEED.get();
                        boxLength = Config.GOLD_FAN_RANGE.get();
                        break;
                    case FansMod.MODID + ":diamond_fan":
                        fanSpeed = Config.DIAMOND_FAN_SPEED.get();
                        boxLength = Config.DIAMOND_FAN_RANGE.get();
                        break;
                    case FansMod.MODID + ":emerald_fan":
                        fanSpeed = Config.EMERALD_FAN_SPEED.get();
                        boxLength = Config.EMERALD_FAN_RANGE.get();
                        break;
                }

                fanDirection = getBlockState().get(BlockStateProperties.FACING);
                scan = new AxisAlignedBB(pos, pos.offset(fanDirection, boxLength).add(1.0, 1.0, 1.0));
            }

            moveEntities();
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
