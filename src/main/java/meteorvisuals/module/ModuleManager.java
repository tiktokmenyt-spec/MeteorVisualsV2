package meteorvisuals.module;

import meteorvisuals.config.ConfigManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.LinkedHashMap;

public final class ModuleManager {
    private static final ModuleManager INSTANCE = new ModuleManager();

    private final Map<String, Module> modules = new LinkedHashMap<>();

    private ModuleManager() {
    }

    public static ModuleManager getInstance() {
        return INSTANCE;
    }

    public void register(Module module) {
        modules.put(module.getName().toLowerCase(Locale.ROOT), module);
    }

    public Module getByName(String name) {
        return modules.get(name.toLowerCase(Locale.ROOT));
    }

    public List<Module> getModules() {
        return Collections.unmodifiableList(new ArrayList<>(modules.values()));
    }

    public void setEnabled(String name, boolean enabled) {
        Module module = getByName(name);
        if (module != null) {
            module.setEnabled(enabled);
        }
    }

    public void toggle(String name) {
        Module module = getByName(name);
        if (module != null) {
            module.toggle();
        }
    }

    public void saveToConfig(ConfigManager configManager) {
        configManager.saveModules(getModules());
    }
}
