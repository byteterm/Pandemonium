package tat.systems.pandemonium.common.block.ritualtable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import tat.systems.pandemonium.common.block.PBlocks;
import tat.systems.pandemonium.common.block.PContainer;

public class RitualTableContainer extends Container {

    public final RitualTableTileEntity ritualTableTileEntity;
    private final IWorldPosCallable canInteractWithCallable;

    public RitualTableContainer(final int windowId, final PlayerInventory playerInventory, final RitualTableTileEntity tileEntity) {
        super(PContainer.RITUAL_BLOCK.getContainerType(), windowId);
        this.ritualTableTileEntity = tileEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());

        //Tile Entity
        this.addSlot(new Slot((IInventory) ritualTableTileEntity, 0, 35, 30));
    }

    public RitualTableContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer buffer) {
        this(windowId, playerInventory, getTileEntity(playerInventory, buffer));
    }

    private static RitualTableTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer buffer) {
        final TileEntity tileEntity = playerInventory.player.world.getTileEntity(buffer.readBlockPos());

        if(tileEntity instanceof RitualTableTileEntity) {
            return (RitualTableTileEntity) tileEntity;
        }
        throw new IllegalStateException("Tile Entity is not right?");
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, PBlocks.RITUAL_TABLE.getBlock());
    }
}
