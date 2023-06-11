package xyz.przemyk.fansmod.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.przemyk.fansmod.FansMod;
import xyz.przemyk.fansmod.items.LeafBlowerItem;
import xyz.przemyk.fansmod.items.StickyBootsItem;

@SuppressWarnings("unused")
public class FansModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FansMod.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FansMod.MODID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        CREATIVE_MODE_TABS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private static BlockItem createBlockItem(RegistryObject<? extends Block> block) {
        return new BlockItem(block.get(), new Item.Properties());
    }

    public static final RegistryObject<Item> PROPELLER = ITEMS.register("propeller", () -> new Item(new Item.Properties()));
    public static final RegistryObject<StickyBootsItem> STICKY_BOOTS_ITEM = ITEMS.register("sticky_boots", StickyBootsItem::new);

    public static final RegistryObject<BlockItem> IRON_FAN_ITEM = ITEMS.register("iron_fan", () -> createBlockItem(FansModBlocks.IRON_FAN_BLOCK));
    public static final RegistryObject<BlockItem> GOLD_FAN_ITEM = ITEMS.register("gold_fan", () -> createBlockItem(FansModBlocks.GOLD_FAN_BLOCK));
    public static final RegistryObject<BlockItem> DIAMOND_FAN_ITEM = ITEMS.register("diamond_fan", () -> createBlockItem(FansModBlocks.DIAMOND_FAN_BLOCK));
    public static final RegistryObject<BlockItem> EMERALD_FAN_ITEM = ITEMS.register("emerald_fan", () -> createBlockItem(FansModBlocks.EMERALD_FAN_BLOCK));
    public static final RegistryObject<BlockItem> REDSTONE_FAN_ITEM = ITEMS.register("redstone_fan", () -> createBlockItem(FansModBlocks.REDSTONE_FAN_BLOCK));
    public static final RegistryObject<BlockItem> CONFIGURABLE_FAN_ITEM = ITEMS.register("configurable_fan", () -> createBlockItem(FansModBlocks.CONFIGURABLE_FAN_BLOCK));
    public static final RegistryObject<BlockItem> STICKY_FAN_ITEM = ITEMS.register("sticky_fan", () -> createBlockItem(FansModBlocks.STICKY_FAN_BLOCK));

    public static final RegistryObject<LeafBlowerItem> LEAF_BLOWER_ITEM = ITEMS.register("leaf_blower", LeafBlowerItem::new);

    public static final RegistryObject<CreativeModeTab> FANS_TAB = CREATIVE_MODE_TABS.register("fans_tab", () -> CreativeModeTab.builder()
            .icon(() -> IRON_FAN_ITEM.get().getDefaultInstance())
            .title(Component.translatable(FansMod.MODID + ".fans_tab"))
            .displayItems((parameters, output) -> {
                output.accept(PROPELLER.get());
                output.accept(STICKY_BOOTS_ITEM.get());
                output.accept(IRON_FAN_ITEM.get());
                output.accept(GOLD_FAN_ITEM.get());
                output.accept(DIAMOND_FAN_ITEM.get());
                output.accept(EMERALD_FAN_ITEM.get());
                output.accept(REDSTONE_FAN_ITEM.get());
                output.accept(CONFIGURABLE_FAN_ITEM.get());
                output.accept(STICKY_FAN_ITEM.get());
                output.accept(LEAF_BLOWER_ITEM.get());
            })
            .build());
}
