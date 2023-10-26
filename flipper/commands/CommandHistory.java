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

    public void removeCommand(AbstractCommand command) {
        int lastCommand = this.commandList.lastIndexOf(command);
        this.commandList.remove(lastCommand);
    }

    public void setCommandList(List<AbstractCommand> commandList) {
        this.commandList = commandList;
    }

}
