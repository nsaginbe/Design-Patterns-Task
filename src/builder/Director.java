package builder;

import prototype.Prototype;

// Director (прораб)
public class Director {

    public void constructMeal(Builder builder, int cost, String mainDish, String side, String drink) {
        builder.reset();

        builder.setCost(cost);
        builder.setMainDish(mainDish);
        builder.setSide(side);
        builder.setDrink(drink);
    }

    public void constructMeal(MealBuilder builder, Prototype meal) {
        builder.reset();

        builder.setCost(meal.getCost());
        builder.setMainDish(meal.getMainDish());
        builder.setSide(meal.getSide());
        builder.setDrink(meal.getDrink());
    }
}
