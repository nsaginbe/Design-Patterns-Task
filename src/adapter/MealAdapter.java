package adapter;

import builder.Meal;

public class MealAdapter {
    private Meal meal;

    public MealAdapter(Meal meal) {
        this.meal = meal;
    }

    public PackedMeal getPackedMeal() {
        return new PackedMeal(
                true,
                meal.getMainDish(),
                meal.getSide(),
                meal.getDrink()
        );
    }

    public Meal getMeal() {
        return meal;
    }
    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}
