package command;

import java.util.Stack;

// Invoker (Sender)
public class OrderManager {
    private Stack<Command> commandHistory = new Stack<>();

    public void executeCommand(Command command) {
        commandHistory.push(command);
        command.execute();
    }

    public void undoCommand() {
        if (!commandHistory.isEmpty()) {
            Command command = commandHistory.pop();
            command.undo();
        }
    }
}
