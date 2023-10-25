package flipper.commands;

import flipper.composite.AbstractFlipperElement;

public class HitCommand extends AbstractCommand {

    public HitCommand(AbstractFlipperElement target) {
        super(target);
    }

    @Override
    public void execute () {
        target.hit();
    }
}
