package mediator;

public class Man extends Client {
    public Man(String name, Mediator mediator) {
        super(name, mediator);

        mediator.setMan(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void action(String message) {
        mediator.send(this, "gift", mediator.getWoman());
    }


}
