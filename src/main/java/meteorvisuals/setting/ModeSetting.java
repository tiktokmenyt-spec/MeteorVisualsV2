package meteorvisuals.setting;

import java.util.Arrays;
import java.util.List;

public class ModeSetting<T> extends Setting<T> {
    private final List<T> values;

    public ModeSetting(String name, T defaultValue, T... values) {
        super(name, defaultValue);
        this.values = Arrays.asList(values);
    }

    public List<T> getValues() {
        return values;
    }
}
