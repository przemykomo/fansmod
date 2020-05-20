package xyz.przemyk.fansmod.blocks;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.List;

public class FanTile extends TileEntity implements ITickableTileEntity {

    public FanTile() {
        this(0, 0);
    }

    public FanTile(double fan_speed, double boxLength) {
        super(ModBlocks.FAN_TILE);

        this.fanSpeed = fan_speed;
        this.boxLength = boxLength;
    }

    private double fanSpeed;
    private double boxLength;

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
//        switch (getBlockState().getBlock().getRegistryName().getPath()) {
//            case "iron_fan":
//                fanSpeed = 0.05;
//                boxLength = 5;
//                break;
//            case "gold_fan":
//                fanSpeed = 0.1;
//                boxLength = 5;
//                break;
//            case "diamond_fan":
//                fanSpeed = 0.15;
//                boxLength = 7;
//                break;
//            case "emerald_fan":
//                fanSpeed = 0.2;
//                boxLength = 7;
//                break;
//            case "redstone_fan":
//                fanSpeed = 0.13;
//                boxLength = 6;
//                break;
//        }
    }

    private Direction fanDirection;

    @Override
    public void tick() {
        if (world != null) {
            fanDirection = getBlockState().get(BlockStateProperties.FACING);
            AxisAlignedBB scan = new AxisAlignedBB(pos, pos.offset(fanDirection, (int) boxLength).add(1.0, 1.0, 1.0));
            List<Entity> entityList = world.getEntitiesWithinAABB(Entity.class, scan);

            for (Entity entity : entityList) {
                addMotion(entity);
                entity.fallDistance = 0;
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
