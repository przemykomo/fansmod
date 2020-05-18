package xyz.przemyk.fansmod.blocks;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class FanTile extends TileEntity implements ITickableTileEntity {

    public FanTile() {
        super(ModBlocks.FAN_TILE);
    }

    @Override
    public void tick() {
//        System.out.println("tick");
    }
}
