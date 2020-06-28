package xyz.przemyk.fansmod.tiles;

import xyz.przemyk.fansmod.Config;
import xyz.przemyk.fansmod.registry.TileEntities;

public class DiamondFanTile extends FanTile {

    public DiamondFanTile() {
        super(TileEntities.DIAMOND_FAN_TILE.get());
    }

    @Override
    protected double getFanSpeed() {
        return Config.DIAMOND_FAN_SPEED.get();
    }

    @Override
    protected int getMaxRange() {
        return Config.DIAMOND_FAN_RANGE.get();
    }
}
