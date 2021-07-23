package xyz.przemyk.fansmod.tiles;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import xyz.przemyk.fansmod.Config;
import xyz.przemyk.fansmod.blocks.ConfigurableFanBlock;
import xyz.przemyk.fansmod.registry.TileEntities;

public class ConfigurableFanTile extends FanTile {

    public ConfigurableFanTile(BlockPos blockPos, BlockState blockState) {
        super(TileEntities.CONFIGURABLE_FAN_TILE.get(), blockPos, blockState);
    }

    @Override
    protected double getFanSpeed() {
        return Config.CONFIGURABLE_FAN_SPEED.get();
    }

    @Override
    protected int getMaxRange() {
        return level.getBlockState(worldPosition).getValue(ConfigurableFanBlock.LEVEL);
    }
}
