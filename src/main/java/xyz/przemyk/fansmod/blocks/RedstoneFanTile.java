package xyz.przemyk.fansmod.blocks;

import xyz.przemyk.fansmod.Config;

public class RedstoneFanTile extends FanTile  {

    public RedstoneFanTile() {
        super(ModBlocks.REDSTONE_FAN_TILE);
        fanSpeed = Config.REDSTONE_FAN_SPEED.get();
        boxLength = 0;
    }

    @Override
    public void tick() {
        if (world != null) {
            if (firstTick) {
                firstTick = false;

                getDirection();
            }

            boxLength =  world.getRedstonePowerFromNeighbors(pos);
            getScan();
            if (boxLength > 0) {
                moveEntities();
            }
        }
    }

}
