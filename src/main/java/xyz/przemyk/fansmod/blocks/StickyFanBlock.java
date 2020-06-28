package xyz.przemyk.fansmod.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import xyz.przemyk.fansmod.tiles.StickyFanTile;

import javax.annotation.Nullable;

public class StickyFanBlock extends FanBlock {
    @Override
    public StickyFanTile createTileEntity(BlockState state, IBlockReader world) {
        return new StickyFanTile();
    }
}
