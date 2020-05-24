package xyz.przemyk.fansmod.blocks;

public class RedstoneFanTile extends FanTile  {

    public RedstoneFanTile() {
        super();
        fanSpeed = 0.13;
        boxLength = 10;
    }

    @Override
    public void tick() {
        if (world != null) {
            if (firstTick) {
                firstTick = false;

                getDirectionAndScan();
            }

            if (world.isBlockPowered(pos)) {
                moveEntities();
            }
        }
    }
}
