package flipper.factories.implementations;

import flipper.factories.FlipperFont;
import flipper.factories.FontFactory;
import flipper.factories.fonts.NoCreditsFont;

public class NoCreditsFontFactory implements FontFactory {
    @Override
    public FlipperFont createFont() {
        return new NoCreditsFont();
    }
}
