package composite;

public class Drink implements Component {
    private String name;
    private int cost;

    public Drink(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public int calculate() {
        return cost;
    }

    @Override
    public String toString(String prefix) {
        return prefix + "Drink [name=" + name + ", cost=" + cost + "]";
    }
}
