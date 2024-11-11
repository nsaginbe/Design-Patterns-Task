package chainofresponsibility;

import builder.Meal;

// Handler interface
public interface RequestHandler {
    void handleRequest(Meal meal);
}
