package tat.systems.pandemonium.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class DemoniumBlock extends Block {

    public DemoniumBlock() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(2f, 10f)
                .sound(SoundType.METAL)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE));
    }

}
