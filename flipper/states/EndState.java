package flipper.states;

import flipper.singletons.FlipperAutomat;

public class EndState extends AbstractState {

    public EndState(FlipperAutomat flipperAutomat) {
        super(flipperAutomat);
    }

    @Override
    public void pressStart() {
        System.out.println("Thanks for playing the game :)!\nInsert credits to continue");
    }
}
