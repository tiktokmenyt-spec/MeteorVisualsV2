package meteorvisuals.gui;

import meteorvisuals.module.Module;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.List;

public class ClickGui extends Screen {
    private final List<Module> modules;

    public ClickGui(List<Module> modules) {
        super(Text.literal("MeteorVisuals"));
        this.modules = modules;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);

        int x = 16;
        int y = 20;
        int columnWidth = 150;
        int rowHeight = 18;

        context.drawCenteredTextWithShadow(this.textRenderer, Text.literal("MeteorVisuals"), width / 2, 8, 0xFFFFFFFF);

        for (Module module : modules) {
            context.fill(x, y, x + columnWidth, y + rowHeight, module.isEnabled() ? 0xFF4F9BFF : 0xFF2C2C2C);
            context.drawTextWithShadow(this.textRenderer, Text.literal(module.getName()), x + 8, y + 5, 0xFFFFFFFF);
            y += rowHeight + 4;
            if (y > height - 50) {
                y = 20;
                x += columnWidth + 16;
            }
        }
    }
}
