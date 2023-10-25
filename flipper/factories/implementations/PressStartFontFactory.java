package flipper.factories.implementations;

import flipper.factories.FlipperFont;
import flipper.factories.FontFactory;
import flipper.factories.fonts.PressStartFont;

public class PressStartFontFactory implements FontFactory {
    @Override
    public FlipperFont createFont() {
        return new PressStartFont();
    }
}
