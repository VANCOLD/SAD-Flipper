package flipper.factories.implementations;

import flipper.factories.fonts.Ball1Font;
import flipper.factories.FlipperFont;
import flipper.factories.FontFactory;

public class Ball1FontFactory implements FontFactory {
    @Override
    public FlipperFont createFont() {
        return new Ball1Font();
    }
}
