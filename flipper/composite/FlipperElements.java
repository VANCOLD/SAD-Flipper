package flipper.composite;

import flipper.commands.HitCommand;
import flipper.commands.ScoreCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class FlipperElements implements FlipperElement{

    private List<AbstractFlipperElement> children;

    private Random rng;

    private Integer nextElementToHit;


    public FlipperElements() {
        this.children           = new ArrayList<>();
        this.rng                = new Random();
        generateNextHit();
    }


    public void add(AbstractFlipperElement element) {
        this.children.add(element);
    }

    public void remove(AbstractFlipperElement element) {

        if(this.children.contains(element)) {
            this.children.remove(element);
        } else {
            throw new NoSuchElementException("Flipper element not found inside flipper!");
        }
    }

    public void generateNextHit() {
        this.nextElementToHit = this.rng.nextInt();
    }

    @Override
    public void hit() {
        new HitCommand(children.get(nextElementToHit)).execute();
    }

    @Override
    public void score() {
        new ScoreCommand(children.get(nextElementToHit)).execute();
    }
}
