package commands;

import transmission.Request;
import transmission.Response;
import util.Receiver;

public class Info implements Command{
    private final Receiver receiver;

    public Info(Receiver receiver) {
        this.receiver = receiver;

    }

    @Override
    public Response execute(Request request) {
        receiver.clearResponse();
        return receiver.info();
    }

    @Override
    public String getHelp() {
        return "Введите info, чтобы вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации," +
                " количество элементов)";
    }
}
