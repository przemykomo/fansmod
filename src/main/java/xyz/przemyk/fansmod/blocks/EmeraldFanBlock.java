package xyz.przemyk.fansmod.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.world.IBlockReader;
import xyz.przemyk.fansmod.tiles.EmeraldFanTile;
import xyz.przemyk.fansmod.tiles.FanTile;

public class EmeraldFanBlock extends FanBlock {
    @Override
    public FanTile createTileEntity(BlockState state, IBlockReader world) {
        return new EmeraldFanTile();
    }
}
