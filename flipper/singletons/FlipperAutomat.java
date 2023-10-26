package flipper.singletons;

import flipper.composite.*;
import flipper.states.NoCreditState;
import flipper.states.State;

import java.util.Objects;

public class FlipperAutomat {

    private static final FlipperAutomat flipperAutomat = null;

    private State gameState;

    private Integer credits;

    private IOManager ioManager;

    private FlipperElements flipperElements;

    private FlipperAutomat() {
        this.credits            = 0;
        this.gameState          = new NoCreditState(this);
        this.ioManager          = IOManager.createManager();
        this.flipperElements    = new FlipperElements();

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
        System.out.println(this.flipperElements.toString());

    }
}
