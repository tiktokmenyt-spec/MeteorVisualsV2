package meteorvisuals.modules.hud;

import meteorvisuals.module.Category;
import meteorvisuals.module.Module;
import meteorvisuals.setting.BooleanSetting;
import meteorvisuals.setting.ColorSetting;
import meteorvisuals.setting.SliderSetting;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class Watermark extends Module {
    private final BooleanSetting enabledSetting = new BooleanSetting("Enabled", true);
    private final ColorSetting textColor = new ColorSetting("Text Color", 0xFFFFFFFF);
    private final SliderSetting<Float> scale = new SliderSetting<>("Scale", 1.0f, 0.5f, 2.5f, 0.1f);

    public Watermark() {
        super("Watermark", Category.HUD, "NONE");
        registerSettings(enabledSetting, textColor, scale);
    }

    @Override
    public void renderHud(DrawContext context, float tickDelta) {
        if (!enabled || !enabledSetting.getValue()) {
            return;
        }

        MinecraftClient client = MinecraftClient.getInstance();
        if (client == null || client.textRenderer == null) {
            return;
        }

        String text = "MeteorVisuals v0.1.0";
        int x = 8;
        int y = 8;
        int color = textColor.getValue();

        context.drawTextWithShadow(client.textRenderer, Text.literal(text), x, y, color);
    }
}
