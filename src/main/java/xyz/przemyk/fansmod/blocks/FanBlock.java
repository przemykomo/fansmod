package xyz.przemyk.fansmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import xyz.przemyk.fansmod.tiles.FanTile;

import javax.annotation.Nullable;

public abstract class FanBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    public FanBlock() {
        super(Properties.create(Material.PISTON)
                .sound(SoundType.WOOD)
                .hardnessAndResistance(2.0f)
        );
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        worldIn.setBlockState(pos, state.with(FACING, getFacingFromEntity(pos, placer)), 2);
    }

    public static Direction getFacingFromEntity(BlockPos blockPos, LivingEntity entity) {
        if (entity == null) {
            return Direction.NORTH;
        }
        return Direction.getFacingFromVector(entity.getPosX() - blockPos.getX(),
                entity.getPosY() - blockPos.getY(), entity.getPosZ() - blockPos.getZ());
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
    public abstract FanTile createTileEntity(BlockState state, IBlockReader world);
}
