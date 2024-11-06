package facade;

// Repeating (from Flyweight)
public class MealType {
    private String mainDish;
    private String side;
    private String drink;

    public MealType() {}
    public MealType(String mainDish, String side, String drink) {
        this.mainDish = mainDish;
        this.side = side;
        this.drink = drink;
    }

    public String getMainDish() {
        return mainDish;
    }
    public void setMainDish(String mainDish) {
        this.mainDish = mainDish;
    }
    public String getSide() {
        return side;
    }
    public void setSide(String side) {
        this.side = side;
    }
    public String getDrink() {
        return drink;
    }
    public void setDrink(String drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "Meal[" +
                "mainDish=" + mainDish +
                ", side=" + side +
                ", drink=" + drink +
                "]";
    }
}
