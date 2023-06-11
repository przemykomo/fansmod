package xyz.przemyk.fansmod.registry;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.przemyk.fansmod.FansMod;
import xyz.przemyk.fansmod.blocks.*;
import xyz.przemyk.fansmod.blockentity.*;

@SuppressWarnings("unused")
public class FansModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FansMod.MODID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<FanBlock> IRON_FAN_BLOCK = BLOCKS.register("iron_fan", () -> new FanBlock(BlockBehaviour.Properties.copy(Blocks.PISTON).sound(SoundType.WOOD).strength(2.0f), IronFanBlockEntity::new));
    public static final RegistryObject<FanBlock> GOLD_FAN_BLOCK = BLOCKS.register("gold_fan", () -> new FanBlock(BlockBehaviour.Properties.copy(Blocks.PISTON).sound(SoundType.WOOD).strength(2.0f), GoldFanBlockEntity::new));
    public static final RegistryObject<FanBlock> DIAMOND_FAN_BLOCK = BLOCKS.register("diamond_fan", () -> new FanBlock(BlockBehaviour.Properties.copy(Blocks.PISTON).sound(SoundType.WOOD).strength(2.0f), DiamondFanBlockEntity::new));
    public static final RegistryObject<FanBlock> EMERALD_FAN_BLOCK = BLOCKS.register("emerald_fan", () -> new FanBlock(BlockBehaviour.Properties.copy(Blocks.PISTON).sound(SoundType.WOOD).strength(2.0f), EmeraldFanBlockEntity::new));
    public static final RegistryObject<FanBlock> STICKY_FAN_BLOCK = BLOCKS.register("sticky_fan", () -> new FanBlock(BlockBehaviour.Properties.copy(Blocks.PISTON).sound(SoundType.WOOD).strength(2.0f), StickyFanBlockEntity::new));

    public static final RegistryObject<RedstoneFanBlock> REDSTONE_FAN_BLOCK = BLOCKS.register("redstone_fan", () -> new RedstoneFanBlock(BlockBehaviour.Properties.copy(Blocks.PISTON).sound(SoundType.WOOD).strength(2.0f)));
    public static final RegistryObject<ConfigurableFanBlock> CONFIGURABLE_FAN_BLOCK = BLOCKS.register("configurable_fan", () -> new ConfigurableFanBlock(BlockBehaviour.Properties.copy(Blocks.PISTON).sound(SoundType.WOOD).strength(2.0f)));
}
