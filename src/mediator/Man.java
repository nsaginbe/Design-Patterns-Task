package mediator;

import java.util.Arrays;
import java.util.List;

// Concrete Subscribers
public class Man extends Client {
    private final List<String> lovedMeals =
            Arrays.asList("ice cream", "pepsi", "mandarin");

    public Man(String name) {
        super(name);
        this.name = name;
    }

    public Man(String name, Mediator mediator) {
        super(name, mediator);

        mediator.setMan(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void action(String message) {
        mediator.send(this, "gift", mediator.getWoman());
    }

    // Observer
    @Override
    public void update(String meal) {
        if (lovedMeals.contains(meal)) {
            System.out.println("[" + name + "] - Oww, that's sick! I buy it!");
        }
    }
}
