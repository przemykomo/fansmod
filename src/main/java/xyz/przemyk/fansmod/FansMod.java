package xyz.przemyk.fansmod;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.loading.FMLPaths;
import xyz.przemyk.fansmod.blocks.*;
import xyz.przemyk.fansmod.registry.FansModBlocks;
import xyz.przemyk.fansmod.registry.FansModItems;
import xyz.przemyk.fansmod.registry.FansModBlockEntities;

@Mod(FansMod.MODID)
public class FansMod {
    public static final String MODID = "fansmod";

    public FansMod(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);
        Config.loadConfig(Config.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("fansmod-common.toml"));
        ConfigurableFanBlock.LEVEL = IntegerProperty.create("level", 0, Config.CONFIGURABLE_FAN_MAX_RANGE.get());

        FansModBlocks.init(modEventBus);
        FansModBlockEntities.init(modEventBus);
        FansModItems.init(modEventBus);
    }
}
