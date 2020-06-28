package xyz.przemyk.fansmod.tiles;

import xyz.przemyk.fansmod.Config;
import xyz.przemyk.fansmod.registry.TileEntities;

public class GoldFanTile extends FanTile {

    public GoldFanTile() {
        super(TileEntities.GOLD_FAN_TILE.get());
    }

    @Override
    protected double getFanSpeed() {
        return Config.GOLD_FAN_SPEED.get();
    }

    @Override
    protected int getMaxRange() {
        return Config.GOLD_FAN_RANGE.get();
    }
}
