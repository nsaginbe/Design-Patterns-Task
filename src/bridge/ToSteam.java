package bridge;

public class ToSteam implements Cooking {
    private boolean state = false;
    private String cookingStyle;

    @Override
    public boolean isDone() {
        return state;
    }

    @Override
    public void cook() {
        state = true;
        cookingStyle = "steamed";
    }

    @Override
    public String getCookingStyle() {
        return cookingStyle;
    }
}
