package xyz.przemyk.fansmod.blocks;

import xyz.przemyk.fansmod.Config;
import xyz.przemyk.fansmod.registry.Blocks;
import xyz.przemyk.fansmod.registry.TileEntities;

public class RedstoneFanTile extends FanTile  {

    public RedstoneFanTile() {
        super(TileEntities.REDSTONE_FAN_TILE.get());
        fanSpeed = Config.REDSTONE_FAN_SPEED.get();
        maxRange = 0;
    }

    @Override
    public void tick() {
        if (world != null) {
            if (firstTick) {
                firstTick = false;

                getDirection();
            }

            maxRange =  world.getRedstonePowerFromNeighbors(pos);
            if (maxRange > 0) {
                getRange();
                if (range > 0) {
                    scan = getScan(range);
                    moveEntities();
                }
            }
        }
    }

}
