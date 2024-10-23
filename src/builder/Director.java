package builder;

import prototype.Prototype;

// Director (прораб)
public class Director {

    public void constructMeal(Builder builder, String mainDish, String side, String drink) {
        builder.reset();

        builder.setMainDish(mainDish);
        builder.setSide(side);
        builder.setDrink(drink);
    }

    public void constructMeal(MealBuilder builder, Prototype meal) {
        builder.reset();

        builder.setMainDish(meal.getMainDish());
        builder.setSide(meal.getSide());
        builder.setDrink(meal.getDrink());
    }
}
