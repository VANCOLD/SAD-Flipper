package flipper.commands;

import java.util.List;

public class CommandHistory {
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

    private List<AbstractCommand> commandList;
}
