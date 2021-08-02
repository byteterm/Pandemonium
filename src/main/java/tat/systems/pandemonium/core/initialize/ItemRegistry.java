package tat.systems.pandemonium.core.initialize;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tat.systems.pandemonium.Pandemonium;
import tat.systems.pandemonium.core.abstraction.ModdedItem;
import tat.systems.pandemonium.server.items.DemoniumChargeCrystalItem;
import tat.systems.pandemonium.server.items.DemoniumCrystalItem;

public class ItemRegistry {

    // List of all items objects, which must be registered
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Pandemonium.MOD_ID);

    // Register all item objects in the list ITEMS above
    public static void register() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(eventBus);

        register(new DemoniumCrystalItem());
        register(new DemoniumChargeCrystalItem());

        ITEMS.register("pando_ritual_table", () -> new BlockItem(BlockRegistry.PANDO_RITUAL_BLOCK.get(), new Item.Properties().group(ItemGroup.MATERIALS)));

    }

    public static void register(ModdedItem item) {
        ITEMS.register(item.getRegistryName(), () -> new Item(item.getProperties()));
    }
}
