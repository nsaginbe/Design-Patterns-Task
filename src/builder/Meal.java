package builder;

import bridge.Cooking;
import bridge.ToFry;
import bridge.ToGrill;
import bridge.ToSteam;
import prototype.Prototype;

// Product
public class Meal implements Prototype {
    // Bridge
    private Cooking cooking = null;

    private String mainDish;
    private String side;
    private String drink;

    public Meal() { }
    public Meal(Meal meal) {
        this.mainDish = meal.mainDish;
        this.side = meal.side;
        this.drink = meal.drink;
    }

    public void setMainDish(String mainDish) {
        this.mainDish = mainDish;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String toString() {
        return "Meal[mainDish=" + mainDish +
                ", side=" + side +
                ", drink=" + drink +
                ", cookingStyle=" + (cooking == null ? "" : cooking.getCookingStyle()) +
                "]";
    }

    @Override
    public Prototype clone() {
        return new Meal(this);
    }

    @Override
    public String getMainDish() {
        return mainDish;
    }

    @Override
    public String getSide() {
        return side;
    }

    @Override
    public String getDrink() {
        return drink;
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
