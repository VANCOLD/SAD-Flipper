package flipper.main;

import flipper.singletons.FlipperAutomat;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        FlipperAutomat.DEBUG = true;
        FlipperAutomat.ELEMENT_COUNT = 15;
        FlipperAutomat flipper = FlipperAutomat.createFlipperAutomat();
        flipper.run();
    }
}
