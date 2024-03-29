package commands;

import transmission.Request;
import transmission.Response;
import util.Receiver;

public class RemoveLower implements Command {
    private final Receiver receiver;

    public RemoveLower(Receiver receiver) {
        this.receiver = receiver;

    }

    @Override
    public Response execute(Request request) {
        receiver.clearResponse();
        return receiver.removeLower(request.getHumanBeing());
    }

    @Override
    public String getHelp() {
        return "Введите remove_lower {element}, чтобы удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
