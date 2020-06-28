package xyz.przemyk.fansmod.registry;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.przemyk.fansmod.FansMod;
import xyz.przemyk.fansmod.tiles.*;

@SuppressWarnings("unused")
public class TileEntities {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, FansMod.MODID);

    public static void init() {
        TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }


    public static final RegistryObject<TileEntityType<IronFanTile>> IRON_FAN_TILE = TILE_ENTITIES.register("iron_fan_tile",
            () -> TileEntityType.Builder.create(IronFanTile::new, Blocks.IRON_FAN_BLOCK.get()).build(null));

    public static final RegistryObject<TileEntityType<GoldFanTile>> GOLD_FAN_TILE = TILE_ENTITIES.register("gold_fan_tile",
            () -> TileEntityType.Builder.create(GoldFanTile::new, Blocks.GOLD_FAN_BLOCK.get()).build(null));

    public static final RegistryObject<TileEntityType<DiamondFanTile>> DIAMOND_FAN_TILE = TILE_ENTITIES.register("diamond_fan_tile",
            () -> TileEntityType.Builder.create(DiamondFanTile::new, Blocks.DIAMOND_FAN_BLOCK.get()).build(null));

    public static final RegistryObject<TileEntityType<EmeraldFanTile>> EMERALD_FAN_TILE = TILE_ENTITIES.register("emerald_fan_tile",
            () -> TileEntityType.Builder.create(EmeraldFanTile::new, Blocks.EMERALD_FAN_BLOCK.get()).build(null));


    public static final RegistryObject<TileEntityType<RedstoneFanTile>> REDSTONE_FAN_TILE = TILE_ENTITIES.register("redstone_fan_tile",
            () -> TileEntityType.Builder.create(RedstoneFanTile::new, Blocks.REDSTONE_FAN_BLOCK.get()).build(null));

    public static final RegistryObject<TileEntityType<ConfigurableFanTile>> CONFIGURABLE_FAN_TILE = TILE_ENTITIES.register("configurable_fan_tile",
            () -> TileEntityType.Builder.create(ConfigurableFanTile::new, Blocks.CONFIGURABLE_FAN_BLOCK.get()).build(null));

    public static final RegistryObject<TileEntityType<StickyFanTile>> STICKY_FAN_TILE = TILE_ENTITIES.register("sticky_fan_tile",
            () -> TileEntityType.Builder.create(StickyFanTile::new, Blocks.STICKY_FAN_BLOCK.get()).build(null));
}
