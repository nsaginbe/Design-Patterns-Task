package prototype;

public interface Prototype {
    Prototype clone();
    String getMainDish();
    String getSide();
    String getDrink();
}
