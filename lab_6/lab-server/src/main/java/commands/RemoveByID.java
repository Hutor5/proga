package commands;

import transmission.Request;
import transmission.Response;
import util.Receiver;

public class RemoveByID implements Command{
    private final Receiver receiver;

    public RemoveByID(Receiver receiver) {
        this.receiver = receiver;

    }

    @Override
    public Response execute(Request request) {
        receiver.clearResponse();
        return receiver.removeById(request.getArgument());
    }

    @Override
    public String getHelp() {
        return "Введите remove_by_id id, чтобы удалить элемент из коллекции по его id";
    }
}

