package xyz.przemyk.fansmod.registry;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.przemyk.fansmod.FansMod;
import xyz.przemyk.fansmod.items.LeafBlowerItem;
import xyz.przemyk.fansmod.items.StickyBootsItem;

@SuppressWarnings("unused")
public class Items {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FansMod.MODID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

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

    public static final RegistryObject<BlockItem> IRON_FAN_ITEM = ITEMS.register("iron_fan", () -> createBlockItem(Blocks.IRON_FAN_BLOCK));
    public static final RegistryObject<BlockItem> GOLD_FAN_ITEM = ITEMS.register("gold_fan", () -> createBlockItem(Blocks.GOLD_FAN_BLOCK));
    public static final RegistryObject<BlockItem> DIAMOND_FAN_ITEM = ITEMS.register("diamond_fan", () -> createBlockItem(Blocks.DIAMOND_FAN_BLOCK));
    public static final RegistryObject<BlockItem> EMERALD_FAN_ITEM = ITEMS.register("emerald_fan", () -> createBlockItem(Blocks.EMERALD_FAN_BLOCK));
    public static final RegistryObject<BlockItem> REDSTONE_FAN_ITEM = ITEMS.register("redstone_fan", () -> createBlockItem(Blocks.REDSTONE_FAN_BLOCK));
    public static final RegistryObject<BlockItem> CONFIGURABLE_FAN_ITEM = ITEMS.register("configurable_fan", () -> createBlockItem(Blocks.CONFIGURABLE_FAN_BLOCK));
    public static final RegistryObject<BlockItem> STICKY_FAN_ITEM = ITEMS.register("sticky_fan", () -> createBlockItem(Blocks.STICKY_FAN_BLOCK));

    public static final RegistryObject<LeafBlowerItem> LEAF_BLOWER_ITEM = ITEMS.register("leaf_blower", LeafBlowerItem::new);
}
