package prototype;

import java.util.List;

public interface Prototype {
    Prototype clone();

    int getCost();
    String getMainDish();
    String getSide();
    String getDrink();
    List<String> getPreferences();

    void setCost(int cost);
    void setMainDish(String mainDish);
    void setSide(String side);
    void setDrink(String drink);
    void setPreferences(List<String> preferences);
}