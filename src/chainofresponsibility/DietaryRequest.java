package chainofresponsibility;

import builder.Meal;

// Vegan
public class DietaryRequest extends Request {

    @Override
    public void handleRequest(Meal meal) {
        if (Chef.MOOD.equals("good")) {
            meal.preferences.add("vegan");
        }
        if (next != null) {
            next.handleRequest(meal);
        }
    }
}
