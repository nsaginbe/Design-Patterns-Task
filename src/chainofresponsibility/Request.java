package chainofresponsibility;

import builder.Meal;

public abstract class Request implements RequestHandler {
    protected Request next;

    public void setNext(Request next) {
        this.next = next;
    }

    @Override
    public abstract void handleRequest(Meal meal);
}
