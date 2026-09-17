package meteorvisuals.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import meteorvisuals.module.Module;
import meteorvisuals.setting.Setting;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigManager {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final Path configDirectory;

    public ConfigManager(Path configDirectory) {
        this.configDirectory = configDirectory;
        try {
            Files.createDirectories(configDirectory);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to create MeteorVisuals config directory", e);
        }
    }

    public Path getConfigDirectory() {
        return configDirectory;
    }

    public void saveModules(List<Module> modules) {
        Map<String, Object> root = new HashMap<>();
        for (Module module : modules) {
            Map<String, Object> moduleState = new HashMap<>();
            moduleState.put("enabled", module.isEnabled());
            Map<String, Object> settings = new HashMap<>();
            for (Setting<?> setting : module.getSettings()) {
                settings.put(setting.getName(), setting.getValue());
            }
            moduleState.put("settings", settings);
            root.put(module.getName(), moduleState);
        }

        Path file = configDirectory.resolve("modules.json");
        try {
            Files.writeString(file, gson.toJson(root), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to save module configuration", e);
        }
    }

    public void loadModules(List<Module> modules) {
        Path file = configDirectory.resolve("modules.json");
        if (!Files.exists(file)) {
            return;
        }

        try {
            String content = Files.readString(file, StandardCharsets.UTF_8);
            if (content == null || content.isBlank()) {
                return;
            }
            Map<?, ?> root = gson.fromJson(content, Map.class);
            if (root == null) {
                return;
            }

            for (Module module : modules) {
                Map<?, ?> state = (Map<?, ?>) root.get(module.getName());
                if (state == null) {
                    continue;
                }
                Object enabledValue = state.get("enabled");
                if (enabledValue instanceof Boolean enabled) {
                    module.setEnabled(enabled);
                }
                Map<?, ?> settings = (Map<?, ?>) state.get("settings");
                if (settings != null) {
                    for (Setting<?> setting : module.getSettings()) {
                        Object value = settings.get(setting.getName());
                        if (value != null) {
                            setting.setValue(value);
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load module configuration", e);
        }
    }
}
