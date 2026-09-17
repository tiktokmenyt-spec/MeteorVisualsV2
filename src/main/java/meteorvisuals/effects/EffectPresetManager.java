package meteorvisuals.effects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class EffectPresetManager {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private final Path presetDirectory;
    private final List<EffectPreset> presets = new ArrayList<>();

    public EffectPresetManager(Path presetDirectory) {
        this.presetDirectory = presetDirectory;
        createDirectoryIfNeeded();
        presets.add(EffectPreset.createDefault());
    }

    public List<EffectPreset> getPresets() {
        return presets;
    }

    public void addPreset(EffectPreset preset) {
        presets.add(preset);
    }

    public void savePreset(EffectPreset preset) {
        Path file = presetDirectory.resolve(preset.getId() + ".json");
        try {
            Files.writeString(file, GSON.toJson(preset), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to save preset: " + preset.getName(), e);
        }
    }

    public void loadFromDisk() {
        if (!Files.exists(presetDirectory)) {
            return;
        }

        try {
            List<Path> files = Files.list(presetDirectory)
                    .filter(path -> path.getFileName().toString().endsWith(".json"))
                    .toList();

            for (Path file : files) {
                String json = Files.readString(file, StandardCharsets.UTF_8);
                EffectPreset preset = GSON.fromJson(json, EffectPreset.class);
                if (preset != null) {
                    presets.add(preset);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load presets from disk", e);
        }
    }

    private void createDirectoryIfNeeded() {
        try {
            Files.createDirectories(presetDirectory);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to create preset directory", e);
        }
    }
}
