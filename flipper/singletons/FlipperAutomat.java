package flipper.singletons;

import flipper.composite.*;
import flipper.enums.Inputs;
import flipper.factories.FontFactory;
import flipper.factories.implementations.PinballFontFactory;
import flipper.states.NoCreditState;
import flipper.states.State;

import java.util.LinkedList;
import java.util.Objects;

public class FlipperAutomat {

    private static final FlipperAutomat flipperAutomat = null;

    private State gameState;

    private Integer credits;

    private IOManager ioManager;

    private FlipperElements flipperElements;

    private FontFactory fontFactory;

    private LinkedList<Ball> balls;

    private FlipperAutomat() {
        this.credits            = 0;
        this.gameState          = new NoCreditState(this);
        this.ioManager          = IOManager.createManager();
        this.flipperElements    = new FlipperElements();
        this.fontFactory        = new PinballFontFactory();
        this.setup();
    }

    public static FlipperAutomat createFlipperAutomat() {
        return Objects.requireNonNullElseGet(
            FlipperAutomat.flipperAutomat, FlipperAutomat::new);
    }

    public void changeState(State state) {
        this.gameState = state;
    }

    public void setup() {

        Bumper bumper       = new Bumper(300);
        Hole hole           = new Hole(1000);
        Kicker kicker       = new Kicker(500);
        Ramp ramp           = new Ramp(2500);
        SlingShot slingShot = new SlingShot(800);
        Target target1      = new Target(200, ramp);
        Target target2      = new Target(200, ramp);
        Target target3      = new Target(200, ramp);

        this.flipperElements.add(bumper);
        this.flipperElements.add(hole);
        this.flipperElements.add(kicker);
        this.flipperElements.add(ramp);
        this.flipperElements.add(slingShot);
        this.flipperElements.add(target1);
        this.flipperElements.add(target2);
        this.flipperElements.add(target3);
    }


    public void run() {

        //System.out.println(this.flipperElements.toString());
        System.out.println();
        System.out.println(this.fontFactory.createFont().getMessage());
        System.out.println("The pinball machine lights up, you get all excited, a prompt flashes on it's screen, it reads:\n"+
                            "Type credits to add credits to the machine\n" +
                            "Type start to start a round of pinball (credits needed)");

        while ( true ) {

            String line         = this.ioManager.readLine().toLowerCase();
            Inputs inputValue   = Inputs.getInputValue(line);

            switch(inputValue) {

                case START: {
                    this.gameState.pressStart();
                    break;
                }

                case CREDITS: {
                    this.gameState.addCredits(1);
                    break;
                }

                case PRESS: {
                    break;
                }

                case EXIT: {
                    this.gameState.exit();
                }

                case INVALID:
                    System.out.println("INVALID INPUT!:\n");
                case HELP: {
                    this.gameState.help();
                    break;
                }

            }
        }
    }
}
