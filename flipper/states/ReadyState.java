package flipper.states;

import flipper.singletons.FlipperAutomat;

public class ReadyState extends AbstractState {

    public ReadyState(FlipperAutomat flipperAutomat) {
        super(flipperAutomat);
    }

    @Override
    public void pressStart() {
        this.credits -= 1;
        System.out.println("Starting a round of flipper! Current credits: " + this.credits);
        this.flipperAutomat.changeState(new PlayingState(this.flipperAutomat));
    }
}
