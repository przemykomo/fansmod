package xyz.przemyk.fansmod.blocks;

import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;

public class ConfigurableFanTile extends FanTile {

    public ConfigurableFanTile() {
        super();

        fanSpeed = 0.15;
        boxLength = 0;
        fanDirection = Direction.NORTH;
    }

    @Override
    public void tick() {
        if (world != null) {
            if (firstTick) {
                firstTick = false;

                fanDirection = getBlockState().get(BlockStateProperties.FACING);
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
