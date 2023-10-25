package flipper.commands;

import flipper.composite.AbstractFlipperElement;

public class ScoreCommand extends AbstractCommand {
    public ScoreCommand(AbstractFlipperElement target) {
        super(target);
    }

    @Override
    public void execute() {
        this.target.score();
    }
}
