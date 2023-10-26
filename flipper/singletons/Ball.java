package flipper.singletons;

import flipper.factories.FontFactory;
import flipper.factories.implementations.Ball1FontFactory;
import flipper.factories.implementations.Ball2FontFactory;
import flipper.factories.implementations.Ball3FontFactory;

import java.util.LinkedList;

public class Ball {
    private static Ball ball1;

    private static Ball ball2;

    private static Ball ball3;

    private static Integer index = 1;

    private final Integer ballIndex;


    private Ball() {
        this.ballIndex  = index;
        index++;
    }

    public static LinkedList<Ball> createBalls() {

        LinkedList<Ball> ballQueue = new LinkedList<>();

        ball1 = ball1 == null ? new Ball() : ball1;
        ball2 = ball2 == null ? new Ball() : ball2;
        ball3 = ball3 == null ? new Ball() : ball3;

        ballQueue.add(ball1);
        ballQueue.add(ball2);
        ballQueue.add(ball3);

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
