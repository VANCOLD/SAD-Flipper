package flipper.states;

import flipper.singletons.FlipperAutomat;

public class ReadyState extends AbstractState {

    public ReadyState(FlipperAutomat flipperAutomat) {
        super(flipperAutomat);
    }

    @Override
    public void pressStart() {
        this.flipperAutomat.setCredits(this.flipperAutomat.getCredits() - 1);
        System.out.println("Starting a round of flipper! Current credits: " + this.flipperAutomat.getCredits());
        this.flipperAutomat.changeState(new PlayingState(this.flipperAutomat));
    }

    @Override
    public void help() {
        System.out.println("Type start to start a round.\n" +
                            "Type credits to add another credit to the machine.\n" +
                            "Type exit to get your credits back and exit the game!");
    }

    @Override
    public void exit() {
        System.out.println("Returning credits.... *katching katching*");
        System.exit(1);
    }
}
