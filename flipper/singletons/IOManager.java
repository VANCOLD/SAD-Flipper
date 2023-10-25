package flipper.singletons;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public class IOManager {

    private static final IOManager ioManager = null;

    private final Scanner input;

    private IOManager() {
        input = new Scanner(System.in);
    }

    public static IOManager createManager() {
        return Objects.requireNonNullElseGet(IOManager.ioManager, IOManager::new);
    }

    public String readLine() {
        if(this.input.hasNextLine()) {
            return this.input.nextLine();
        } else {
            throw new NoSuchElementException("There is no user input to read!");
        }
    }

    public void printMessage(String message) {
        if( !(message.isBlank() && message.isEmpty()) ) {
            System.out.println(message);
        } else {
            throw new NoSuchElementException("The message provided is empty!");
        }
    }
}
