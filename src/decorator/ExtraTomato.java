package decorator;

import composite.Component;

public class ExtraTomato extends BaseDecorator {
    private int cost;
    private String prefixMeal;

    public ExtraTomato(Component component, int cost) {
        super(component);
        this.cost = cost;
        this.prefixMeal = component.toString("");
    }

    @Override
    public int calculate() {
        return super.calculate() + cost;
    }

    @Override
    public String toString(String prefix) {
        return prefix + prefixMeal + " + Tomato [cost=" + cost + "]";
    }
}
