package tat.systems.pandemonium.server.items;

import net.minecraft.item.ItemGroup;
import tat.systems.pandemonium.core.abstraction.ModdedItem;

public class DemoniumChargeCrystalItem extends ModdedItem {

    public DemoniumChargeCrystalItem() {
        super("demonium_charge_crystal");
        this.getProperties().group(ItemGroup.MATERIALS);
        this.getProperties().isImmuneToFire();
    }
}
