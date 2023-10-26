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

    @Override
    public void help() {
        System.out.println("Type start to see who worked on the game.\n" +
                           "Type credits to add another credit to the machine.");
    }

    @Override
    public void exit() {
        System.out.println("You can not exit the game while playing");
    }
}
