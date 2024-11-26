package state;

import builder.Meal;

public class CompletedState extends State {
    public CompletedState(Meal meal) {
        super(meal);
    }

    @Override
    public void nextState() {
    }

    @Override
    public void prevState() {
        meal.changeState(new BeingPreparedState(meal));
    }

    @Override
    public String getCurrentState() {
        return super.getCurrentState() + "completed";
    }
}
