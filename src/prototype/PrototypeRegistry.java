package prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypeRegistry {
    private final List<Prototype> mealList = new ArrayList<>();

    public List<Prototype> getMealList() {
        return mealList;
    }

    public void add(Prototype result) {
        mealList.add(result);
    }

    public Prototype getByMainDish(String mainDish) {
        for (Prototype meal : mealList) {
            if (meal.getMainDish().equals(mainDish)) {
                return meal.clone();
            }
        }
        return null;
    }

    public Prototype getBySide(String side) {
        for (Prototype meal : mealList) {
            if (meal.getSide().equals(side)) {
                return meal.clone();
            }
        }
        return null;
    }

    public Prototype getByDrink(String drink) {
        for (Prototype meal : mealList) {
            if (meal.getDrink().equals(drink)) {
                return meal.clone();
            }
        }
        return null;
    }
}
