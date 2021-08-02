package tat.systems.pandemonium;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tat.systems.pandemonium.core.initialize.BlockRegistry;
import tat.systems.pandemonium.core.initialize.ItemRegistry;
import tat.systems.pandemonium.server.event.DemoniumCrystalChargeEvent;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Pandemonium.MOD_ID)
public class Pandemonium {

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    // Pandemonium mod id
    public static final String MOD_ID = "pandemonium";

    public Pandemonium() {
        // Register all items from this mod
        ItemRegistry.register();
        // Register all blocks from this mod
        BlockRegistry.register();

        // Register the setup method for modloading
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, DemoniumCrystalChargeEvent::onChargeEvent);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }


}
