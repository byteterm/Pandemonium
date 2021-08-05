package tat.systems.pandemonium.common.block.ritualtable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class RitualTableBlock extends Block {

    public RitualTableBlock() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(2f, 5f)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(0)
                .sound(SoundType.METAL));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return null;
    }

    //ToDo: onRemove | use
}
