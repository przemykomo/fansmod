package xyz.przemyk.fansmod.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.world.IBlockReader;
import xyz.przemyk.fansmod.tiles.FanTile;
import xyz.przemyk.fansmod.tiles.GoldFanTile;

public class GoldFanBlock extends FanBlock {
    @Override
    public FanTile createTileEntity(BlockState state, IBlockReader world) {
        return new GoldFanTile();
    }
}
