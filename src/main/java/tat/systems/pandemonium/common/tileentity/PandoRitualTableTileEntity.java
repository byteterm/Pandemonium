package tat.systems.pandemonium.common.tileentity;

import net.minecraft.block.Blocks;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import tat.systems.pandemonium.core.initialize.TileEntityRegistry;

public class PandoRitualTableTileEntity extends TileEntity implements ITickableTileEntity {

    public PandoRitualTableTileEntity() {
        super(TileEntityRegistry.PANDO_RITUAL_TABLE.get());
    }

    @Override
    public void tick() {
        this.world.setBlockState(this.pos.down(), Blocks.AIR.getDefaultState());
    }
}
