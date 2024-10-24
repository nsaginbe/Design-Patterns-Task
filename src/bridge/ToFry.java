package bridge;

public class ToFry implements Cooking {
    private boolean state = false;
    private String cookingStyle;

    @Override
    public boolean isDone() {
        return state;
    }

    @Override
    public void cook() {
        state = true;
        cookingStyle = "fried";
    }

    @Override
    public String getCookingStyle() {
        return cookingStyle;
    }
}
