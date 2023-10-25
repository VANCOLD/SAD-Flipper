package flipper.singletons;

import flipper.states.NoCreditZustand;
import flipper.states.Zustand;

import java.util.Objects;

public class FlipperAutomat {

    private static final FlipperAutomat flipperAutomat = null;

    private Zustand spielZustand;

    private Integer credits;

    private IOManager ioManager;

    private FlipperAutomat() {
        this.credits = 0;
        this.spielZustand = new NoCreditZustand();
    }

    public static FlipperAutomat createFlipperAutomat() {
        return Objects.requireNonNullElseGet(FlipperAutomat.flipperAutomat, FlipperAutomat::new);
    }

    public void start() {
    }
}
