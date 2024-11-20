package mediator;

public class Waiter implements Mediator {
    private Client man;
    private Client woman;
    private Client commission;

    @Override
    public void send(Client sender, String action, Client receiver) {
        System.out.print("[" + sender.getName() + "] - ");

        if (action.equals("gift")) {
            System.out.println("Please, gift pancake to "  + receiver.getName() + "!");
        }
        if (action.equals("complaint")) {
            System.out.println("Kick "  + receiver.getName() + " out of restaurant!");
        }
    }

    public Client getMan() {
        return man;
    }
    public Client getWoman() {
        return woman;
    }
    public Client getCommission() {
        return commission;
    }

    public void setMan(Client man) {
        this.man = man;
    }
    public void setWoman(Client woman) {
        this.woman = woman;
    }
    public void setCommission(Client commission) {
        this.commission = commission;
    }
}
