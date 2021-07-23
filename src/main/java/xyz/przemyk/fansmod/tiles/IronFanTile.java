package xyz.przemyk.fansmod.tiles;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import xyz.przemyk.fansmod.Config;
import xyz.przemyk.fansmod.registry.TileEntities;

public class IronFanTile extends FanTile {

    public IronFanTile(BlockPos blockPos, BlockState blockState) {
        super(TileEntities.IRON_FAN_TILE.get(), blockPos, blockState);
    }

    @Override
    protected double getFanSpeed() {
        return Config.IRON_FAN_SPEED.get();
    }

    @Override
    protected int getMaxRange() {
        return Config.IRON_FAN_RANGE.get();
    }
}
