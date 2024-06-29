package xyz.przemyk.fansmod.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import xyz.przemyk.fansmod.Config;
import xyz.przemyk.fansmod.registry.FansModBlockEntities;

public class RedstoneFanBlockEntity extends FanBlockEntity {

    public RedstoneFanBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FansModBlockEntities.REDSTONE_FAN_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    @Override
    protected double getFanSpeed() {
        return Config.REDSTONE_FAN_SPEED.get();
    }

    @Override
    protected int getMaxRange() {
        return level.getBestNeighborSignal(worldPosition);
    }
}
