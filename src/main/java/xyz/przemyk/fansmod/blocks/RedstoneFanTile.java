package xyz.przemyk.fansmod.blocks;

public class RedstoneFanTile extends FanTile  {

    public RedstoneFanTile() {
        super(ModBlocks.REDSTONE_FAN_TILE);
        fanSpeed = 0.13;
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
