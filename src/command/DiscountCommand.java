package command;

import builder.Meal;

public class DiscountCommand implements Command {
    private Meal meal;
    private int discount;
    private int previousCost;

    public DiscountCommand(Meal meal, int discount) {
        this.meal = meal;
        this.discount = discount;
        this.previousCost = meal.getCost();
    }

    @Override
    public void execute() {
        meal.setCost(previousCost - discount);
    }
    @Override
    public void undo() {
        meal.setCost(previousCost);
    }
}
