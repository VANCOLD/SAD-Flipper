package flipper.factories.implementations;

import flipper.factories.fonts.Ball3Font;
import flipper.factories.FlipperFont;
import flipper.factories.FontFactory;

public class Ball3FontFactory implements FontFactory {
    @Override
    public FlipperFont createFont() {
        return new Ball3Font();
    }
}
