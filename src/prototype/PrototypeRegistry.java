package prototype;

import memento.OrderMemento;

import java.util.ArrayList;
import java.util.List;

public class PrototypeRegistry {
    private List<Prototype> mealList = new ArrayList<>();
    private int totalPrice = 0;

    public List<Prototype> getMealList() {
        return mealList;
    }

    public void add(Prototype result) {
        mealList.add(result);
        totalPrice += result.getCost();
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

    // Originator
    public OrderMemento snapshot() {
        return new OrderMemento(mealList, totalPrice);
    }

    public void restore(OrderMemento memento) {
        mealList = (List<Prototype>) memento.getMealList();
        totalPrice = memento.getTotalPrice();
    }
}
