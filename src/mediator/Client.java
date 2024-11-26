package mediator;

import observer.Observer;

// Component
// Subscriber
public abstract class Client implements Observer {
    protected String name;
    protected Mediator mediator;

    public Client(String name) {
        this.name = name;
    }

    public Client(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public abstract String getName();
    public abstract void action(String message);

    // Observer
    public abstract void update(String meal);
}
