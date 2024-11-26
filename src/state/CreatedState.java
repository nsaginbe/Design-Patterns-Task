package state;

import builder.Meal;

public class CreatedState extends State {

    public CreatedState(Meal meal) {
        super(meal);
    }

    @Override
    public void nextState() {
        meal.changeState(new BeingPreparedState(meal));
    }

    @Override
    public void prevState() {
    }

    @Override
    public String getCurrentState() {
        return super.getCurrentState() + "created";
    }
}
