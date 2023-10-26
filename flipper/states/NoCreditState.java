package flipper.states;

import flipper.singletons.FlipperAutomat;

public class NoCreditState extends AbstractState {

    public NoCreditState(FlipperAutomat flipperAutomat) {
        super(flipperAutomat);
    }

    @Override
    public void pressStart() {
        if(flipperAutomat.getCredits() == 0) {
            System.out.println("There are credits in the pinball-machine!\nPlease type credits to add more credits to the machine");
        } else {
            System.out.println("Game started! You can continue inserting credits or type start to start playing!");
            this.flipperAutomat.changeState(new ReadyState(this.flipperAutomat));
        }
    }

    @Override
    public void help() {
        System.out.println("""
            Type start to signify that you want to get ready to play
            Type credits to add more credits to the pinball machine
            Type exit to quit playing and get your credits back""");
    }

    @Override
    public void exit() {
        System.out.println("Maybe next time ;)");
        System.exit(1);
    }
}
