package xyz.przemyk.fansmod.blocks;

import net.minecraft.util.Direction;
import xyz.przemyk.fansmod.Config;
import xyz.przemyk.fansmod.registry.TileEntities;

public class ConfigurableFanTile extends FanTile {

    public ConfigurableFanTile() {
        super(TileEntities.CONFIGURABLE_FAN_TILE.get());

        fanSpeed = Config.CONFIGURABLE_FAN_SPEED.get();
        maxRange = 0;
        fanDirection = Direction.NORTH;
    }

    @Override
    public void tick() {
        if (world != null) {
            if (firstTick) {
                firstTick = false;

                maxRange = world.getBlockState(pos).get(ConfigurableFanBlock.LEVEL);
                getDirection();
            }

            getRange();
            if (range > 0) {
                scan = getScan(range);
                moveEntities();
            }
        }
    }

    void update() {
        maxRange = world.getBlockState(pos).get(ConfigurableFanBlock.LEVEL);
    }
}
