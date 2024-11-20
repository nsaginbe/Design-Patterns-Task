package mediator;

public class Woman extends Client {

    public Woman(String name, Mediator mediator) {
        super(name, mediator);

        mediator.setWoman(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void action(String message) {
        mediator.send(this, "gift", mediator.getCommission());
    }
}
