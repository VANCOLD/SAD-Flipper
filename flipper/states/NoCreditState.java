package flipper.states;

import flipper.singletons.FlipperAutomat;

public class NoCreditState extends AbstractState {

    public NoCreditState(FlipperAutomat flipperAutomat) {
        super(flipperAutomat);
    }

    @Override
    public void pressStart() {
        if(this.credits == 0) {
            System.out.println("No credits in the machine!");
        } else {
            System.out.println("Credits inserted! You can continue inserting credits or press the start button to start playing!");
            this.flipperAutomat.changeState(new ReadyState(this.flipperAutomat));
        }
    }
}
