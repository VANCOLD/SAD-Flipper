package flipper.states;

import flipper.singletons.FlipperAutomat;

public class PlayingState extends AbstractState {

    public PlayingState(FlipperAutomat flipperAutomat) {
        super(flipperAutomat);
    }

    @Override
    public void pressStart() {
        System.out.println("This game was created by: " +
            "Florian Grafl, Raja Abdulhadi & Polak Rene :).\n Thanks for playing! ");
    }
}
