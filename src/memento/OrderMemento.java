package memento;

import builder.Meal;

import java.util.ArrayList;
import java.util.List;

// Memento
public class OrderMemento {
    private final List<? super Meal> mealList;
    private final int totalPrice;

    public OrderMemento(List<? super Meal> mealList, int totalPrice) {
        // Not the same refs
        this.mealList = new ArrayList<>(mealList);
        this.totalPrice = totalPrice;
    }

    public List<? super Meal> getMealList() {
        return mealList;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
