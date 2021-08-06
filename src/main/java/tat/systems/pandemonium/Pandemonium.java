package tat.systems.pandemonium;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tat.systems.pandemonium.core.Registry;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Pandemonium.MOD_ID)
public class Pandemonium {

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    // Pandemonium mod id
    public static final String MOD_ID = "pandemonium";

    // Registry for items, blocks, containers, tileEntities
    private final Registry registry;

    // Main instance
    private static Pandemonium instance;

    public Pandemonium() {
        instance = this;
        this.registry = new Registry();

        // Register Blocks, Items, Container, TileEntity
        registry.register();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static Pandemonium getInstance() {
        return instance;
    }

    public Registry getRegistry() {
        return this.registry;
    }
}
