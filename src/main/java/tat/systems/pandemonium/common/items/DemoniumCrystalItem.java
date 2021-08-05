package tat.systems.pandemonium.common.items;

import net.minecraft.item.ItemGroup;
import tat.systems.pandemonium.core.CreativeTab;
import tat.systems.pandemonium.core.abstraction.ModdedItem;

public class DemoniumCrystalItem extends ModdedItem {

    public DemoniumCrystalItem() {
        super("demonium_crystal");
        this.getProperties().group(CreativeTab.CREATIVE_TAB);
        this.getProperties().isImmuneToFire();
    }
}
