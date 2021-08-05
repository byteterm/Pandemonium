package tat.systems.pandemonium.core;

import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import tat.systems.pandemonium.Pandemonium;
import tat.systems.pandemonium.common.block.PBlocks;

import java.util.Locale;

public class Registry {

    public final DeferredRegister<Block> BLOCKS = create(ForgeRegistries.BLOCKS);
    public final DeferredRegister<Item> ITEMS = create(ForgeRegistries.ITEMS);
    public final DeferredRegister<ContainerType<?>> CONTAINERS = create(ForgeRegistries.CONTAINERS);
    public final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = create(ForgeRegistries.TILE_ENTITIES);

    // Do not touch my baby!
    // System only!
    public void register() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        CONTAINERS.register(eventBus);
        TILE_ENTITIES.register(eventBus);

        registerBlocks();
    }

    public <T extends IForgeRegistryEntry<T>> DeferredRegister<T> create(IForgeRegistry<T> registry) {
        return DeferredRegister.create(registry, Pandemonium.MOD_ID);
    }

    private void registerBlocks() {
        for(PBlocks blocks : PBlocks.values()) {
            System.out.println("REGISTER BLOCK " + blocks.name());
            BLOCKS.register(blocks.name().toLowerCase(Locale.ROOT), blocks::getBlock);
        }
    }
}
