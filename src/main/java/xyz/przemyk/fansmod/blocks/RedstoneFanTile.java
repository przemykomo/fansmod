package xyz.przemyk.fansmod.blocks;

import xyz.przemyk.fansmod.Config;
import xyz.przemyk.fansmod.Registration;

public class RedstoneFanTile extends FanTile  {

    public RedstoneFanTile() {
        super(Registration.REDSTONE_FAN_TILE.get());
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
