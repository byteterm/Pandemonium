package tat.systems.pandemonium.server.items;

import net.minecraft.item.ItemGroup;
import tat.systems.pandemonium.core.abstraction.ModdedItem;

public class DemoniumCrystalItem extends ModdedItem {

    public DemoniumCrystalItem() {
        super("demonium_crystal");
        this.getProperties().group(ItemGroup.MATERIALS);
        this.getProperties().isImmuneToFire();
    }
}
