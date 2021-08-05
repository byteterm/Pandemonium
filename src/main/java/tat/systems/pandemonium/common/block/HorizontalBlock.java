package tat.systems.pandemonium.common.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class HorizontalBlock extends Block {

    public static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;

    public HorizontalBlock(AbstractBlock.Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation direction) {
        return state.with(HORIZONTAL_FACING, direction.rotate(state.get(HORIZONTAL_FACING)));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    protected void fillStateContainer(Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(HORIZONTAL_FACING);
    }

}
