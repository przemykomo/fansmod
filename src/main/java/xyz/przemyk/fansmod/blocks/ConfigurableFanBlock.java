package xyz.przemyk.fansmod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import xyz.przemyk.fansmod.tiles.ConfigurableFanTile;

public class ConfigurableFanBlock extends FanBlock {

    /**
     * See {@link xyz.przemyk.fansmod.FansMod#FansMod()}
     */
    public static IntegerProperty LEVEL;

    public ConfigurableFanBlock(Properties properties) {
        super(properties, ConfigurableFanTile::new);

        registerDefaultState(defaultBlockState().setValue(LEVEL, 0));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ConfigurableFanTile(blockPos, blockState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(LEVEL);
    }

    @SuppressWarnings("deprecation")
    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        if (player.isCrouching()) {
            worldIn.setBlock(pos, state.setValue(LEVEL, 0), 2);
        } else {
            worldIn.setBlock(pos, state.cycle(LEVEL), 2);
        }

        return InteractionResult.SUCCESS;
    }
}
