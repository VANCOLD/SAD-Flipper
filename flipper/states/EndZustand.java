package flipper.states;

public class EndZustand implements Zustand {

    @Override
    public void addCredit(Integer credit) {

    }

    @Override
    public boolean pressStart() {
        return false;
    }
}
