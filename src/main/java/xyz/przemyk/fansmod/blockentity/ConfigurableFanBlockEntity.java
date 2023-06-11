package xyz.przemyk.fansmod.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import xyz.przemyk.fansmod.Config;
import xyz.przemyk.fansmod.blocks.ConfigurableFanBlock;
import xyz.przemyk.fansmod.registry.FansModBlockEntities;

public class ConfigurableFanBlockEntity extends FanBlockEntity {

    public ConfigurableFanBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FansModBlockEntities.CONFIGURABLE_FAN_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    @Override
    protected double getFanSpeed() {
        return Config.CONFIGURABLE_FAN_SPEED.get();
    }

    @Override
    protected int getMaxRange() {
        return level.getBlockState(worldPosition).getValue(ConfigurableFanBlock.LEVEL);
    }
}
