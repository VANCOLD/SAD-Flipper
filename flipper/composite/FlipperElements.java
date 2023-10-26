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

    private CommandHistory commandHistory;


    public FlipperElements() {
        this.children           = new ArrayList<>(5);
        this.rng                = new Random();
        this.commandHistory     = new CommandHistory();
        this.nextElementToHit   = 0;
    }


    public void add(AbstractFlipperElement element) {
        this.children.add(element);
    }

    public void remove(AbstractFlipperElement element) {

        if(this.children.contains(element)) {
            this.children.remove(element);
        } else {
            throw new NoSuchElementException("Flipper element not found inside flipper!");
        }
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
        String output = "";

        for(AbstractFlipperElement element : this.children) {
            output += element.toString() + "\n";
        }

        return output;
    }

    public String printCommandHistory() {

        String output = "";

        for(AbstractCommand command : this.commandHistory.getCommandList()) {
            output += "[COMMAND]: " + this.commandHistory.getCommandList().indexOf(command) + "# "
                + command.getClass().getSimpleName() +" interacted with " + command.getTarget().getClass().getSimpleName()  + "\n";
        }

        return output;
    }
}
