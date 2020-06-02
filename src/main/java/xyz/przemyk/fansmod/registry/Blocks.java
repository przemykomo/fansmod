package xyz.przemyk.fansmod.registry;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.przemyk.fansmod.FansMod;
import xyz.przemyk.fansmod.blocks.*;

@SuppressWarnings("unused")
public class Blocks {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, FansMod.MODID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<FanBlock> IRON_FAN_BLOCK = BLOCKS.register("iron_fan", FanBlock::new);
    public static final RegistryObject<FanBlock> GOLD_FAN_BLOCK = BLOCKS.register("gold_fan", FanBlock::new);
    public static final RegistryObject<FanBlock> DIAMOND_FAN_BLOCK = BLOCKS.register("diamond_fan", FanBlock::new);
    public static final RegistryObject<FanBlock> EMERALD_FAN_BLOCK = BLOCKS.register("emerald_fan", FanBlock::new);

    public static final RegistryObject<RedstoneFanBlock> REDSTONE_FAN_BLOCK = BLOCKS.register("redstone_fan", RedstoneFanBlock::new);
    public static final RegistryObject<ConfigurableFanBlock> CONFIGURABLE_FAN_BLOCK = BLOCKS.register("configurable_fan", ConfigurableFanBlock::new);
    public static final RegistryObject<StickyFanBlock> STICKY_FAN_BLOCK = BLOCKS.register("sticky_fan", StickyFanBlock::new);
}
