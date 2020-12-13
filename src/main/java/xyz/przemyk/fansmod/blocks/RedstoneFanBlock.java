package xyz.przemyk.fansmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.przemyk.fansmod.tiles.RedstoneFanTile;

public class RedstoneFanBlock extends FanBlock {

    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public RedstoneFanBlock(Properties properties) {
        super(properties, RedstoneFanTile::new);

        setDefaultState(getDefaultState().with(POWERED, false));
    }

    @SuppressWarnings("deprecation")
    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!worldIn.isRemote) {
            if (state.get(POWERED) != worldIn.isBlockPowered(pos)) {
                worldIn.setBlockState(pos, state.with(POWERED, worldIn.isBlockPowered(pos)), 2);
            }
        }
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(POWERED);
    }
}
