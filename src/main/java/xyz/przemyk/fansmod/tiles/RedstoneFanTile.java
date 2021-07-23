package xyz.przemyk.fansmod.tiles;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import xyz.przemyk.fansmod.Config;
import xyz.przemyk.fansmod.registry.TileEntities;

public class RedstoneFanTile extends FanTile  {

    public RedstoneFanTile(BlockPos blockPos, BlockState blockState) {
        super(TileEntities.REDSTONE_FAN_TILE.get(), blockPos, blockState);
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
