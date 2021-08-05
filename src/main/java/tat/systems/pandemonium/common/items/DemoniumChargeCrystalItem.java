package tat.systems.pandemonium.common.items;

import net.minecraft.item.ItemGroup;
import tat.systems.pandemonium.core.CreativeTab;
import tat.systems.pandemonium.core.abstraction.ModdedItem;

public class DemoniumChargeCrystalItem extends ModdedItem {

    public DemoniumChargeCrystalItem() {
        super("demonium_charge_crystal");
        this.getProperties().group(CreativeTab.CREATIVE_TAB);
        this.getProperties().isImmuneToFire();
    }
}
