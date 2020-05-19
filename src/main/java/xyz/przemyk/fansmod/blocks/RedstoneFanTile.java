package xyz.przemyk.fansmod.blocks;

public class RedstoneFanTile extends FanTile  {

    public RedstoneFanTile(double fan_speed, double boxLength) {
        super(fan_speed, boxLength);
    }

    @Override
    public void tick() {
        if (world.isBlockPowered(pos)) {
            super.tick();
        }
    }
}
