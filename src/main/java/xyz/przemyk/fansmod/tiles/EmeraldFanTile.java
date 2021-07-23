package xyz.przemyk.fansmod.tiles;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import xyz.przemyk.fansmod.Config;
import xyz.przemyk.fansmod.registry.TileEntities;

public class EmeraldFanTile extends FanTile {

    public EmeraldFanTile(BlockPos blockPos, BlockState blockState) {
        super(TileEntities.EMERALD_FAN_TILE.get(), blockPos, blockState);
    }

    @Override
    protected double getFanSpeed() {
        return Config.EMERALD_FAN_SPEED.get();
    }

    @Override
    protected int getMaxRange() {
        return Config.EMERALD_FAN_RANGE.get();
    }
}
