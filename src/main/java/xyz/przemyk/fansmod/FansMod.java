package xyz.przemyk.fansmod;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
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
            blockRegistryEvent.getRegistry().register(new FanBlock());
        }

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
            itemRegistryEvent.getRegistry().register(new BlockItem(ModBlocks.FAN_BLOCK, new Item.Properties()).setRegistryName("fan"));
        }

        @SuppressWarnings("ConstantConditions")
        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> tileRegistryEvent) {
            tileRegistryEvent.getRegistry().register(TileEntityType.Builder.create(FanTile::new, ModBlocks.FAN_BLOCK)
                    .build(null).setRegistryName("fan"));
        }
    }
}
