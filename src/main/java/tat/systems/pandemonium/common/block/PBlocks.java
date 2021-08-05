package tat.systems.pandemonium.common.block;

import net.minecraft.block.Block;
import tat.systems.pandemonium.common.block.ritualtable.RitualTableBlock;

public enum PBlocks {

    DEMONIUM_BLOCK(new DemoniumBlock()),
    RITUAL_TABLE(new RitualTableBlock());

    private final Block block;

    PBlocks(Block block) {
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }
}
