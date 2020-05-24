package xyz.przemyk.fansmod.blocks;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;
import xyz.przemyk.fansmod.FansMod;

public class ModBlocks {

    //TILE ENTITIES
    @ObjectHolder(FansMod.MODID + ":fan_tile")
    public static final TileEntityType<FanTile> FAN_TILE = null;

    @ObjectHolder(FansMod.MODID + ":configurable_fan_tile")
    public static final TileEntityType<ConfigurableFanTile> CONFIGURABLE_FAN_TILE = null;

    @ObjectHolder(FansMod.MODID + ":redstone_fan_tile")
    public static final TileEntityType<RedstoneFanTile> REDSTONE_FAN_TILE = null;

    @ObjectHolder(FansMod.MODID + ":sticky_fan_tile")
    public static final TileEntityType<StickyFanTile> STICKY_FAN_TILE = null;

    //BLOCKS
    @ObjectHolder(FansMod.MODID + ":iron_fan")
    public static final FanBlock IRON_FAN_BLOCK = null;

    @ObjectHolder(FansMod.MODID + ":gold_fan")
    public static final FanBlock GOLD_FAN_BLOCK = null;

    @ObjectHolder(FansMod.MODID + ":diamond_fan")
    public static final FanBlock DIAMOND_FAN_BLOCK = null;

    @ObjectHolder(FansMod.MODID + ":emerald_fan")
    public static final FanBlock EMERALD_FAN_BLOCK = null;

    @ObjectHolder(FansMod.MODID + ":redstone_fan")
    public static final RedstoneFanBlock REDSTONE_FAN_BLOCK = null;

    @ObjectHolder(FansMod.MODID + ":configurable_fan")
    public static final ConfigurableFanBlock CONFIGURABLE_FAN_BLOCK = null;

    @ObjectHolder(FansMod.MODID + ":sticky_fan")
    public static final StickyFanBlock STICKY_FAN_BLOCK = null;
}
