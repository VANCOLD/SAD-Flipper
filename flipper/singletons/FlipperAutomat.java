package flipper.singletons;

import flipper.composite.*;
import flipper.enums.Inputs;
import flipper.factories.FontFactory;
import flipper.factories.fonts.GameOverFont;
import flipper.factories.implementations.GameOverFontFactory;
import flipper.factories.implementations.PinballFontFactory;
import flipper.states.EndState;
import flipper.states.NoCreditState;
import flipper.states.PlayingState;
import flipper.states.State;
import flipper.visitor.ResetVisitor;
import flipper.visitor.ScoreVisitor;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;

public class FlipperAutomat {

    private static final FlipperAutomat flipperAutomat = null;

    public static Boolean DEBUG;

    private State gameState;

    private Integer credits;

    private final IOManager ioManager;

    private final FlipperElements flipperElements;

    private FontFactory fontFactory;

    private LinkedList<Ball> balls;

    private Ball currentBall;

    private Integer totalScore;


    private FlipperAutomat() {
        this.credits            = 0;
        this.gameState          = new NoCreditState(this);
        this.ioManager          = IOManager.createManager();
        this.flipperElements    = new FlipperElements();
        this.fontFactory        = new PinballFontFactory();
        this.currentBall        = null;
        this.balls              = new LinkedList<>();
        this.totalScore         = 0;
        this.setup();
    }

    public static FlipperAutomat createFlipperAutomat() {
        return Objects.requireNonNullElseGet(
            FlipperAutomat.flipperAutomat, FlipperAutomat::new);
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
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

        this.balls = Ball.createBalls();
    }


    public void run() throws InterruptedException {

        if(FlipperAutomat.DEBUG) {
            ioManager.printMessage("DEBUGGING ACTIVE");
            ioManager.printMessage(this.flipperElements.toString());
        }

        System.out.println();
        ioManager.printMessage(this.fontFactory.createFont().getMessage());
        ioManager.printMessage("""
            The pinball machine lights up, you get all excited, a prompt flashes on it's screen, it reads:
            Type credits to add credits to the machine
            Type start to start a round of pinball (credits needed)""");

        while ( true ) {

            if( (this.gameState instanceof PlayingState) ) {
                tick();
                continue;
            }

            String line         = this.ioManager.readLine().toLowerCase();
            Inputs inputValue   = Inputs.getInputValue(line);

            switch(inputValue) {

                case START: {
                    this.gameState.pressStart();
                    break;
                }

                case CREDITS: {
                    this.gameState.addCredits();
                    break;
                }

                case PRESS: {
                    break;
                }

                case EXIT: {
                    this.gameState.exit();
                }

                case INVALID:
                    ioManager.printMessage("INVALID INPUT!:\n");
                case HELP: {
                    this.gameState.help();
                    break;
                }

            }
        }
    }

    private void tick() throws InterruptedException {

        if(balls.isEmpty() && currentBall == null) {

            ioManager.printMessage("Total game score: " + totalScore);
            ioManager.printMessage("Game lost! Wanna try again?");
            this.changeState(new EndState(this));
            this.totalScore  = 0;
            this.balls       = Ball.createBalls();
            this.currentBall = this.balls.pop();
            return;

        }

        if(currentBall == null) {

            this.currentBall =  this.balls.pop();

            this.fontFactory = currentBall.getFontFactory();
            ioManager.printMessage(this.fontFactory.createFont().getMessage());
        }

        this.flipperElements.hit();
        this.flipperElements.score();
        this.flipperElements.generateNextHit();

        Random rng = new Random();
        var val = rng.nextInt(0,101);

        if( val <= 5) {

            this.currentBall = null;

            ScoreVisitor scoreVisitor = new ScoreVisitor();
            ResetVisitor resetVisitor = new ResetVisitor();

            for(AbstractFlipperElement element : this.flipperElements.getChildren() ) {
                element.accept(scoreVisitor);
                element.accept(resetVisitor);
            }
            this.totalScore += scoreVisitor.getScoreTotal();
            ioManager.printMessage("Ball loss!");
            ioManager.printMessage("Total score: " + scoreVisitor.getScoreTotal());
            this.fontFactory = new GameOverFontFactory();
            ioManager.printMessage(this.fontFactory.createFont().getMessage());

            if(FlipperAutomat.DEBUG)
                ioManager.printMessage(flipperElements.printCommandHistory());
        }

        Thread.sleep(1000);
    }

}
