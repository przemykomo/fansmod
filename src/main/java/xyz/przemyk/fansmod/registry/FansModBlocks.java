package xyz.przemyk.fansmod.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.przemyk.fansmod.FansMod;
import xyz.przemyk.fansmod.blocks.*;
import xyz.przemyk.fansmod.blockentity.*;

@SuppressWarnings({"unused", "deprecation"})
public class FansModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, FansMod.MODID);

    public static void init(IEventBus modBus) {
        BLOCKS.register(modBus);
    }

    public static final DeferredHolder<Block, FanBlock> IRON_FAN_BLOCK = BLOCKS.register("iron_fan", () -> new FanBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.PISTON).sound(SoundType.WOOD).strength(2.0f), IronFanBlockEntity::new));
    public static final DeferredHolder<Block, FanBlock> GOLD_FAN_BLOCK = BLOCKS.register("gold_fan", () -> new FanBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.PISTON).sound(SoundType.WOOD).strength(2.0f), GoldFanBlockEntity::new));
    public static final DeferredHolder<Block, FanBlock> DIAMOND_FAN_BLOCK = BLOCKS.register("diamond_fan", () -> new FanBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.PISTON).sound(SoundType.WOOD).strength(2.0f), DiamondFanBlockEntity::new));
    public static final DeferredHolder<Block, FanBlock> EMERALD_FAN_BLOCK = BLOCKS.register("emerald_fan", () -> new FanBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.PISTON).sound(SoundType.WOOD).strength(2.0f), EmeraldFanBlockEntity::new));
    public static final DeferredHolder<Block, FanBlock> STICKY_FAN_BLOCK = BLOCKS.register("sticky_fan", () -> new FanBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.PISTON).sound(SoundType.WOOD).strength(2.0f), StickyFanBlockEntity::new));

    public static final DeferredHolder<Block, RedstoneFanBlock> REDSTONE_FAN_BLOCK = BLOCKS.register("redstone_fan", () -> new RedstoneFanBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.PISTON).sound(SoundType.WOOD).strength(2.0f)));
    public static final DeferredHolder<Block, ConfigurableFanBlock> CONFIGURABLE_FAN_BLOCK = BLOCKS.register("configurable_fan", () -> new ConfigurableFanBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.PISTON).sound(SoundType.WOOD).strength(2.0f)));
}
