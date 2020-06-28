package xyz.przemyk.fansmod.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.world.IBlockReader;
import xyz.przemyk.fansmod.tiles.FanTile;
import xyz.przemyk.fansmod.tiles.IronFanTile;

public class IronFanBlock extends FanBlock {
    @Override
    public FanTile createTileEntity(BlockState state, IBlockReader world) {
        return new IronFanTile();
    }
}
