package composite;

public class MainDish implements Component {
    private String name;
    private int cost;

    public MainDish(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public int calculate() {
        return cost;
    }

    @Override
    public String toString(String prefix) {
        return prefix + "MainDish [name=" + name + ", cost=" + cost + "]";
    }
}
