package xyz.przemyk.fansmod.blocks;

import net.minecraft.util.Direction;
import xyz.przemyk.fansmod.Config;

public class ConfigurableFanTile extends FanTile {

    public ConfigurableFanTile() {
        super(ModBlocks.CONFIGURABLE_FAN_TILE);

        fanSpeed = Config.CONFIGURABLE_FAN_SPEED.get();
        boxLength = 0;
        fanDirection = Direction.NORTH;
    }

    @Override
    public void tick() {
        if (world != null) {
            if (firstTick) {
                firstTick = false;

                boxLength = world.getBlockState(pos).get(ConfigurableFanBlock.LEVEL);
                getDirection();
                getScan();
            }

            moveEntities();
        }
    }

    void update() {
        boxLength = world.getBlockState(pos).get(ConfigurableFanBlock.LEVEL);

        getScan();
    }
}
