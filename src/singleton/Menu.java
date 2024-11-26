package singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private static Menu instance = null;
    private final List<String> allMainDishes;
    private final List<String> allSides;
    private final List<String> allDrinks;
    private final List<String> allStyles;

    private Menu() {
        allMainDishes = new ArrayList<>(Arrays.asList("pasta", "soup", "besh"));
        allSides = new ArrayList<>(Arrays.asList("salad", "fries", "nanmenmai"));
        allDrinks = new ArrayList<>(Arrays.asList("cola", "water", "qymyz"));
        allStyles = new ArrayList<>(Arrays.asList("grilled", "fried", "steamed"));
    }

    public static synchronized Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    public List<String> getAllMainDishes() {
        return allMainDishes;
    }
    public List<String> getAllSides() {
        return allSides;
    }
    public List<String> getAllDrinks() {
        return allDrinks;
    }
    public List<String> getAllStyles() {
        return allStyles;
    }

    public void addMainDish(String mainDish) {
        allMainDishes.add(mainDish);
    }
    public void addSide(String side) {
        allSides.add(side);
    }
    public void addDrink(String drink) {
        allDrinks.add(drink);
    }
}
