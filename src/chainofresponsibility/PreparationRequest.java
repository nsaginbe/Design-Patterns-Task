package chainofresponsibility;

import builder.Meal;

// Extra salt
public class PreparationRequest extends Request {
    private int salt;

    public PreparationRequest(int salt) {
        this.salt = salt;
    }

    @Override
    public void handleRequest(Meal meal) {
        if (Chef.SALT_AMOUNT >= salt) {
            Chef.SALT_AMOUNT -= salt;

            meal.preferences.add(salt + " salt");
        }
        if (next != null) {
            next.handleRequest(meal);
        }
    }
}
