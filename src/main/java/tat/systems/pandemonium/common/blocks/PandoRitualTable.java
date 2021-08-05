package tat.systems.pandemonium.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import tat.systems.pandemonium.core.abstraction.BlockHorizontal;
import tat.systems.pandemonium.core.initialize.TileEntityRegistry;
import tat.systems.pandemonium.core.util.ShapeUtil;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class PandoRitualTable extends BlockHorizontal {

    protected static final Map<Direction, VoxelShape> SHAPES = new HashMap<>();

    private Item item;

    public PandoRitualTable() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(5f, 20f)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool());
        ShapeUtil.runCalc(Stream.of(
                Block.makeCuboidShape(4, 3, 4, 12, 13, 12),
                Block.makeCuboidShape(2, 13, 2, 14, 14, 14),
                Block.makeCuboidShape(0, 0, 0, 16, 3, 16)
        ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get(), SHAPES);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
        if(item == null) {
            if(!(player.getHeldItemMainhand().getItem().equals(Items.AIR))) {
                item = player.getHeldItemMainhand().getItem();
                int stackSize = player.getHeldItemMainhand().getCount() - 1;
                player.getHeldItemMainhand().setCount(stackSize);
                player.sendMessage(ITextComponent.getTextComponentOrEmpty("Hallo hat das geklappt?"), player.getUniqueID());
            }
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityRegistry.PANDO_RITUAL_TABLE.get().create();
    }

    @SuppressWarnings("deprecated")
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        return SHAPES.get(state.get(HORIZONTAL_FACING));
    }
}
