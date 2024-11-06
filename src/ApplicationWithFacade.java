import facade.RestaurantFacade;

public class ApplicationWithFacade {
    private static final RestaurantFacade facade = new RestaurantFacade();

    public static void main(String[] args) {
        facade.viewMenu();

        facade.orderMeal(
                "besh",
                "nanmenmai",
                "qymyz");

        facade.orderMeal(
                "soup",
                "salad",
                "cola");

        facade.orderMeal(
                "pasta",
                "fries",
                "pepsi");

        facade.showMeals();

        facade.editMeal(1, "side", "fries");
        facade.editMeal(4, "drink", "water");
        facade.editMeal(2, "sauce", "cheese");

        facade.showMeals();
    }
}