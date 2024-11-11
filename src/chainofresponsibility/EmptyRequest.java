package chainofresponsibility;

import builder.Meal;

public class EmptyRequest extends Request {
    @Override
    public void handleRequest(Meal meal) {
        if (next != null) {
            next.handleRequest(meal);
        }
    }
}
