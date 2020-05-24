package xyz.przemyk.fansmod;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.nio.file.Path;

@Mod.EventBusSubscriber
public class Config {

    public static final String CATEGORY_GENERAL = "general";

    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

    public static ForgeConfigSpec COMMON_CONFIG;

    public static ForgeConfigSpec.IntValue IRON_FAN_RANGE;
    public static ForgeConfigSpec.IntValue GOLD_FAN_RANGE;
    public static ForgeConfigSpec.IntValue DIAMOND_FAN_RANGE;
    public static ForgeConfigSpec.IntValue EMERALD_FAN_RANGE;
    public static ForgeConfigSpec.IntValue CONFIGURABLE_FAN_MAX_RANGE;

    public static ForgeConfigSpec.DoubleValue IRON_FAN_SPEED;
    public static ForgeConfigSpec.DoubleValue GOLD_FAN_SPEED;
    public static ForgeConfigSpec.DoubleValue DIAMOND_FAN_SPEED;
    public static ForgeConfigSpec.DoubleValue EMERALD_FAN_SPEED;
    public static ForgeConfigSpec.DoubleValue CONFIGURABLE_FAN_SPEED;
    public static ForgeConfigSpec.DoubleValue REDSTONE_FAN_SPEED;

    static {
        COMMON_BUILDER.comment("Fans settings").push(CATEGORY_GENERAL);

        IRON_FAN_RANGE = COMMON_BUILDER.comment("Iron fan range (in blocks)")
                .defineInRange("ironFanRange", 8, 0, Integer.MAX_VALUE);
        GOLD_FAN_RANGE = COMMON_BUILDER.comment("Gold fan range (in blocks)")
                .defineInRange("goldFanRange", 10, 0, Integer.MAX_VALUE);
        DIAMOND_FAN_RANGE = COMMON_BUILDER.comment("Diamond fan range (in blocks)")
                .defineInRange("diamondFanRange", 12, 0, Integer.MAX_VALUE);
        EMERALD_FAN_RANGE = COMMON_BUILDER.comment("Emerald fan range (in blocks)")
                .defineInRange("emeraldFanRange", 16, 0, Integer.MAX_VALUE);
        CONFIGURABLE_FAN_MAX_RANGE = COMMON_BUILDER.comment("Configurable fan max range (in blocks)")
                .defineInRange("configurableFanMaxRange", 15, 1, 15);

        IRON_FAN_SPEED = COMMON_BUILDER.comment("Iron fan speed")
                .defineInRange("ironFanSpeed", 0.06, 0, 1000D);
        GOLD_FAN_SPEED = COMMON_BUILDER.comment("Gold fan speed")
                .defineInRange("goldFanSpeed", 0.1, 0, 1000D);
        DIAMOND_FAN_SPEED = COMMON_BUILDER.comment("Diamond fan speed")
                .defineInRange("diamondFanSpeed", 0.15, 0, 1000D);
        EMERALD_FAN_SPEED = COMMON_BUILDER.comment("Emerald fan speed")
                .defineInRange("emeraldFanSpeed", 0.2, 0, 1000D);
        CONFIGURABLE_FAN_SPEED = COMMON_BUILDER.comment("Configurable fan speed")
                .defineInRange("configurableFanSpeed", 0.15, 0, 1000D);
        REDSTONE_FAN_SPEED = COMMON_BUILDER.comment("Redstone fan speed")
                .defineInRange("redstoneFanSpeed", 0.13, 0, 1000D);

        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        final CommentedFileConfig configData = CommentedFileConfig.builder(path)
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();

        configData.load();
        spec.setConfig(configData);
    }
}
