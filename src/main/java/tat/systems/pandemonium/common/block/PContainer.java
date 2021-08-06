package tat.systems.pandemonium.common.block;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import tat.systems.pandemonium.common.block.ritualtable.RitualTableContainer;

public enum PContainer {
    RITUAL_BLOCK(IForgeContainerType.create(RitualTableContainer::new), PBlocks.RITUAL_TABLE);

    private final ContainerType<?> containerType;
    private final PBlocks pBlocks;

    PContainer(ContainerType<?> containerType, PBlocks pBlocks) {
        this.containerType = containerType;
        this.pBlocks = pBlocks;
    }

    public PBlocks getPBlocks() {
        return pBlocks;
    }

    public ContainerType<?> getContainerType() {
        return containerType;
    }
}
