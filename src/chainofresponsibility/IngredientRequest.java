package chainofresponsibility;

import builder.Meal;

// Extra nan
public class IngredientRequest extends Request {
    private int nan;

    public IngredientRequest(int nan) {
        this.nan = nan;
    }

    @Override
    public void handleRequest(Meal meal) {
        if (Chef.NAN_AMOUNT >= nan) {
            Chef.NAN_AMOUNT -= nan;

            meal.preferences.add(nan + " nan");
        }
        if (next != null) {
            next.handleRequest(meal);
        }
    }
}
