package xyz.przemyk.fansmod.blocks;

import xyz.przemyk.fansmod.Config;

public class RedstoneFanTile extends FanTile  {

    public RedstoneFanTile() {
        super(ModBlocks.REDSTONE_FAN_TILE);
        fanSpeed = Config.REDSTONE_FAN_SPEED.get();
        range = 0;
    }

    @Override
    public void tick() {
        if (world != null) {
            if (firstTick) {
                firstTick = false;

                getDirection();
            }

            range =  world.getRedstonePowerFromNeighbors(pos);
            scan = getScan(range);
            if (range > 0) {
                moveEntities();
            }
        }
    }

}
