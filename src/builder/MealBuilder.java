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

    @Override
    public void setMainDish(String mainDish) {
        meal.setMainDish(mainDish);
    }

    @Override
    public void setSide(String side) {
        meal.setSide(side);
    }

    @Override
    public void setDrink(String drink) {
        meal.setDrink(drink);
    }

    public Meal getResult(){
        Meal temp = meal;
        reset();
        return temp;
    }
}
