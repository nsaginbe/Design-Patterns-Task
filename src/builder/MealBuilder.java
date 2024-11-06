package builder;

// Concrete Builder
public class MealBuilder implements Builder {
    private Meal meal;

    public MealBuilder(){
        reset();
    }

    @Override
    public void reset() {
        meal = new Meal();
    }

    public void setCost(int cost) {
        meal.setCost(cost);
    }
    public void setMainDish(String mainDish) {
        meal.setMainDish(mainDish);
    }
    public void setSide(String side) {
        meal.setSide(side);
    }
    public void setDrink(String drink) {
        meal.setDrink(drink);
    }

    public Meal getResult(){
        Meal temp = meal;
        reset();
        return temp;
    }
}
