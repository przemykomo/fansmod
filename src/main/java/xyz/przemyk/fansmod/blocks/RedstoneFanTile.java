package xyz.przemyk.fansmod.blocks;

public class RedstoneFanTile extends FanTile  {

    public RedstoneFanTile() {
        super();
    }

    @Override
    public void tick() {
        if (world.isBlockPowered(pos)) {
            super.tick();
        }
    }
}
