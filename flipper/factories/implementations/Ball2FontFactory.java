package flipper.factories.implementations;

import flipper.factories.fonts.Ball2Font;
import flipper.factories.FlipperFont;
import flipper.factories.FontFactory;

public class Ball2FontFactory implements FontFactory {
    @Override
    public FlipperFont createFont() {
        return new Ball2Font();
    }
}
