package xyz.przemyk.fansmod.tiles;

import xyz.przemyk.fansmod.Config;
import xyz.przemyk.fansmod.blocks.ConfigurableFanBlock;
import xyz.przemyk.fansmod.registry.TileEntities;

public class ConfigurableFanTile extends FanTile {

    public ConfigurableFanTile() {
        super(TileEntities.CONFIGURABLE_FAN_TILE.get());
    }

    @Override
    protected double getFanSpeed() {
        return Config.CONFIGURABLE_FAN_SPEED.get();
    }

    @Override
    protected int getMaxRange() {
        return world.getBlockState(pos).get(ConfigurableFanBlock.LEVEL);
    }

}
