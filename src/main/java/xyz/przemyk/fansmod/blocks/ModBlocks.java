package xyz.przemyk.fansmod.blocks;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;
import xyz.przemyk.fansmod.FansMod;

public class ModBlocks {

    @ObjectHolder(FansMod.MODID + ":fan")
    public static FanBlock FAN_BLOCK;

    @ObjectHolder(FansMod.MODID + ":fan")
    public static TileEntityType<FanTile> FAN_TILE;
}
