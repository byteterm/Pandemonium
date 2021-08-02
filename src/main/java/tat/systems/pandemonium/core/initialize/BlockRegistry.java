package tat.systems.pandemonium.core.initialize;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.lwjgl.system.CallbackI;
import tat.systems.pandemonium.Pandemonium;
import tat.systems.pandemonium.server.blocks.PandoRitualTable;

public class BlockRegistry {

    // List of all blocks objects, which must be registered
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Pandemonium.MOD_ID);

    // Register all block objects in the list BLOCKS above
    public static void register() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(eventBus);
    }

    public static final RegistryObject<Block> PANDO_RITUAL_BLOCK = BLOCKS.register("pando_ritual_table", () -> new Block(
            AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(15f, 30f)));
}
