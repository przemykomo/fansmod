package xyz.przemyk.fansmod.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import xyz.przemyk.fansmod.Config;
import xyz.przemyk.fansmod.registry.FansModBlockEntities;

public class IronFanBlockEntity extends FanBlockEntity {

    public IronFanBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FansModBlockEntities.IRON_FAN_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    @Override
    protected double getFanSpeed() {
        return Config.IRON_FAN_SPEED.get();
    }

    @Override
    protected int getMaxRange() {
        return Config.IRON_FAN_RANGE.get();
    }
}
