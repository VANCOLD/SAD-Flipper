package flipper.composite;

import flipper.mediator.Mediator;

public class Target extends AbstractFlipperElement {

    private final Mediator mediator;

    private final Integer targetIndex;

    private static Integer TARGET_COUNT = 1;

    public Target(Integer scoreIncrease, Ramp ramp) {
        super(scoreIncrease);
        this.mediator       = ramp;
        this.targetIndex    =  Target.TARGET_COUNT;
        ramp.subscribe(this);
        Target.TARGET_COUNT ++;
    }

    @Override
    public void hit() {
        ledsOn = !ledsOn;
        System.out.println(this.getClass().getSimpleName() + this.targetIndex + " has been hit!");
        this.mediator.notify(this, this.ledsOn);
    }
}
