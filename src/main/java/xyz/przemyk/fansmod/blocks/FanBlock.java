package xyz.przemyk.fansmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockReader;

import java.util.function.Supplier;

public class FanBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    private final Supplier<TileEntity> tileEntitySupplier;

    public FanBlock(Properties properties, Supplier<TileEntity> tileEntitySupplier) {
//        super(Properties.create(Material.PISTON).sound(SoundType.WOOD).hardnessAndResistance(2.0f));
        super(properties);
        this.tileEntitySupplier = tileEntitySupplier;
        setDefaultState(stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return getDefaultState().with(FACING, context.getNearestLookingDirection().getOpposite());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return tileEntitySupplier.get();
    }
}
