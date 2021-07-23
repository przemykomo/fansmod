package xyz.przemyk.fansmod.registry;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.przemyk.fansmod.FansMod;
import xyz.przemyk.fansmod.tiles.*;

@SuppressWarnings("unused")
public class TileEntities {

    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, FansMod.MODID);

    public static void init() {
        TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }


    public static final RegistryObject<BlockEntityType<IronFanTile>> IRON_FAN_TILE = TILE_ENTITIES.register("iron_fan_tile",
            () -> BlockEntityType.Builder.of(IronFanTile::new, Blocks.IRON_FAN_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<GoldFanTile>> GOLD_FAN_TILE = TILE_ENTITIES.register("gold_fan_tile",
            () -> BlockEntityType.Builder.of(GoldFanTile::new, Blocks.GOLD_FAN_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<DiamondFanTile>> DIAMOND_FAN_TILE = TILE_ENTITIES.register("diamond_fan_tile",
            () -> BlockEntityType.Builder.of(DiamondFanTile::new, Blocks.DIAMOND_FAN_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<EmeraldFanTile>> EMERALD_FAN_TILE = TILE_ENTITIES.register("emerald_fan_tile",
            () -> BlockEntityType.Builder.of(EmeraldFanTile::new, Blocks.EMERALD_FAN_BLOCK.get()).build(null));


    public static final RegistryObject<BlockEntityType<RedstoneFanTile>> REDSTONE_FAN_TILE = TILE_ENTITIES.register("redstone_fan_tile",
            () -> BlockEntityType.Builder.of(RedstoneFanTile::new, Blocks.REDSTONE_FAN_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<ConfigurableFanTile>> CONFIGURABLE_FAN_TILE = TILE_ENTITIES.register("configurable_fan_tile",
            () -> BlockEntityType.Builder.of(ConfigurableFanTile::new, Blocks.CONFIGURABLE_FAN_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<StickyFanTile>> STICKY_FAN_TILE = TILE_ENTITIES.register("sticky_fan_tile",
            () -> BlockEntityType.Builder.of(StickyFanTile::new, Blocks.STICKY_FAN_BLOCK.get()).build(null));
}
