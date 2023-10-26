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

    private Boolean lost;

    private Boolean onBoard;

    private Integer ballIndex;


    private Ball() {
        this.lost       = false;
        this.onBoard    = false;
        this.ballIndex  = index;
        index++;
    }

    public static LinkedList<Ball> createBalls() {

        LinkedList ballQueue = new LinkedList();

        ballQueue.add(Objects.requireNonNullElseGet(Ball.ball1, Ball::new));
        ballQueue.add(Objects.requireNonNullElseGet(Ball.ball2, Ball::new));
        ballQueue.add(Objects.requireNonNullElseGet(Ball.ball3, Ball::new));

        return ballQueue;
    }
    public Boolean getLost() {
        return lost;
    }

    public void setLost(Boolean lost) {
        this.lost = lost;
    }

    public Boolean getOnBoard() {
        return onBoard;
    }

    public void setOnBoard(Boolean onBoard) {
        this.onBoard = onBoard;
    }

    public FontFactory getFontFactory() {

        switch(this.ballIndex) {

            case 1:
                return new Ball1FontFactory();

            case 2:
                return new Ball2FontFactory();

            case 3:
                return new Ball3FontFactory();

        }

        return null;
    }

}
