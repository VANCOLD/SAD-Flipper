package flipper.composite;

import flipper.commands.HitCommand;
import flipper.commands.ScoreCommand;
import flipper.visitor.ScoreVisitor;
import flipper.visitor.Visitor;

public class AbstractFlipperElement implements FlipperElement{

    public Boolean ledsOn;

    public Integer totalScore;

    public Integer scoreIncrease;


    private final HitCommand hitCommand;

    private final ScoreCommand scoreCommand;

    public AbstractFlipperElement() {
        this(0);
    }

    public AbstractFlipperElement(Integer scoreIncrease) {

        this.totalScore     = 0;
        this.ledsOn = false;
        this.scoreIncrease  = scoreIncrease;
        this.hitCommand     = new HitCommand(this);
        this.scoreCommand   = new ScoreCommand(this);

    }


    @Override
    public void hit() {
        System.out.println(this.getClass().getSimpleName() + " has been hit!");
        this.ledsOn = !ledsOn;
        this.score();
    }

    @Override
    public void score() {
        this.totalScore = totalScore + scoreIncrease;
    }

    public void accept(Visitor visitor) {

        if(visitor instanceof ScoreVisitor) {
            var scoreVisitor = ((ScoreVisitor) visitor);
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
