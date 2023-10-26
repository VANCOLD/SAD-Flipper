package flipper.singletons;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class Ball {
    private static final Ball ball1 = null;

    private static final Ball ball2 = null;

    private static final Ball ball3 = null;

    private Boolean lost;

    private Ball() {
        this.lost = false;
    }

    public static LinkedList<Ball> createBall() {

        LinkedList ballQueue = new LinkedList();

        ballQueue.add(Objects.requireNonNullElseGet(Ball.ball1, Ball::new));
        ballQueue.add(Objects.requireNonNullElseGet(Ball.ball2, Ball::new));
        ballQueue.add(Objects.requireNonNullElseGet(Ball.ball3, Ball::new));

        return ballQueue;
    }
}
