package xyz.przemyk.fansmod;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;
import xyz.przemyk.fansmod.blocks.*;

@Mod(FansMod.MODID)
public class FansMod {
    public static final String MODID = "fansmod";

    public FansMod() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);


        Config.loadConfig(Config.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("fansmod-common.toml"));
        ConfigurableFanBlock.LEVEL = IntegerProperty.create("level", 0, Config.CONFIGURABLE_FAN_MAX_RANGE.get());
    }

    public static final ItemGroup FANS_ITEM_GROUP = new ItemGroup(ItemGroup.GROUPS.length, "fansmod") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.IRON_FAN_BLOCK);
        }
    };

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlockRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            blockRegistryEvent.getRegistry().registerAll(new FanBlock().setRegistryName("iron_fan"),
                    new FanBlock().setRegistryName("gold_fan"),
                    new FanBlock().setRegistryName("diamond_fan"),
                    new FanBlock().setRegistryName("emerald_fan"),
                    new RedstoneFanBlock().setRegistryName("redstone_fan"),
                    new ConfigurableFanBlock().setRegistryName("configurable_fan"));
        }

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
            itemRegistryEvent.getRegistry().registerAll(new BlockItem(ModBlocks.IRON_FAN_BLOCK, new Item.Properties().group(FANS_ITEM_GROUP)).setRegistryName("iron_fan"),
            new BlockItem(ModBlocks.GOLD_FAN_BLOCK, new Item.Properties().group(FANS_ITEM_GROUP)).setRegistryName("gold_fan"),
            new BlockItem(ModBlocks.DIAMOND_FAN_BLOCK, new Item.Properties().group(FANS_ITEM_GROUP)).setRegistryName("diamond_fan"),
            new BlockItem(ModBlocks.EMERALD_FAN_BLOCK, new Item.Properties().group(FANS_ITEM_GROUP)).setRegistryName("emerald_fan"),
            new BlockItem(ModBlocks.REDSTONE_FAN_BLOCK, new Item.Properties().group(FANS_ITEM_GROUP)).setRegistryName("redstone_fan"),
            new BlockItem(ModBlocks.CONFIGURABLE_FAN_BLOCK, new Item.Properties().group(FANS_ITEM_GROUP)).setRegistryName("configurable_fan"),

            new Item(new Item.Properties().group(FANS_ITEM_GROUP)).setRegistryName("propeller"));
        }

        @SuppressWarnings("ConstantConditions")
        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> tileRegistryEvent) {
            tileRegistryEvent.getRegistry().register(TileEntityType.Builder.create(FanTile::new,
                    ModBlocks.IRON_FAN_BLOCK, ModBlocks.GOLD_FAN_BLOCK,
                    ModBlocks.DIAMOND_FAN_BLOCK, ModBlocks.EMERALD_FAN_BLOCK,
                    ModBlocks.REDSTONE_FAN_BLOCK
            ).build(null).setRegistryName("fan_tile"));
            tileRegistryEvent.getRegistry().register(TileEntityType.Builder.create(ConfigurableFanTile::new,
                    ModBlocks.CONFIGURABLE_FAN_BLOCK
            ).build(null).setRegistryName("configurable_fan_tile"));
        }
    }
}
