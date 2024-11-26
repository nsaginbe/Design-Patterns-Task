package state;

import builder.Meal;

public abstract class State {
    protected Meal meal;

    public State(Meal meal) {
        this.meal = meal;
    }

    public abstract void nextState();
    public abstract void prevState();

    public String getCurrentState() {
        return "";
    }
}
