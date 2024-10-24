package decorator;

import composite.Component;

public class ExtraCheese extends BaseDecorator {
    private int cost;
    private String prefixMeal;

    public ExtraCheese(Component component, int cost) {
        super(component);
        this.cost = cost;
        prefixMeal = component.toString("");
    }

    @Override
    public int calculate() {
        return super.calculate() + cost;
    }

    @Override
    public String toString(String prefix) {
        return prefix + prefixMeal + " + Cheese [cost=" + cost + "]";
    }
}
