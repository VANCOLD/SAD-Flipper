package flipper.states;

import flipper.singletons.FlipperAutomat;

public abstract class AbstractState implements State {

    protected FlipperAutomat flipperAutomat;

    protected static Integer credits;

    public AbstractState(FlipperAutomat flipperAutomat) {
        this.flipperAutomat = flipperAutomat;
    }

    @Override
    public void addCredits(Integer credits) {
        AbstractState.credits += credits;
        System.out.println("The credits counter was increase, the credits total is: " + AbstractState.credits);
    }
}
