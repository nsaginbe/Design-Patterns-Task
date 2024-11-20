package mediator;

public interface Mediator {
    void send(Client sender, String action, Client receiver);

    Client getMan();
    Client getWoman();
    Client getCommission();

    void setMan(Client man);
    void setWoman(Client woman);
    void setCommission(Client commission);
}
