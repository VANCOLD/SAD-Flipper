package flipper.states;

import flipper.singletons.FlipperAutomat;

public abstract class AbstractState implements State {

    protected FlipperAutomat flipperAutomat;

    public AbstractState(FlipperAutomat flipperAutomat) {
        this.flipperAutomat = flipperAutomat;
    }

    @Override
    public void addCredits() {
        this.flipperAutomat.setCredits(this.flipperAutomat.getCredits() + 1);
        System.out.println("The credits counter was increase, the credits total is: " + this.flipperAutomat.getCredits());
    }
}
