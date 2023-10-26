package flipper.states;

import flipper.singletons.FlipperAutomat;

public abstract class AbstractState implements State {

    protected FlipperAutomat flipperAutomat;

    protected Integer credits;

    public AbstractState(FlipperAutomat flipperAutomat) {
        this.flipperAutomat = flipperAutomat;
        this.credits = 0;
    }

    @Override
    public void addCredits(Integer credits) {
        this.credits += credits;
    }
}
