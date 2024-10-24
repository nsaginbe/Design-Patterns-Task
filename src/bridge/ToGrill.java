package bridge;

public class ToGrill implements Cooking {
    private boolean state = false;
    private String cookingStyle;

    @Override
    public boolean isDone() {
        return state;
    }

    @Override
    public void cook() {
        state = true;
        cookingStyle = "grilled";
    }

    @Override
    public String getCookingStyle() {
        return cookingStyle;
    }
}
