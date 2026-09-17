package meteorvisuals.gui;

import java.awt.Color;

public final class ThemeManager {
    private static int backgroundColor = new Color(18, 18, 24, 220).getRGB();
    private static int accentColor = new Color(79, 155, 255).getRGB();
    private static int textColor = new Color(240, 240, 240).getRGB();

    public static void initializeDefaults() {
        backgroundColor = new Color(18, 18, 24, 220).getRGB();
        accentColor = new Color(79, 155, 255).getRGB();
        textColor = new Color(240, 240, 240).getRGB();
    }

    public static int getBackgroundColor() {
        return backgroundColor;
    }

    public static int getAccentColor() {
        return accentColor;
    }

    public static int getTextColor() {
        return textColor;
    }
}
