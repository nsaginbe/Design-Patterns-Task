package builder;

import bridge.Cooking;
import bridge.ToFry;
import bridge.ToGrill;
import bridge.ToSteam;
import facade.MealType;
import prototype.Prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Product
// Unique (from Flyweight)
public class Meal implements Prototype {
    // Chain Of Responsibility
    public List<String> preferences = new ArrayList<>();

    // Bridge
    private Cooking cooking = null;

    // Unique
    private int cost;
    // Repeating
    private MealType mealType = new MealType();

    public Meal() {}

    // Flyweight
    public Meal(int cost, MealType mealType) {
        this.cost = cost;
        this.mealType = mealType;
    }

    // Cloning (from Prototype)
    public Meal (Meal meal) {
        this.cost = meal.cost;
        this.mealType = meal.mealType;
    }

    @Override
    public Prototype clone() {
        return new Meal(this);
    }

    // Setters
    public void setCost(int cost) {
        this.cost = cost;
    }
    public void setMainDish(String mainDish) {
        this.mealType.setMainDish(mainDish);
    }
    public void setSide(String side) {
        this.mealType.setSide(side);
    }
    public void setDrink(String drink) {
        this.mealType.setDrink(drink);
    }
    public void setPreferences(List<String> preferences) {

    }

    // Getters
    public int getCost() {
        return cost;
    }
    public String getMainDish() {
        return mealType.getMainDish();
    }
    public String getSide() {
        return mealType.getSide();
    }
    public String getDrink() {
        return mealType.getDrink();
    }
    public List<String> getPreferences() {
        return preferences;
    }

    // To string method
    public String toString() {
        return "Meal[cost=" + cost +
                ", mainDish=" + mealType.getMainDish() +
                ", side=" + mealType.getSide() +
                ", drink=" + mealType.getDrink() +
                ", cookingStyle=" + (cooking == null ? "" : cooking.getCookingStyle()) +
                ", preferences=" + preferences +
                "]";
    }

    // Bridge
    public void getState() {
        System.out.println("Your meal is " + (cooking.isDone() ? "done" : "not done"));
    }

    public void setCookingStyle(String cookingStyle) {
        switch (cookingStyle) {
            case "grilled" -> cooking = new ToGrill();
            case "fried" -> cooking = new ToFry();
            case "steamed" -> cooking = new ToSteam();
        }
    }

    public void cook() {
        cooking.cook();
    }
}
