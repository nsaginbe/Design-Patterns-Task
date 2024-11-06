package proxy;

public class Feedback implements FeedbackInterface {
    private String feedback;

    public Feedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String sendFeedback() {
        return feedback;
    }
}
