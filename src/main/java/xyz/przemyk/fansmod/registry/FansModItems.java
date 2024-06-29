package xyz.przemyk.fansmod.registry;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.przemyk.fansmod.FansMod;
import xyz.przemyk.fansmod.items.LeafBlowerItem;
import xyz.przemyk.fansmod.items.StickyBootsItem;

import java.util.EnumMap;
import java.util.List;

@SuppressWarnings("unused")
public class FansModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, FansMod.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, FansMod.MODID);
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(BuiltInRegistries.ARMOR_MATERIAL, FansMod.MODID);

    public static void init(IEventBus modBus) {
        ITEMS.register(modBus);
        CREATIVE_MODE_TABS.register(modBus);
        ARMOR_MATERIALS.register(modBus);
    }

    private static BlockItem createBlockItem(DeferredHolder<Block, ? extends Block> block) {
        return new BlockItem(block.get(), new Item.Properties());
    }

    public static final Holder<ArmorMaterial> STICKY_ARMOR_MATERIAL =
            ARMOR_MATERIALS.register("copper", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 4);
                        map.put(ArmorItem.Type.CHESTPLATE, 6);
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.BODY, 4);
                    }),
                    9,
                    Holder.direct(SoundEvents.SLIME_BLOCK_PLACE),
                    () -> Ingredient.of(Tags.Items.INGOTS_IRON),
                    List.of(
                            new ArmorMaterial.Layer(
                                    ResourceLocation.fromNamespaceAndPath(FansMod.MODID, "sticky")
                            )/*,
                            new ArmorMaterial.Layer(
                                    ResourceLocation.fromNamespaceAndPath(FansMod.MODID, "sticky"), "_overlay", true
                            )*/
                    ), 0, 0
            ));

    public static final DeferredHolder<Item, Item> PROPELLER = ITEMS.register("propeller", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, StickyBootsItem> STICKY_BOOTS_ITEM = ITEMS.register("sticky_boots", StickyBootsItem::new);

    public static final DeferredHolder<Item, BlockItem> IRON_FAN_ITEM = ITEMS.register("iron_fan", () -> createBlockItem(FansModBlocks.IRON_FAN_BLOCK));
    public static final DeferredHolder<Item, BlockItem> GOLD_FAN_ITEM = ITEMS.register("gold_fan", () -> createBlockItem(FansModBlocks.GOLD_FAN_BLOCK));
    public static final DeferredHolder<Item, BlockItem> DIAMOND_FAN_ITEM = ITEMS.register("diamond_fan", () -> createBlockItem(FansModBlocks.DIAMOND_FAN_BLOCK));
    public static final DeferredHolder<Item, BlockItem> EMERALD_FAN_ITEM = ITEMS.register("emerald_fan", () -> createBlockItem(FansModBlocks.EMERALD_FAN_BLOCK));
    public static final DeferredHolder<Item, BlockItem> REDSTONE_FAN_ITEM = ITEMS.register("redstone_fan", () -> createBlockItem(FansModBlocks.REDSTONE_FAN_BLOCK));
    public static final DeferredHolder<Item, BlockItem> CONFIGURABLE_FAN_ITEM = ITEMS.register("configurable_fan", () -> createBlockItem(FansModBlocks.CONFIGURABLE_FAN_BLOCK));
    public static final DeferredHolder<Item, BlockItem> STICKY_FAN_ITEM = ITEMS.register("sticky_fan", () -> createBlockItem(FansModBlocks.STICKY_FAN_BLOCK));

    public static final DeferredHolder<Item, LeafBlowerItem> LEAF_BLOWER_ITEM = ITEMS.register("leaf_blower", LeafBlowerItem::new);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FANS_TAB = CREATIVE_MODE_TABS.register("fans_tab", () -> CreativeModeTab.builder()
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
