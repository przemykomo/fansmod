package xyz.przemyk.fansmod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import xyz.przemyk.fansmod.blockentity.ConfigurableFanBlockEntity;

public class ConfigurableFanBlock extends FanBlock {

    public static IntegerProperty LEVEL;

    public ConfigurableFanBlock(Properties properties) {
        super(properties, ConfigurableFanBlockEntity::new);

        registerDefaultState(defaultBlockState().setValue(LEVEL, 0));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ConfigurableFanBlockEntity(blockPos, blockState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(LEVEL);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if (pPlayer.isCrouching()) {
            pLevel.setBlock(pPos, pState.setValue(LEVEL, 0), 2);
        } else {
            pLevel.setBlock(pPos, pState.cycle(LEVEL), 2);
        }

        return InteractionResult.SUCCESS;
    }
}
