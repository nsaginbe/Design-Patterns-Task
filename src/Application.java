import adapter.DeliveryService;
import adapter.MealAdapter;
import builder.Director;
import builder.Meal;
import builder.MealBuilder;
import chainofresponsibility.*;
import command.Command;
import command.DiscountCommand;
import command.OrderManager;
import facade.MealType;
import flyweight.MealFactory;
import iterator.Collection;
import iterator.Iterator;
import iterator.OrderList;
import iterator.Receipt;
import mediator.*;
import prototype.Prototype;
import prototype.PrototypeRegistry;
import proxy.Configuration;
import proxy.Feedback;
import proxy.Proxy;
import singleton.Menu;

import java.util.Random;
import java.util.Scanner;

public class Application {
    private static final Scanner sc = new Scanner(System.in);
    private static final PrototypeRegistry registry = new PrototypeRegistry();
    private static final DeliveryService deliveryService = new DeliveryService();

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

        while (!registry.getMealList().isEmpty()){
            System.out.println("Do you wanna edit your meal? (YES/NO)");
            String choice = sc.nextLine();

            if (choice.equals("YES")) editMeal(director, builder);
            else break;
        }

        showAllMeals();

        // Command
        if (Configuration.PASS) {
            premiumBenefits();
        }

        // Iterator
        Collection orderList = new OrderList(registry.getMealList());
        applyDiscount(orderList);
        printReceipt(orderList);


        if (!registry.getMealList().isEmpty()) {
            selectCookingStyle();
            deliverMeal();
        }

        // Proxy
        sendFeedback("Everything is fine!");

        // Mediator
        waiterWork();
    }

    private static void waiterWork() {
        Mediator waiter = new Waiter();

        Client man = new Man("Josh", waiter);
        Client woman = new Woman("Aruzhan", waiter);
        Client commission = new Commission("Nursultan", waiter);

        man.action("gift");
        woman.action("gift");
        commission.action("complaint");
    }

    private static void printReceipt(Collection list) {
        Iterator iterator = list.createIterator();
        int totalCost = Receipt.calculateTotalCost(iterator);

        System.out.println("\nTotal cost: " + totalCost);
    }

    private static void applyDiscount(Collection list) {
        System.out.println("\nCongrats!\nYou won special 20% discount for besh:");

        Iterator iterator = list.createIterator();
        Receipt.applyDiscount(iterator);

        showAllMeals();
    }

    private static void premiumBenefits() {
        int discount = Configuration.DISCOUNT;
        OrderManager sender = new OrderManager();

        System.out.println("Congratulations!\n" + "You have " + discount + " discount left");

        for (int i = 0; i < registry.getMealList().size(); i++) {
            Meal meal = (Meal) registry.getMealList().get(i);

            if (meal.getCost() >= discount) {
                Command discountCommand = new DiscountCommand(meal, discount);
                sender.executeCommand(discountCommand);

                discount = 0;
            }
        }

        showAllMeals();
    }

    private static void sendFeedback(String userFeedback) {
        Feedback feedback = new Feedback(userFeedback);
        Proxy proxy = new Proxy(feedback);

        System.out.println("\nFeedback:\n" + proxy.sendFeedback() + "\n");
    }

    private static void showAllMeals() {
        for (int i = 0; i < registry.getMealList().size(); i++) {
            System.out.println((i + 1) + ". " + registry.getMealList().get(i));
        }
    }

    private static void selectCookingStyle() {
        System.out.println("\nAvailable cooking styles: " + Menu.getInstance().getAllStyles());

        for (int i = 0; i < registry.getMealList().size(); i++) {
            System.out.println("Select cooking style for " + (i + 1) + " meal:");

            String cookingStyle;
            while (true) {
                cookingStyle = sc.nextLine();

                if (!Menu.getInstance().getAllStyles().contains(cookingStyle)) {
                    System.out.println("UNAVAILABLE");
                }
                else break;
            }

            Meal meal = (Meal) registry.getMealList().get(i);
            meal.setCookingStyle(cookingStyle);

            // Now cook!
            meal.cook();
        }

        showAllMeals();
    }

    private static void deliverMeal() {
        System.out.println("\nWhich meal do you want to deliver? (index)");

        int index;
        while (true) {
            try {
                index = Integer.parseInt(sc.nextLine());
            }
            catch (Exception e) {
                System.out.println("UNAVAILABLE");
                continue;
            }

            if (index <= 0 || index > registry.getMealList().size()) {
                System.out.println("UNAVAILABLE");
                continue;
            }
            break;
        }

        System.out.println("Enter delivery address:");
        String address = sc.nextLine();

        deliveryService.setDestinationAddress(address);

        MealAdapter adapter = new MealAdapter((Meal) registry.getMealList().get(index - 1));
        deliveryService.deliver(adapter.getPackedMeal());
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

        // Context (flyweight)
        MealType mealType = MealFactory.getMealType(mainDish, side, drink);
        Meal meal = new Meal(
                new Random().nextInt(100) + 1,
                mealType
        );

        // Chain of responsibility
        System.out.println("Do you wanna add preferences? (YES/NO)");
        String choice = sc.nextLine();

        if (choice.equals("YES")) addPreferences(meal);

        director.constructMeal(builder, meal);
        registry.add(builder.getResult());
    }

    // Chain of responsibility
    private static void addPreferences(Meal meal) {
        System.out.print("""
                        What preferences do you want?
                        1. Vegan
                        2. Extra Nan
                        3. Extra Salt
                        """);

        String sequence;
        while (true) {
            sequence = sc.nextLine();

            boolean allDigit = true;
            for (char c : sequence.toCharArray()) {
                if (!Character.isDigit(c)) {
                    allDigit = false;
                    break;
                }
                else if (c < '1' || c > '3'){
                    allDigit = false;
                    break;
                }
            }

            if (!allDigit) {
                System.out.println("NOT VALID");
                continue;
            }
            break;
        }

        Request request = new EmptyRequest();

        Request last = request;
        for (int i = 0; i < sequence.length(); i++) {
            Request temp;
            if (sequence.charAt(i) == '1'){
                temp = new DietaryRequest();
            }
            else if (sequence.charAt(i) == '2'){
                temp = new IngredientRequest(15);
            }
            else {
                temp = new PreparationRequest(3);
            }

            last.setNext(temp);
            last = temp;
        }

        request.handleRequest(meal);
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

        int cost = newMeal.getCost();
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

        director.constructMeal(builder, cost, mainDish, side, drink);
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
