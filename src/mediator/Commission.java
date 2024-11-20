package mediator;

public class Commission extends Client {

    public Commission(String name, Mediator mediator) {
        super(name, mediator);

        mediator.setCommission(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void action(String message) {
        mediator.send(this, "complaint", mediator.getMan());
    }
}