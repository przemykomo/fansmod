package xyz.przemyk.fansmod.blocks;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;
import xyz.przemyk.fansmod.FansMod;

public class ModBlocks {

    @ObjectHolder(FansMod.MODID + ":iron_fan")
    public static final FanBlock IRON_FAN_BLOCK = null;

    @ObjectHolder(FansMod.MODID + ":gold_fan")
    public static final FanBlock GOLD_FAN_BLOCK = null;

    @ObjectHolder(FansMod.MODID + ":fan_tile")
    public static final TileEntityType<FanTile> FAN_TILE = null;
}
