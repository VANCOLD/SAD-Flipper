package flipper.enums;

public enum Inputs {

    CREDITS("start"), START("start"), PRESS("press"), HELP("help"), EXIT("exit"), INVALID(""6);

    private String input;


    Inputs(String input) {
        this.input = input;
    }

    public static Inputs getInputValue(String input) {
        try {
            return Inputs.valueOf(input);
        } catch( IllegalArgumentException ex) {
            return Inputs.INVALID;
        }
    }
}
