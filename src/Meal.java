// Product
public class Meal implements Prototype {
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
        return "Meal[mainDish=" + mainDish + ", side=" + side + ", drink=" + drink + "]";
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
}
