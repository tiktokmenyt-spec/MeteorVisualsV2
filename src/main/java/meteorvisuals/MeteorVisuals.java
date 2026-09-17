package meteorvisuals;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import meteorvisuals.config.ConfigManager;
import meteorvisuals.gui.ClickGui;
import meteorvisuals.gui.ThemeManager;
import meteorvisuals.module.ModuleManager;
import meteorvisuals.modules.hud.Watermark;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MeteorVisuals implements ClientModInitializer {
    public static final String MOD_ID = "meteorvisuals";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static final ModuleManager MODULE_MANAGER = ModuleManager.getInstance();
    private static ConfigManager configManager;

    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing MeteorVisuals (client-side visual mod)");

        ThemeManager.initializeDefaults();

        configManager = new ConfigManager(FabricLoader.getInstance().getConfigDir().resolve("meteorvisuals"));

        registerModules();
        configManager.loadModules(MODULE_MANAGER.getModules());

        LOGGER.info("MeteorVisuals initialized successfully. No gameplay changes applied.");
    }

    private void registerModules() {
        MODULE_MANAGER.register(new Watermark());
        // Register other modules here as they are implemented.
    }

    public static ModuleManager getModuleManager() {
        return MODULE_MANAGER;
    }

    public static ConfigManager getConfigManager() {
        return configManager;
    }

    public static ClickGui openGui() {
        return new ClickGui(MODULE_MANAGER.getModules());
    }
}
