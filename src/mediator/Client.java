package mediator;

// Component
public abstract class Client {
    protected String name;
    protected Mediator mediator;

    public Client(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public abstract String getName();
    public abstract void action(String message);
}
