package flipper.composite;

import flipper.mediator.Mediator;

public class Target extends AbstractFlipperElement {

    private final Mediator mediator;

    public Target(Integer scoreIncrease, Ramp ramp) {
        super(scoreIncrease);
        this.mediator = ramp;
        ramp.subscribe(this);
    }

    @Override
    public void hit() {
        super.hit();
        this.mediator.notify(this, this.ledsOn);
    }
}
