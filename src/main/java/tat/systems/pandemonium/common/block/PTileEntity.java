package tat.systems.pandemonium.common.block;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import tat.systems.pandemonium.Pandemonium;
import tat.systems.pandemonium.common.block.PBlocks;
import tat.systems.pandemonium.common.block.ritualtable.RitualTableTileEntity;
import tat.systems.pandemonium.core.Registry;

import java.util.Locale;

public enum PTileEntity {

    RITUAL_TABLE(Pandemonium.getInstance().getRegistry().TILE_ENTITIES.register(PBlocks.RITUAL_TABLE.name().toLowerCase(Locale.ROOT), () -> TileEntityType.Builder.create(RitualTableTileEntity::new, PBlocks.RITUAL_TABLE.getBlock()).build(null)));

    private final RegistryObject<TileEntityType<?>> registryObject;

    PTileEntity(RegistryObject<TileEntityType<?>> registryObject) {
        this.registryObject = registryObject;
    }

    public RegistryObject<TileEntityType<?>> getRegistryObject() {
        return registryObject;
    }
}
