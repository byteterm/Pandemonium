package tat.systems.pandemonium.common.block;


import net.minecraft.block.Block;

public enum PBlocks {

    DEMONIUM_BLOCK(new DemoniumBlock());

    private final Block block;

    PBlocks(Block block) {
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }
}
