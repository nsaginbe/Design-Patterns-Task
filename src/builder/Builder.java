package builder;

import java.util.List;

// Builder interface
public interface Builder {
    void reset();
    void setCost(int cost);
    void setMainDish(String mainDish);
    void setSide(String side);
    void setDrink(String drink);
    void setPreferences(List<String> preferences);
}
