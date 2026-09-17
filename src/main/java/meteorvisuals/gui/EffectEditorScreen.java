package meteorvisuals.gui;

import meteorvisuals.effects.EffectPreset;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class EffectEditorScreen extends Screen {
    private final List<EffectPreset> presets = new ArrayList<>();
    private int selectedIndex = 0;

    public EffectEditorScreen() {
        super(Text.literal("Effect Editor"));
    }

    public void setPresets(List<EffectPreset> presets) {
        this.presets.clear();
        this.presets.addAll(presets);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);

        int leftX = 20;
        int rightX = width / 2 + 10;
        int topY = 20;
        int panelWidth = width / 2 - 40;
        int panelHeight = height - 40;

        context.fill(leftX, topY, leftX + panelWidth, topY + panelHeight, 0xFF1E1E22);
        context.fill(rightX, topY, rightX + panelWidth, topY + panelHeight, 0xFF23252C);

        context.drawCenteredTextWithShadow(this.textRenderer, Text.literal("Preset List"), leftX + panelWidth / 2, topY + 12, 0xFFFFFFFF);
        context.drawCenteredTextWithShadow(this.textRenderer, Text.literal("Editor"), rightX + panelWidth / 2, topY + 12, 0xFFFFFFFF);

        if (!presets.isEmpty()) {
            EffectPreset selected = presets.get(selectedIndex);
            context.drawTextWithShadow(this.textRenderer, Text.literal(selected.getName()), rightX + 20, topY + 48, 0xFFFFFFFF);
            context.drawTextWithShadow(this.textRenderer, Text.literal("Shape: " + selected.getParticleShape()), rightX + 20, topY + 70, 0xFFB1B9FF);
            context.drawTextWithShadow(this.textRenderer, Text.literal("Pattern: " + selected.getSpawnPattern()), rightX + 20, topY + 90, 0xFFB1B9FF);
            context.drawTextWithShadow(this.textRenderer, Text.literal("Trigger: " + selected.getTriggerEvent()), rightX + 20, topY + 110, 0xFFB1B9FF);
        }
    }
}
