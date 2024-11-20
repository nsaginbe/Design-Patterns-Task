package iterator;

import builder.Meal;

public class Receipt {

    // Discount 20% only for besh!
    public static void applyDiscount(Iterator iterator) {
        while (iterator.hasNext()) {
            Meal meal = iterator.next();

            if (meal.getMainDish().equals("besh")){
                int cost = meal.getCost();
                cost = (int)(cost * 0.8);

                meal.setCost(cost);
            }
        }
    }

    // Total cost
    public static int calculateTotalCost(Iterator iterator) {
        int sum = 0;
        while (iterator.hasNext()) {
            Meal meal = iterator.next();

            if (meal.getCost() > 0){
                sum += meal.getCost();
            }
        }
        return sum;
    }
}
