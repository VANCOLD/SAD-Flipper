package flipper.states;

public interface State {

    void addCredits(Integer credit);

    void pressStart();

    void help();

    void exit();
}
