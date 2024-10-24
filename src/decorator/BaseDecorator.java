package decorator;

import composite.Component;

public abstract class BaseDecorator implements Component {
    private Component wrapper;

    public BaseDecorator(Component component) {
        this.wrapper = component;
    }

    @Override
    public int calculate() {
        return wrapper.calculate();
    }

    @Override
    public String toString(String prefix) {
        return "";
    }
}
