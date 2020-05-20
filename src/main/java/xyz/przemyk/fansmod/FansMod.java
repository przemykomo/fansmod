package xyz.przemyk.fansmod;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import xyz.przemyk.fansmod.blocks.FanBlock;
import xyz.przemyk.fansmod.blocks.FanTile;
import xyz.przemyk.fansmod.blocks.ModBlocks;
import xyz.przemyk.fansmod.blocks.RedstoneFanBlock;

@Mod(FansMod.MODID)
public class FansMod {
    public static final String MODID = "fansmod";

    public FansMod() {
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
            blockRegistryEvent.getRegistry().register(new FanBlock().setRegistryName("iron_fan"));
            blockRegistryEvent.getRegistry().register(new FanBlock().setRegistryName("gold_fan"));
            blockRegistryEvent.getRegistry().register(new FanBlock().setRegistryName("diamond_fan"));
            blockRegistryEvent.getRegistry().register(new FanBlock().setRegistryName("emerald_fan"));
            blockRegistryEvent.getRegistry().register(new RedstoneFanBlock(0.13, 6).setRegistryName("redstone_fan"));
        }

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
            itemRegistryEvent.getRegistry().register(new BlockItem(ModBlocks.IRON_FAN_BLOCK, new Item.Properties().group(FANS_ITEM_GROUP)).setRegistryName("iron_fan"));
            itemRegistryEvent.getRegistry().register(new BlockItem(ModBlocks.GOLD_FAN_BLOCK, new Item.Properties().group(FANS_ITEM_GROUP)).setRegistryName("gold_fan"));
            itemRegistryEvent.getRegistry().register(new BlockItem(ModBlocks.DIAMOND_FAN_BLOCK, new Item.Properties().group(FANS_ITEM_GROUP)).setRegistryName("diamond_fan"));
            itemRegistryEvent.getRegistry().register(new BlockItem(ModBlocks.EMERALD_FAN_BLOCK, new Item.Properties().group(FANS_ITEM_GROUP)).setRegistryName("emerald_fan"));
            itemRegistryEvent.getRegistry().register(new BlockItem(ModBlocks.REDSTONE_FAN_BLOCK, new Item.Properties().group(FANS_ITEM_GROUP)).setRegistryName("redstone_fan"));

            itemRegistryEvent.getRegistry().register(new Item(new Item.Properties().group(FANS_ITEM_GROUP)).setRegistryName("propeller"));
        }

        @SuppressWarnings("ConstantConditions")
        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> tileRegistryEvent) {
            tileRegistryEvent.getRegistry().register(TileEntityType.Builder.create(FanTile::new,
                    ModBlocks.IRON_FAN_BLOCK, ModBlocks.GOLD_FAN_BLOCK,
                    ModBlocks.DIAMOND_FAN_BLOCK, ModBlocks.EMERALD_FAN_BLOCK,
                    ModBlocks.REDSTONE_FAN_BLOCK
                    ).build(null).setRegistryName("fan_tile"));
        }
    }
}
