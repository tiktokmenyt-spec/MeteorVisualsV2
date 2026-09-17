package meteorvisuals.setting;

public class SliderSetting<T extends Number> extends Setting<T> {
    private final double min;
    private final double max;
    private final double step;

    public SliderSetting(String name, T defaultValue, double min, double max, double step) {
        super(name, defaultValue);
        this.min = min;
        this.max = max;
        this.step = step;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getStep() {
        return step;
    }
}
