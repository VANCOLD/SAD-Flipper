package flipper.states;

public class ExitZustand implements Zustand {
    @Override
    public void addCredit(Integer credit) {
        System.exit(1);
    }

    @Override
    public boolean pressStart() {
        System.out.println("This game was created by: Florian Grafl, Raja Abdulhadi & Polak Rene :).\n Thanks for playing! ");
        return true;
    }
}
