package tat.systems.pandemonium.core.abstraction;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;

public class ModdedBlock {

    private final AbstractBlock.Properties properties;
    private String registryName;

    public ModdedBlock(String registryName) {
        this.properties = AbstractBlock.Properties.create(Material.IRON);
    }

    public AbstractBlock.Properties getProperties() {
        return properties;
    }

    public String getRegistryName() {
        return registryName;
    }
}
