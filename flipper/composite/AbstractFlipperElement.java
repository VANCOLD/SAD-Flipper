package flipper.composite;

import flipper.visitor.ScoreVisitor;
import flipper.visitor.Visitor;

public class AbstractFlipperElement implements FlipperElement{

    public Boolean ledsOn;

    public Integer totalScore;

    public final Integer scoreIncrease;

    public AbstractFlipperElement() {
        this(0);
    }

    public AbstractFlipperElement(Integer scoreIncrease) {

        this.totalScore     = 0;
        this.ledsOn = false;
        this.scoreIncrease  = scoreIncrease;
    }


    @Override
    public void hit() {
        System.out.println(this.getClass().getSimpleName() + " has been hit!");
        this.ledsOn = !ledsOn;
    }

    @Override
    public void score() {
        this.totalScore = totalScore + scoreIncrease;
    }

    public void accept(Visitor visitor) {

        if(visitor instanceof ScoreVisitor scoreVisitor) {
            scoreVisitor.setScoreTotal(scoreVisitor.getScoreTotal() + this.totalScore);
        } else {
            this.ledsOn = false;
            this.totalScore     = 0;
        }
    }

    @Override
    public String toString() {
        return "[ " + this.getClass().getSimpleName() + " | hit: " + ledsOn + " | total score: " + totalScore + " | score increase: " + scoreIncrease + " ]";
    }
}
