package prototype;

public interface Prototype {
    Prototype clone();

    int getCost();
    String getMainDish();
    String getSide();
    String getDrink();
}
