package xyz.przemyk.fansmod;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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
import xyz.przemyk.fansmod.setup.ClientProxy;
import xyz.przemyk.fansmod.setup.IProxy;
import xyz.przemyk.fansmod.setup.ServerProxy;

@Mod(FansMod.MODID)
public class FansMod {
    public static final String MODID = "fansmod";

    @SuppressWarnings("Convert2MethodRef")
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public FansMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlockRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            blockRegistryEvent.getRegistry().register(new FanBlock(0.05, 5).setRegistryName("iron_fan"));
            blockRegistryEvent.getRegistry().register(new FanBlock(0.1, 5).setRegistryName("gold_fan"));
            blockRegistryEvent.getRegistry().register(new FanBlock(0.15, 7).setRegistryName("diamond_fan"));
            blockRegistryEvent.getRegistry().register(new FanBlock(0.2, 7).setRegistryName("emerald_fan"));
            blockRegistryEvent.getRegistry().register(new FanBlock(0.13, 6).setRegistryName("redstone_fan"));
        }

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
            itemRegistryEvent.getRegistry().register(new BlockItem(ModBlocks.IRON_FAN_BLOCK, new Item.Properties()).setRegistryName("iron_fan"));
            itemRegistryEvent.getRegistry().register(new BlockItem(ModBlocks.GOLD_FAN_BLOCK, new Item.Properties()).setRegistryName("gold_fan"));
            itemRegistryEvent.getRegistry().register(new BlockItem(ModBlocks.DIAMOND_FAN_BLOCK, new Item.Properties()).setRegistryName("diamond_fan"));
            itemRegistryEvent.getRegistry().register(new BlockItem(ModBlocks.EMERALD_FAN_BLOCK, new Item.Properties()).setRegistryName("emerald_fan"));
            itemRegistryEvent.getRegistry().register(new BlockItem(ModBlocks.REDSTONE_FAN_BLOCK, new Item.Properties()).setRegistryName("redstone_fan"));
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
