package flipper.commands;

import flipper.composite.AbstractFlipperElement;


public abstract class AbstractCommand implements Command {

    protected AbstractFlipperElement target;

    public AbstractCommand(AbstractFlipperElement target) {
        this.target = target;
    }

    public AbstractFlipperElement getTarget() {
        return target;
    }

    public void setTarget(AbstractFlipperElement target) {
        this.target = target;
    }
}
