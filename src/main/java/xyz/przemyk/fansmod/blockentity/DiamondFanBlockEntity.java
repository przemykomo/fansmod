package xyz.przemyk.fansmod.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import xyz.przemyk.fansmod.Config;
import xyz.przemyk.fansmod.registry.FansModBlockEntities;

public class DiamondFanBlockEntity extends FanBlockEntity {

    public DiamondFanBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FansModBlockEntities.DIAMOND_FAN_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    @Override
    protected double getFanSpeed() {
        return Config.DIAMOND_FAN_SPEED.get();
    }

    @Override
    protected int getMaxRange() {
        return Config.DIAMOND_FAN_RANGE.get();
    }
}
