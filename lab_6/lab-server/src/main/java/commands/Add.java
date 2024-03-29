package commands;

import transmission.Request;
import transmission.Response;
import util.Receiver;

public class Add implements Command {

    private final Receiver receiver;

    public Add(Receiver receiver){
        this.receiver = receiver;
    }


    @Override
    public Response execute(Request request) {
        receiver.clearResponse();
        return receiver.add(request.getHumanBeing());
    }

    @Override
    public String getHelp() {
        return "Введите add {element}, чтобы добавить новый элемент в коллекцию";
    }
}
