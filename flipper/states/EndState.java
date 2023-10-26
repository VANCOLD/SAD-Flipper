package flipper.states;

import flipper.singletons.FlipperAutomat;

public class EndState extends AbstractState {

    public EndState(FlipperAutomat flipperAutomat) {
        super(flipperAutomat);
    }

    @Override
    public void pressStart() {
        System.out.println("Insert credits to continue or type exit to stop playing");
    }

    @Override
    public void help() {
        System.out.println("Type start to start a round.\n" +
                           "Type credits to add another credit to the machine.\n" +
                           "Type exit to quit the game");
    }

    @Override
    public void exit() {
        System.out.println("Thanks for playing the game :)!");
        System.exit(1);
    }
}
