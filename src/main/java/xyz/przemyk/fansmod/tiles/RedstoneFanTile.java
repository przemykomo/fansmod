package xyz.przemyk.fansmod.tiles;

import xyz.przemyk.fansmod.Config;
import xyz.przemyk.fansmod.registry.TileEntities;

public class RedstoneFanTile extends FanTile  {

    public RedstoneFanTile() {
        super(TileEntities.REDSTONE_FAN_TILE.get());
    }

    @Override
    protected double getFanSpeed() {
        return Config.REDSTONE_FAN_SPEED.get();
    }

    @Override
    protected int getMaxRange() {
        return world.getRedstonePowerFromNeighbors(pos);
    }

}
