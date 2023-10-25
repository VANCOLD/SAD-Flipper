package flipper.factories;

public class AbstractFont implements FlipperFont {

    private final String message;

    public AbstractFont(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
