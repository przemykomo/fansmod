package xyz.przemyk.fansmod.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import xyz.przemyk.fansmod.Config;
import xyz.przemyk.fansmod.FansMod;
import xyz.przemyk.fansmod.registry.Blocks;
import xyz.przemyk.fansmod.registry.Items;
import xyz.przemyk.fansmod.registry.TileEntities;

import java.util.List;

public class FanTile extends TileEntity implements ITickableTileEntity {

    public FanTile() {
        super(TileEntities.FAN_TILE.get());
    }

    protected FanTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    protected boolean firstTick = true;

    protected double fanSpeed;
    protected int maxRange;
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
                        maxRange = Config.IRON_FAN_RANGE.get();
                        break;
                    case FansMod.MODID + ":gold_fan":
                        fanSpeed = Config.GOLD_FAN_SPEED.get();
                        maxRange = Config.GOLD_FAN_RANGE.get();
                        break;
                    case FansMod.MODID + ":diamond_fan":
                        fanSpeed = Config.DIAMOND_FAN_SPEED.get();
                        maxRange = Config.DIAMOND_FAN_RANGE.get();
                        break;
                    case FansMod.MODID + ":emerald_fan":
                        fanSpeed = Config.EMERALD_FAN_SPEED.get();
                        maxRange = Config.EMERALD_FAN_RANGE.get();
                        break;
                }

                getDirection();
            }

            getRange();
            if (range > 0) {
                scan = getScan(range);
                moveEntities();
            }
        }
    }

    protected void getRange() {
        for (int i = 1; i <= maxRange; ++i) {
            BlockPos scanPos = pos.offset(fanDirection, i);
            BlockState blockState =  world.getBlockState(scanPos);
            if (blockState.isSolidSide(world, scanPos, fanDirection.getOpposite())
            ||  blockState.isSolidSide(world, scanPos, fanDirection)) {
                range = i - 1;
                return;
            }
        }
        range = maxRange;
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
        if (entity instanceof PlayerEntity &&
                ((PlayerEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET).getItem()
                                                        == Items.STICKY_BOOTS_ITEM.get() &&
                entity.onGround) {
            return;
        }
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
