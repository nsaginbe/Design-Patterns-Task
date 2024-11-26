package observer;

import mediator.Client;

public interface Notifier {
    void notifyObservers(String meal);
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
}
