package state;

import builder.Meal;

public class BeingPreparedState extends State {

    public BeingPreparedState(Meal meal) {
        super(meal);
    }

    @Override
    public void nextState() {
        meal.changeState(new CompletedState(meal));
    }

    @Override
    public void prevState() {
        meal.changeState(new CreatedState(meal));
    }

    @Override
    public String getCurrentState() {
        return super.getCurrentState() + "being prepared";
    }
}
