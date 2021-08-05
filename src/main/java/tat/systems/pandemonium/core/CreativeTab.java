package tat.systems.pandemonium.core;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import tat.systems.pandemonium.core.initialize.ItemRegistry;

public class CreativeTab extends ItemGroup {

    public static final CreativeTab CREATIVE_TAB = new CreativeTab(ItemGroup.GROUPS.length, "pandemonium");

    public CreativeTab(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.PANDO_RITUAL_BLOCK.get());
    }
}
