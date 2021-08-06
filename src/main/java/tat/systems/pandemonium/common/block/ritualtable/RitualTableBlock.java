package tat.systems.pandemonium.common.block.ritualtable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;
import tat.systems.pandemonium.Pandemonium;
import tat.systems.pandemonium.common.block.PTileEntity;
import tat.systems.pandemonium.common.block.abstraction.HorizontalBlock;
import tat.systems.pandemonium.core.Registry;
import tat.systems.pandemonium.core.util.ShapeUtil;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class RitualTableBlock extends HorizontalBlock {

    protected static final Map<Direction, VoxelShape> SHAPES = new HashMap<>();

    public RitualTableBlock() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(2f, 5f)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(0)
                .sound(SoundType.METAL));
        ShapeUtil.runCalc(Stream.of(
                Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
                Block.makeCuboidShape(1, 1, 1, 15, 2, 15),
                Block.makeCuboidShape(2, 2, 2, 14, 3, 14),
                Block.makeCuboidShape(5, 3, 5, 11, 15, 11),
                Block.makeCuboidShape(1, 15, 1, 15, 16, 15)
        ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get(), SHAPES);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return PTileEntity.RITUAL_TABLE.getRegistryObject().get().create();
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        return SHAPES.get(state.get(HORIZONTAL_FACING));
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {
            TileEntity tileEntity = worldIn.getTileEntity(pos);

            if (tileEntity instanceof RitualTableTileEntity) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (RitualTableTileEntity) tileEntity, pos);
            }
        }

        return ActionResultType.SUCCESS;
    }
}
