package builder;

// Builder interface
public interface Builder {
    void reset();
    void setCost(int cost);
    void setMainDish(String mainDish);
    void setSide(String side);
    void setDrink(String drink);
}
