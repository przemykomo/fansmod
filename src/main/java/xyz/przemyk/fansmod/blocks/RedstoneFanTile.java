package xyz.przemyk.fansmod.blocks;

import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.AxisAlignedBB;

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

                fanDirection = getBlockState().get(BlockStateProperties.FACING);
                scan = new AxisAlignedBB(pos, pos.offset(fanDirection, boxLength).add(1.0, 1.0, 1.0));
            }

            if (world.isBlockPowered(pos)) {
                moveEntities();
            }
        }
    }
}
