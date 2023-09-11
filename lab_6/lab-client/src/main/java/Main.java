import util.Client;
import util.Commands;
import util.Terminal;
import util.Valisender;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args){
        try {
            Client client = new Client();
            Valisender valiciever = new Valisender();
            Commands commands = new Commands(valiciever);
            Terminal terminal = new Terminal(commands, client);
            terminal.startKeyboard();
        } catch (NoSuchElementException ex){
            System.exit(0);
        }
    }
}
