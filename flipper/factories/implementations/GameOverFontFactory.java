package flipper.factories.implementations;

import flipper.factories.FlipperFont;
import flipper.factories.FontFactory;
import flipper.factories.fonts.GameOverFont;

public class GameOverFontFactory implements FontFactory {
    @Override
    public FlipperFont createFont() {
        return new GameOverFont();
    }
}
