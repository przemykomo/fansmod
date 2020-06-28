package xyz.przemyk.fansmod.tiles;

import xyz.przemyk.fansmod.Config;
import xyz.przemyk.fansmod.registry.TileEntities;

public class IronFanTile extends FanTile {

    public IronFanTile() {
        super(TileEntities.IRON_FAN_TILE.get());
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
