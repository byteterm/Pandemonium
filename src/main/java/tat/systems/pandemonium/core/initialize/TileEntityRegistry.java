package tat.systems.pandemonium.core.initialize;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tat.systems.pandemonium.Pandemonium;
import tat.systems.pandemonium.common.blocks.PandoRitualTable;
import tat.systems.pandemonium.common.tileentity.PandoRitualTableTileEntity;

public class TileEntityRegistry {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE = DeferredRegister
            .create(ForgeRegistries.TILE_ENTITIES, Pandemonium.MOD_ID);

    public static final RegistryObject<TileEntityType<PandoRitualTableTileEntity>> PANDO_RITUAL_TABLE =
            TILE_ENTITY_TYPE.register("pando_ritual_table_holder",
                    () -> TileEntityType.Builder.create(PandoRitualTableTileEntity::new, BlockRegistry.PANDO_RITUAL_BLOCK.get()).build(null));
}
