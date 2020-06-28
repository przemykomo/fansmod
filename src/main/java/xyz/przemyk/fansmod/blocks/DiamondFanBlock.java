package xyz.przemyk.fansmod.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.world.IBlockReader;
import xyz.przemyk.fansmod.tiles.DiamondFanTile;
import xyz.przemyk.fansmod.tiles.FanTile;

public class DiamondFanBlock extends FanBlock {
    @Override
    public FanTile createTileEntity(BlockState state, IBlockReader world) {
        return new DiamondFanTile();
    }
}
