package commands;

import transmission.Request;
import transmission.Response;
import util.Receiver;

public class Save implements Command{
    private final Receiver receiver;

    public Save(Receiver receiver) {
        this.receiver = receiver;

    }

    @Override
    public Response execute(Request request) {
        receiver.clearResponse();
        return receiver.save();
    }

    @Override
    public String getHelp() {
        return "Команда save: недоступна.";
    }
}
