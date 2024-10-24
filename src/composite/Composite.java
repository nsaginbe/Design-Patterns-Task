package composite;

import java.util.ArrayList;
import java.util.List;

// Combo
public class Composite implements Component {
    private List<Component> components;

    public Composite() {
        components = new ArrayList<>();
    }

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public int calculate() {
        int sum = 0;
        for (Component component : components) {
            sum += component.calculate();
        }
        return sum;
    }

    @Override
    public String toString(String prefix) {
        String s = prefix + "Combo\n";

        s += prefix + "[\n";
        for (Component component : components) {
            s += component.toString(prefix + "  ") + "\n";
        }
        s += prefix + "]";
        return s;
    }
}
