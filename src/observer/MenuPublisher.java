package observer;

import mediator.Client;
import singleton.Menu;

import java.util.ArrayList;
import java.util.List;

// Concrete Notifier
public class MenuPublisher implements Notifier {
    private List<Observer> subscribers;
    private Menu menu;

    public MenuPublisher() {
        subscribers = new ArrayList<>();
        menu = Menu.getInstance();
    }

    @Override
    public void notifyObservers(String meal) {
        for (Observer observer : subscribers) {
            observer.update(meal);
        }
    }
    @Override
    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }
    @Override
    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    public void addMainDish(String mainDish) {
        menu.addMainDish(mainDish);
        notifyObservers(mainDish);
    }

    public void addSide(String side) {
        menu.addSide(side);
        notifyObservers(side);
    }

    public void addDrink(String drink) {
        menu.addDrink(drink);
        notifyObservers(drink);
    }
}
