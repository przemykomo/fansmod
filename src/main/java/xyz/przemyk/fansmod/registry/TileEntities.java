package xyz.przemyk.fansmod.registry;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.przemyk.fansmod.FansMod;
import xyz.przemyk.fansmod.blocks.ConfigurableFanTile;
import xyz.przemyk.fansmod.blocks.FanTile;
import xyz.przemyk.fansmod.blocks.RedstoneFanTile;
import xyz.przemyk.fansmod.blocks.StickyFanTile;

@SuppressWarnings("unused")
public class TileEntities {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, FansMod.MODID);

    public static void init() {
        TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<TileEntityType<FanTile>> FAN_TILE = TILE_ENTITIES.register("fan_tile",
            () -> TileEntityType.Builder.create(FanTile::new,
                    Blocks.IRON_FAN_BLOCK.get(), Blocks.GOLD_FAN_BLOCK.get(),
                    Blocks.DIAMOND_FAN_BLOCK.get(), Blocks.EMERALD_FAN_BLOCK.get())
                    .build(null));

    public static final RegistryObject<TileEntityType<RedstoneFanTile>> REDSTONE_FAN_TILE = TILE_ENTITIES.register("redstone_fan_tile",
            () -> TileEntityType.Builder.create(RedstoneFanTile::new, Blocks.REDSTONE_FAN_BLOCK.get()).build(null));

    public static final RegistryObject<TileEntityType<ConfigurableFanTile>> CONFIGURABLE_FAN_TILE = TILE_ENTITIES.register("configurable_fan_tile",
            () -> TileEntityType.Builder.create(ConfigurableFanTile::new, Blocks.CONFIGURABLE_FAN_BLOCK.get()).build(null));

    public static final RegistryObject<TileEntityType<StickyFanTile>> STICKY_FAN_TILE = TILE_ENTITIES.register("sticky_fan_tile",
            () -> TileEntityType.Builder.create(StickyFanTile::new, Blocks.STICKY_FAN_BLOCK.get()).build(null));
}
