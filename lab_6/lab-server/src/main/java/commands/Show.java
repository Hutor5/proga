package commands;

import transmission.Request;
import transmission.Response;
import util.Receiver;

public class Show implements Command{
    private final Receiver receiver;

    public Show(Receiver receiver) {
        this.receiver = receiver;

    }

    @Override
    public Response execute(Request request) {
        receiver.clearResponse();
        return receiver.show();
    }

    @Override
    public String getHelp() {
        return "Введите show, чтобы вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
