package xyz.przemyk.fansmod;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.przemyk.fansmod.blocks.*;
import xyz.przemyk.fansmod.items.StickyBootsItem;

@SuppressWarnings("unused")
public class Registration {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, FansMod.MODID);
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, FansMod.MODID);
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, FansMod.MODID);

    public static void init() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        TILE_ENTITIES.register(eventBus);
    }

    public static final RegistryObject<FanBlock> IRON_FAN_BLOCK = BLOCKS.register("iron_fan", FanBlock::new);
    public static final RegistryObject<FanBlock> GOLD_FAN_BLOCK = BLOCKS.register("gold_fan", FanBlock::new);
    public static final RegistryObject<FanBlock> DIAMOND_FAN_BLOCK = BLOCKS.register("diamond_fan", FanBlock::new);
    public static final RegistryObject<FanBlock> EMERALD_FAN_BLOCK = BLOCKS.register("emerald_fan", FanBlock::new);

    public static final RegistryObject<RedstoneFanBlock> REDSTONE_FAN_BLOCK = BLOCKS.register("redstone_fan", RedstoneFanBlock::new);
    public static final RegistryObject<ConfigurableFanBlock> CONFIGURABLE_FAN_BLOCK = BLOCKS.register("configurable_fan", ConfigurableFanBlock::new);
    public static final RegistryObject<StickyFanBlock> STICKY_FAN_BLOCK = BLOCKS.register("sticky_fan", StickyFanBlock::new);

    public static final ItemGroup FANS_ITEM_GROUP = new ItemGroup(ItemGroup.GROUPS.length, "fansmod") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(IRON_FAN_ITEM.get());
        }
    };

    @SuppressWarnings("unchecked")
    private static BlockItem createBlockItem(RegistryObject<? extends Block> block) {
        return new BlockItem(block.get(), new Item.Properties().group(FANS_ITEM_GROUP));
    }

    public static final RegistryObject<Item> PROPELLER = ITEMS.register("propeller", () -> new Item(new Item.Properties().group(FANS_ITEM_GROUP)));
    public static final RegistryObject<StickyBootsItem> STICKY_BOOTS_ITEM = ITEMS.register("sticky_boots", StickyBootsItem::new);

    public static final RegistryObject<BlockItem> IRON_FAN_ITEM = ITEMS.register("iron_fan", () -> createBlockItem(IRON_FAN_BLOCK));
    public static final RegistryObject<BlockItem> GOLD_FAN_ITEM = ITEMS.register("gold_fan", () -> createBlockItem(GOLD_FAN_BLOCK));
    public static final RegistryObject<BlockItem> DIAMOND_FAN_ITEM = ITEMS.register("diamond_fan", () -> createBlockItem(DIAMOND_FAN_BLOCK));
    public static final RegistryObject<BlockItem> EMERALD_FAN_ITEM = ITEMS.register("emerald_fan", () -> createBlockItem(EMERALD_FAN_BLOCK));
    public static final RegistryObject<BlockItem> REDSTONE_FAN_ITEM = ITEMS.register("redstone_fan", () -> createBlockItem(REDSTONE_FAN_BLOCK));
    public static final RegistryObject<BlockItem> CONFIGURABLE_FAN_ITEM = ITEMS.register("configurable_fan", () -> createBlockItem(CONFIGURABLE_FAN_BLOCK));
    public static final RegistryObject<BlockItem> STICKY_FAN_ITEM = ITEMS.register("sticky_fan", () -> createBlockItem(STICKY_FAN_BLOCK));

    public static final RegistryObject<TileEntityType<FanTile>> FAN_TILE = TILE_ENTITIES.register("fan_tile",
            () -> TileEntityType.Builder.create(FanTile::new,
            IRON_FAN_BLOCK.get(), GOLD_FAN_BLOCK.get(),
            DIAMOND_FAN_BLOCK.get(), EMERALD_FAN_BLOCK.get())
            .build(null));

    public static final RegistryObject<TileEntityType<RedstoneFanTile>> REDSTONE_FAN_TILE = TILE_ENTITIES.register("redstone_fan_tile",
            () -> TileEntityType.Builder.create(RedstoneFanTile::new, REDSTONE_FAN_BLOCK.get()).build(null));

    public static final RegistryObject<TileEntityType<ConfigurableFanTile>> CONFIGURABLE_FAN_TILE = TILE_ENTITIES.register("configurable_fan_tile",
            () -> TileEntityType.Builder.create(ConfigurableFanTile::new, CONFIGURABLE_FAN_BLOCK.get()).build(null));

    public static final RegistryObject<TileEntityType<StickyFanTile>> STICKY_FAN_TILE = TILE_ENTITIES.register("sticky_fan_tile",
            () -> TileEntityType.Builder.create(StickyFanTile::new, STICKY_FAN_BLOCK.get()).build(null));

}
