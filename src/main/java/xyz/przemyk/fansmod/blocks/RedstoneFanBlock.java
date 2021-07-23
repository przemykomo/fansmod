package xyz.przemyk.fansmod.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xyz.przemyk.fansmod.tiles.RedstoneFanTile;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class RedstoneFanBlock extends FanBlock {

    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public RedstoneFanBlock(Properties properties) {
        super(properties, RedstoneFanTile::new);

        registerDefaultState(defaultBlockState().setValue(POWERED, false));
    }

    @SuppressWarnings("deprecation")
    @Override
    public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!worldIn.isClientSide) {
            if (state.getValue(POWERED) != worldIn.hasNeighborSignal(pos)) {
                worldIn.setBlock(pos, state.setValue(POWERED, worldIn.hasNeighborSignal(pos)), 2);
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(POWERED);
    }
}
