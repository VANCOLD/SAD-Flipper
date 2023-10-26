package flipper.singletons;

import flipper.factories.FontFactory;
import flipper.factories.implementations.Ball1FontFactory;
import flipper.factories.implementations.Ball2FontFactory;
import flipper.factories.implementations.Ball3FontFactory;

import java.util.LinkedList;
import java.util.Objects;

public class Ball {
    private static final Ball ball1 = null;

    private static final Ball ball2 = null;

    private static final Ball ball3 = null;

    private static Integer index = 1;

    private final Integer ballIndex;


    private Ball() {
        this.ballIndex  = index;
        index++;
    }

    public static LinkedList<Ball> createBalls() {

        LinkedList<Ball> ballQueue = new LinkedList<>();

        ballQueue.add(Objects.requireNonNullElseGet(Ball.ball1, Ball::new));
        ballQueue.add(Objects.requireNonNullElseGet(Ball.ball2, Ball::new));
        ballQueue.add(Objects.requireNonNullElseGet(Ball.ball3, Ball::new));

        return ballQueue;
    }

    public FontFactory getFontFactory() {

        return switch (this.ballIndex) {
            case 1 -> new Ball1FontFactory();
            case 2 -> new Ball2FontFactory();
            case 3 -> new Ball3FontFactory();
            default -> null;
        };

    }

}
