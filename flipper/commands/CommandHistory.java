package flipper.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
    private List<AbstractCommand> commandList;

    public CommandHistory() {
        this.commandList = new ArrayList<>();
    }

    public List<AbstractCommand> getCommandList() {
        return commandList;
    }

    public void addCommand(AbstractCommand command) {
        this.commandList.add(command);
    }

}
