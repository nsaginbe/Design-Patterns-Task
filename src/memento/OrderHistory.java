package memento;

import prototype.PrototypeRegistry;

import java.util.Stack;

// Caretaker
public class OrderHistory {
    private final Stack<OrderMemento> history = new Stack<>();

    public void snapshot(PrototypeRegistry registry) {
        history.push(registry.snapshot());
    }

    public void undo(PrototypeRegistry registry) {
        if (!history.isEmpty()) {
            registry.restore(history.pop());
        }
        else {
            System.out.println("\nNo history snapshots are found");
        }
    }
}
