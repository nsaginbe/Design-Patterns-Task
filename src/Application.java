import java.util.Scanner;

public class Application {
    private static final Scanner sc = new Scanner(System.in);
    private static final PrototypeRegistry registry = new PrototypeRegistry();

    public static void main(String[] args) {
        System.out.println("Welcome!");
        showMenu();

        Director director = new Director();
        MealBuilder builder = new MealBuilder();

        while (true){
            System.out.println("Do you wanna add meal? (YES/NO)");
            String choice = sc.nextLine();

            if (choice.equals("YES")) addMeal(director, builder);
            else break;
        }

        while (true){
            System.out.println("Do you wanna edit your meal? (YES/NO)");
            String choice = sc.nextLine();

            if (choice.equals("YES")) editMeal(director, builder);
            else break;
        }

        for (Prototype meal : registry.getMealList()) {
            System.out.println(meal);
        }
    }

    private static void showMenu() {
        System.out.println("Available main dishes: " + Menu.getInstance().getAllMainDishes());

        System.out.println("Available sides: " + Menu.getInstance().getAllSides());

        System.out.println("Available drinks: " + Menu.getInstance().getAllDrinks());
    }

    private static void addMeal(Director director, MealBuilder builder) {
        String mainDish = selectMainDish();
        String side = selectSide();
        String drink = selectDrink();

        director.constructMeal(builder, mainDish, side, drink);
        registry.add(builder.getResult());
    }

    private static String selectMainDish() {
        System.out.println("Enter main dish name:");
        while (true){
            String mainDish = sc.nextLine();
            if (!Menu.getInstance().getAllMainDishes().contains(mainDish)) {
                System.out.println("UNAVAILABLE");
            }
            else return mainDish;
        }
    }
    private static String selectSide() {
        System.out.println("Enter side name:");
        while (true){
            String side = sc.nextLine();
            if (!Menu.getInstance().getAllSides().contains(side)) {
                System.out.println("UNAVAILABLE");
            }
            else return side;
        }
    }
    private static String selectDrink() {
        System.out.println("Enter drink name:");
        while (true){
            String drink = sc.nextLine();
            if (!Menu.getInstance().getAllDrinks().contains(drink)) {
                System.out.println("UNAVAILABLE");
            }
            else return drink;
        }
    }

    private static void editMeal(Director director, MealBuilder builder) {
        Prototype newMeal = searchMeal();

        String mainDish = newMeal.getMainDish();
        String side = newMeal.getSide();
        String drink = newMeal.getDrink();

        while (true){
            System.out.println("Do you wanna edit main dish? (YES/NO)");
            String choice = sc.nextLine();

            if (choice.equals("NO")) break;
            else if (choice.equals("YES")) {
                mainDish = selectMainDish();
                break;
            }
        }

        while (true){
            System.out.println("Do you wanna edit side? (YES/NO)");
            String choice = sc.nextLine();

            if (choice.equals("NO")) break;
            else if (choice.equals("YES")) {
                side = selectSide();
                break;
            }
        }

        while (true){
            System.out.println("Do you wanna edit drink? (YES/NO)");
            String choice = sc.nextLine();

            if (choice.equals("NO")) break;
            else if (choice.equals("YES")) {
                drink = selectDrink();
                break;
            }
        }

        director.constructMeal(builder, mainDish, side, drink);
        registry.add(builder.getResult());
    }

    private static Prototype searchMeal() {
        Prototype newMeal = null;
        while (true) {
            System.out.println("Search by: [mainDish, side, drink]");
            String getBy = sc.nextLine();

            boolean available = true;
            switch (getBy) {
                case "mainDish" -> newMeal = searchByMainDish();
                case "side" -> newMeal = searchBySide();
                case "drink" -> newMeal = searchByDrink();
                default -> available = false;
            }

            if (!available) System.out.println("UNAVAILABLE");

            if (newMeal == null) System.out.println("NOT FOUND");
            else break;
        }

        System.out.println("FOUND\n" + newMeal);

        return newMeal;
    }

    private static Prototype searchByMainDish() {
        System.out.println("Enter main dish name to be searched:");
        String mainDish = sc.nextLine();

        return registry.getByMainDish(mainDish);
    }
    private static Prototype searchBySide() {
        System.out.println("Enter side name to be searched:");
        String side = sc.nextLine();

        return registry.getBySide(side);
    }
    private static Prototype searchByDrink() {
        System.out.println("Enter drink name to be searched:");
        String drink = sc.nextLine();

        return registry.getByDrink(drink);
    }
}
