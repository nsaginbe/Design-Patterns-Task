import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private static Menu instance = null;
    private final String[] allMainDishes;
    private final String[] allSides;
    private final String[] allDrinks;

    private Menu() {
        allMainDishes = new String[]{"pasta", "soup", "besh"};
        allSides = new String[]{"salad", "fries", "nanmenmai"};
        allDrinks = new String[]{"cola", "water", "qymyz"};
    }

    public static synchronized Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    public List<String> getAllMainDishes() {
        return new ArrayList<>(Arrays.asList(allMainDishes));
    }
    public List<String> getAllSides() {
        return new ArrayList<>(Arrays.asList(allSides));
    }
    public List<String> getAllDrinks() {
        return new ArrayList<>(Arrays.asList(allDrinks));
    }
}
