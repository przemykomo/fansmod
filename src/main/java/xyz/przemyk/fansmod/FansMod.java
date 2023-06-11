package xyz.przemyk.fansmod;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;
import xyz.przemyk.fansmod.blocks.*;
import xyz.przemyk.fansmod.registry.FansModBlocks;
import xyz.przemyk.fansmod.registry.FansModItems;
import xyz.przemyk.fansmod.registry.FansModBlockEntities;

@Mod(FansMod.MODID)
public class FansMod {
    public static final String MODID = "fansmod";

    public FansMod() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);
        Config.loadConfig(Config.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("fansmod-common.toml"));
        ConfigurableFanBlock.LEVEL = IntegerProperty.create("level", 0, Config.CONFIGURABLE_FAN_MAX_RANGE.get());

        FansModBlocks.init();
        FansModBlockEntities.init();
        FansModItems.init();
    }
}
