package tat.systems.pandemonium.core.abstraction;

import net.minecraft.item.Item;

public class ModdedItem {

    private final Item.Properties properties;
    private final String registry_name;

    public ModdedItem(String registry_name) {
        this.properties = new Item.Properties();
        this.registry_name = registry_name;
    }

    public Item.Properties getProperties() {
        return properties;
    }

    public String getRegistryName() {
        return registry_name;
    }
}
