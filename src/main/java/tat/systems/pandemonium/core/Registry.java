package tat.systems.pandemonium.core;

import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import tat.systems.pandemonium.Pandemonium;
import tat.systems.pandemonium.common.block.PBlocks;
import tat.systems.pandemonium.common.block.PContainer;
import tat.systems.pandemonium.common.block.PTileEntity;
import tat.systems.pandemonium.common.block.ritualtable.RitualTableBlock;
import tat.systems.pandemonium.common.block.ritualtable.RitualTableTileEntity;

import java.util.Locale;
import java.util.function.Supplier;

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

        // Register Blocks
        registerBlocks();
        // Register TileEntity
        registerTileEntity();
        // Register Container
        registerContainer();
    }

    private void registerContainer() {
        for (PContainer container : PContainer.values()) {
            CONTAINERS.register(container.getPBlocks().name().toLowerCase(Locale.ROOT), container::getContainerType);
        }
    }

    private void registerTileEntity() {
        for (PTileEntity tileEntity : PTileEntity.values())
            tileEntity.getRegistryObject();
    }

    private <T extends IForgeRegistryEntry<T>> DeferredRegister<T> create(IForgeRegistry<T> registry) {
        return DeferredRegister.create(registry, Pandemonium.MOD_ID);
    }

    private void registerBlocks() {
        for(PBlocks blocks : PBlocks.values()) {
            registerBlock(blocks.name().toLowerCase(Locale.ROOT), blocks::getBlock);
        }
    }

    private <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private <T extends Block> void registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> registryObject = registerNoItem(name, block);
        ITEMS.register(name, () -> new BlockItem(registryObject.get(), new Item.Properties().group(ItemGroup.FOOD)));
    }
}