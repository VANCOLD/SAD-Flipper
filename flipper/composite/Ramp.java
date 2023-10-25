package flipper.composite;

import flipper.mediator.Mediator;

import java.util.ArrayList;
import java.util.List;


public class Ramp extends AbstractFlipperElement implements Mediator {

    private Boolean interactable;

    private final List<AbstractFlipperElement> targets;

    public Ramp(Integer scoreIncrease) {
        super(scoreIncrease);
        this.interactable = false;
        this.targets      = new ArrayList<>();
    }

    @Override
    public void score() {
        if(interactable) {
            super.score();
        } else {
            System.out.println("Ramp is currently not active!");
        }
    }

    @Override
    public void hit() {
        if(interactable) {
            super.hit();
        } else {
            System.out.println("Ramp is currently not active");
        }
    }

    @Override
    public void notify(AbstractFlipperElement sender, Boolean hit) {
        this.interactable = this.targets.stream().allMatch(target -> target.hit);
    }

    @Override
    public void subscribe(AbstractFlipperElement sender) {
        this.targets.add(sender);
    }
}
