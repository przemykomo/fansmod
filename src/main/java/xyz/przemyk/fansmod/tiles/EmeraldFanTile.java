package xyz.przemyk.fansmod.tiles;

import xyz.przemyk.fansmod.Config;
import xyz.przemyk.fansmod.registry.TileEntities;

public class EmeraldFanTile extends FanTile {

    public EmeraldFanTile() {
        super(TileEntities.EMERALD_FAN_TILE.get());
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
