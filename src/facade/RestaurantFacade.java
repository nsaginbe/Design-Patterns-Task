package facade;

import singleton.Menu;

import java.util.ArrayList;
import java.util.List;

public class RestaurantFacade {
    private final Menu menu = Menu.getInstance();
    private final List<MealType> orderedMeals = new ArrayList<>();

    public void viewMenu() {
        System.out.println("Menu:");
        System.out.println(
                "- main dishes: " + menu.getAllMainDishes() + "\n" +
                "- sides: " + menu.getAllSides() + "\n" +
                "- drinks: " + menu.getAllDrinks() + "\n");
    }


    public void orderMeal(String mainDish, String side, String drink) {
        MealType meal = new MealType(mainDish, side, drink);

        if (!checkAvailability(mainDish, side, drink)) {
            System.out.println("UNAVAILABLE -> " + meal);
            return;
        }
        orderedMeals.add(meal);
    }

    public void showMeals() {
        System.out.println("\n" + "Ordered meals:");
        for (int i = 0; i < orderedMeals.size(); i++) {
            System.out.println((i + 1) + " - " + orderedMeals.get(i));
        }
        System.out.println();
    }

    public void editMeal(int position, String option, String value) {
        if (position < 1 || position > orderedMeals.size()) {
            System.out.println("INVALID POSITION -> " + position);
            return;
        }

        // Check availability of each
        switch (option) {
            case "mainDish" -> {
                orderedMeals.get(position - 1).setMainDish(value);
            }
            case "side" -> {
                orderedMeals.get(position - 1).setSide(value);
            }
            case "drink" -> {
                orderedMeals.get(position - 1).setDrink(value);
            }
            default -> {
                System.out.println("INVALID OPTION -> " + option);
                return;
            }
        }
    }

    private boolean checkAvailability(String mainDish, String side, String drink) {
        if (!menu.getAllMainDishes().contains(mainDish) ||
                !menu.getAllSides().contains(side) ||
                !menu.getAllDrinks().contains(drink)) {
            return false;
        }
        return true;
    }
}
