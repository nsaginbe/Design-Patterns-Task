package proxy;

public class Proxy implements FeedbackInterface {
    private FeedbackInterface service;

    public Proxy(FeedbackInterface service) {
        this.service = service;
    }

    @Override
    public String sendFeedback() {
        if (checkAccess()){
            return service.sendFeedback();
        }
        return null;
    }

    private boolean checkAccess() {
        return Configuration.USER.equals("authorized");
    }
}
