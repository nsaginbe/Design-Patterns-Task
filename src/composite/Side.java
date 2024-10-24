package composite;

public class Side implements Component {
    private String name;
    private int cost;

    public Side(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public int calculate() {
        return cost;
    }

    @Override
    public String toString(String prefix) {
        return prefix + "Side [name=" + name + ", cost=" + cost + "]";
    }
}
