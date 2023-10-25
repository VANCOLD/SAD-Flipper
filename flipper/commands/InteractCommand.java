package flipper.commands;

import flipper.composite.FlipperElements;

public class InteractCommand implements Command {

    private final FlipperElements target;

    public InteractCommand(FlipperElements target) {
        this.target = target;
    }

    @Override
    public void execute() {
        target.generateNextHit();
        target.hit();
        target.score();
    }
}
