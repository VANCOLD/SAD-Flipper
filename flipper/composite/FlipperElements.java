package flipper.composite;

import flipper.commands.AbstractCommand;
import flipper.commands.CommandHistory;
import flipper.commands.HitCommand;
import flipper.commands.ScoreCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class FlipperElements implements FlipperElement{

    private final List<AbstractFlipperElement> children;

    private final Random rng;

    private Integer nextElementToHit;

    private final CommandHistory commandHistory;


    public FlipperElements() {
        this.children           = new ArrayList<>(5);
        this.rng                = new Random();
        this.commandHistory     = new CommandHistory();
        this.nextElementToHit   = 0;
    }


    public void add(AbstractFlipperElement element) {
        this.children.add(element);
    }

    public List<AbstractFlipperElement> getChildren() {
        return children;
    }

    public void generateNextHit() {
        this.nextElementToHit = this.rng.nextInt(0,this.children.size());
    }

    @Override
    public void hit() {
        var command = new HitCommand(children.get(nextElementToHit));
        command.execute();
        this.commandHistory.addCommand(command);
    }

    @Override
    public void score() {
        var command = new ScoreCommand(children.get(nextElementToHit));
        command.execute();
        this.commandHistory.addCommand(command);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        for(AbstractFlipperElement element : this.children) {
            output.append(element.toString()).append("\n");
        }

        return output.toString();
    }

    public String printCommandHistory() {

        StringBuilder output = new StringBuilder();

        for(AbstractCommand command : this.commandHistory.getCommandList()) {
            output.append("[COMMAND]: ").append(this.commandHistory.getCommandList().indexOf(command))
                .append("# ").append(command.getClass().getSimpleName()).append(" interacted with ")
                .append(command.getTarget().getClass().getSimpleName()).append("\n");
        }

        return output.toString();
    }
}
