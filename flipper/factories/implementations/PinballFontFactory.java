package flipper.factories.implementations;

import flipper.factories.FlipperFont;
import flipper.factories.FontFactory;
import flipper.factories.fonts.PinballFont;

public class PinballFontFactory implements FontFactory {
    @Override
    public FlipperFont createFont() {
        return new PinballFont();
    }
}
