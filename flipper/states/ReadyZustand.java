package flipper.states;

public class ReadyZustand implements Zustand {
    @Override
    public void addCredit(Integer credit) {

    }

    @Override
    public boolean pressStart() {
        return false;
    }
}
