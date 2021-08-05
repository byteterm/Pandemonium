package tat.systems.pandemonium.core.initialize;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tat.systems.pandemonium.Pandemonium;
import tat.systems.pandemonium.core.CreativeTab;
import tat.systems.pandemonium.core.abstraction.ModdedItem;
import tat.systems.pandemonium.common.items.DemoniumChargeCrystalItem;
import tat.systems.pandemonium.common.items.DemoniumCrystalItem;

public class ItemRegistry {

    // List of all items objects, which must be registered
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Pandemonium.MOD_ID);

    // Register all item objects in the list ITEMS above
    public static void register() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(eventBus);

        register(new DemoniumCrystalItem());
        register(new DemoniumChargeCrystalItem());
    }

    public static final RegistryObject<Item> PANDO_RITUAL_BLOCK = ITEMS.register("pando_ritual_table", () -> new BlockItem
            (BlockRegistry.PANDO_RITUAL_BLOCK.get(), new Item.Properties().group(CreativeTab.CREATIVE_TAB)));

    public static void register(ModdedItem item) {
        ITEMS.register(item.getRegistryName(), () -> new Item(item.getProperties()));
    }
}
