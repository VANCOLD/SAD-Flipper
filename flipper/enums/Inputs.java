package flipper.enums;

public enum Inputs {

    CREDITS("credits"), START("start"), PRESS("press"), HELP("help"), EXIT("exit"), INVALID("");

    private final String input;


    Inputs(String input) {
        this.input = input;
    }

    public static Inputs getInputValue(String input) {
        try {
            return Inputs.valueOf(input.toUpperCase());
        } catch( IllegalArgumentException ex) {
            return Inputs.INVALID;
        }
    }
}
