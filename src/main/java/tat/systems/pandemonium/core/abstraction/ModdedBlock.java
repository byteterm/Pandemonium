package tat.systems.pandemonium.core.abstraction;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class ModdedBlock {

    private final AbstractBlock.Properties properties;
    private final Item.Properties itemProperties;
    private final String registryName;

    public ModdedBlock(String registryName) {
        this(registryName, new Item.Properties(), AbstractBlock.Properties.create(Material.IRON));
    }

    public ModdedBlock(String registryName, Item.Properties itemProperties, AbstractBlock.Properties properties) {
        this.registryName = registryName;
        this.itemProperties = itemProperties;
        this.properties = properties;
    }

    public AbstractBlock.Properties getProperties() {
        return properties;
    }

    public Item.Properties getItemProperties() {
        return itemProperties;
    }

    public String getRegistryName() {
        return registryName;
    }
}
