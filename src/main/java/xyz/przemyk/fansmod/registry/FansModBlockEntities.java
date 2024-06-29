package xyz.przemyk.fansmod.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.przemyk.fansmod.FansMod;
import xyz.przemyk.fansmod.blockentity.*;

@SuppressWarnings("unused")
public class FansModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, FansMod.MODID);

    public static void init(IEventBus modBus) {
        BLOCK_ENTITIES.register(modBus);
    }


    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<IronFanBlockEntity>> IRON_FAN_BLOCK_ENTITY = BLOCK_ENTITIES.register("iron_fan",
            () -> BlockEntityType.Builder.of(IronFanBlockEntity::new, FansModBlocks.IRON_FAN_BLOCK.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GoldFanBlockEntity>> GOLD_FAN_BLOCK_ENTITY = BLOCK_ENTITIES.register("gold_fan",
            () -> BlockEntityType.Builder.of(GoldFanBlockEntity::new, FansModBlocks.GOLD_FAN_BLOCK.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DiamondFanBlockEntity>> DIAMOND_FAN_BLOCK_ENTITY = BLOCK_ENTITIES.register("diamond_fan",
            () -> BlockEntityType.Builder.of(DiamondFanBlockEntity::new, FansModBlocks.DIAMOND_FAN_BLOCK.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EmeraldFanBlockEntity>> EMERALD_FAN_BLOCK_ENTITY = BLOCK_ENTITIES.register("emerald_fan",
            () -> BlockEntityType.Builder.of(EmeraldFanBlockEntity::new, FansModBlocks.EMERALD_FAN_BLOCK.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RedstoneFanBlockEntity>> REDSTONE_FAN_BLOCK_ENTITY = BLOCK_ENTITIES.register("redstone_fan",
            () -> BlockEntityType.Builder.of(RedstoneFanBlockEntity::new, FansModBlocks.REDSTONE_FAN_BLOCK.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ConfigurableFanBlockEntity>> CONFIGURABLE_FAN_BLOCK_ENTITY = BLOCK_ENTITIES.register("configurable_fan",
            () -> BlockEntityType.Builder.of(ConfigurableFanBlockEntity::new, FansModBlocks.CONFIGURABLE_FAN_BLOCK.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StickyFanBlockEntity>> STICKY_FAN_BLOCK_ENTITY = BLOCK_ENTITIES.register("sticky_fan",
            () -> BlockEntityType.Builder.of(StickyFanBlockEntity::new, FansModBlocks.STICKY_FAN_BLOCK.get()).build(null));
}
