package xyz.przemyk.fansmod.blocks;

import net.minecraft.util.Direction;
import xyz.przemyk.fansmod.Config;
import xyz.przemyk.fansmod.Registration;

public class ConfigurableFanTile extends FanTile {

    public ConfigurableFanTile() {
        super(Registration.CONFIGURABLE_FAN_TILE.get());

        fanSpeed = Config.CONFIGURABLE_FAN_SPEED.get();
        range = 0;
        fanDirection = Direction.NORTH;
    }

    @Override
    public void tick() {
        if (world != null) {
            if (firstTick) {
                firstTick = false;

                range = world.getBlockState(pos).get(ConfigurableFanBlock.LEVEL);
                getDirection();
                scan= getScan(range);
            }

            moveEntities();
        }
    }

    void update() {
        range = world.getBlockState(pos).get(ConfigurableFanBlock.LEVEL);

        scan = getScan(range);
    }
}
