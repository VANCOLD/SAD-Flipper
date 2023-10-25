package flipper.composite;

import flipper.commands.HitCommand;
import flipper.commands.ScoreCommand;

public class AbstractFlipperElement implements FlipperElement{

    public Boolean hit;

    public Integer scoreTotal;

    public Integer scoreIncrease;

    private HitCommand hitCommand;

    private ScoreCommand scoreCommand;

    public AbstractFlipperElement() {
        this(0);
    }

    public AbstractFlipperElement(Integer scoreIncrease) {
        this.hit            = false;
        this.scoreTotal     = 0;
        this.scoreIncrease  = scoreIncrease;
        this.hitCommand     = new HitCommand(this);
        this.scoreCommand   = new ScoreCommand(this);
    }


    @Override
    public void hit() {
        System.out.println(Class.class.getName() + " has been hit!");
        this.hit = !hit;
        this.score();
    }

    @Override
    public void score() {
        this.scoreTotal = scoreTotal + scoreIncrease;
    }
}
