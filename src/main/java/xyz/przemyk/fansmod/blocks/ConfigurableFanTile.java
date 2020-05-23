package xyz.przemyk.fansmod.blocks;

import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
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

                fanDirection = getBlockState().get(BlockStateProperties.FACING);
                boxLength = world.getBlockState(pos).get(ConfigurableFanBlock.LEVEL);
                scan = new AxisAlignedBB(pos, pos.offset(fanDirection, boxLength).add(1.0, 1.0, 1.0));
            }

            moveEntities();
        }
    }

    void update() {
        boxLength = world.getBlockState(pos).get(ConfigurableFanBlock.LEVEL);

        scan = new AxisAlignedBB(pos, pos.offset(fanDirection, boxLength).add(1.0, 1.0, 1.0));
    }
}
