package tat.systems.pandemonium.common.block.ritualtable;

import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.items.ItemStackHandler;
import tat.systems.pandemonium.Pandemonium;
import tat.systems.pandemonium.common.block.PTileEntity;
import tat.systems.pandemonium.core.Registry;

public class RitualTableTileEntity extends TileEntity {

    public int slots = 1;

    protected NonNullList<ItemStack> items = NonNullList.withSize(slots, ItemStack.EMPTY);

    public RitualTableTileEntity(TileEntityType<?> tileEntityType) {
        super(tileEntityType);
    }

    public RitualTableTileEntity() {
        super(PTileEntity.RITUAL_TABLE.getRegistryObject().get());
    }
}
