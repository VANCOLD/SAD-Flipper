package flipper.main;

import flipper.singletons.FlipperAutomat;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        FlipperAutomat.DEBUG = false;
        FlipperAutomat flipper = FlipperAutomat.createFlipperAutomat();
        flipper.run();
    }
}
