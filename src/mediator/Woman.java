package mediator;

import java.util.Arrays;
import java.util.List;

// Concrete Subscribers
public class Woman extends Client {
    private final List<String> lovedMeals =
            Arrays.asList("steak", "rice", "burger");

    public Woman(String name) {
        super(name);
        this.name = name;
    }

    public Woman(String name, Mediator mediator) {
        super(name, mediator);

        mediator.setWoman(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void action(String message) {
        mediator.send(this, "gift", mediator.getCommission());
    }

    // Observer
    @Override
    public void update(String meal) {
        if (lovedMeals.contains(meal)) {
            System.out.println("[" + name + "] - Cool! Where to buy one?");
        }
    }
}
