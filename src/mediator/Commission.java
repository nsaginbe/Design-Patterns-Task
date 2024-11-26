package mediator;

import java.util.Arrays;
import java.util.List;

// Concrete Subscribers
public class Commission extends Client {
    private final List<String> lovedMeals =
            Arrays.asList("pepsi", "pizza", "dessert");

    public Commission(String name) {
        super(name);
        this.name = name;
    }

    public Commission(String name, Mediator mediator) {
        super(name, mediator);

        mediator.setCommission(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void action(String message) {
        mediator.send(this, "complaint", mediator.getMan());
    }

    // Observer
    @Override
    public void update(String meal) {
        if (lovedMeals.contains(meal)) {
            System.out.println("[" + name + "] - Insane!!! I need 100 of those!");
        }
    }
}