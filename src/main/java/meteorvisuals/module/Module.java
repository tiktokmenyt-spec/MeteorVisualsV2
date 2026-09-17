package meteorvisuals.module;

import meteorvisuals.setting.Setting;
import net.minecraft.client.gui.DrawContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Module {
    protected final String name;
    protected final Category category;
    protected final String keybind;
    protected boolean enabled;
    protected final List<Setting<?>> settings = new ArrayList<>();

    protected Module(String name, Category category, String keybind) {
        this.name = name;
        this.category = category;
        this.keybind = keybind;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public String getKeybind() {
        return keybind;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public void toggle() {
        setEnabled(!enabled);
    }

    public List<Setting<?>> getSettings() {
        return Collections.unmodifiableList(settings);
    }

    protected void registerSettings(Setting<?>... values) {
        Collections.addAll(settings, values);
    }

    public void renderHud(DrawContext context, float tickDelta) {
        // Optional per-module HUD rendering hook.
    }

    public void update() {
        // Optional tick-based logic.
    }

    protected void onEnable() {
        // Override in concrete modules if needed.
    }

    protected void onDisable() {
        // Override in concrete modules if needed.
    }
}
