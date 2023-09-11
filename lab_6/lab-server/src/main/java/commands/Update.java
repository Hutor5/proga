package commands;

import transmission.Request;
import transmission.Response;
import util.Receiver;

public class Update implements Command{
    private final Receiver receiver;

    public Update(Receiver receiver) {
        this.receiver = receiver;

    }

    @Override
    public Response execute(Request request) {
        receiver.clearResponse();
        return receiver.updateId(request.getArgument(), request.getHumanBeing());
    }

    @Override
    public String getHelp() {
        return "Введите update {id_element}, чтобы обновить значение элемента коллекции, id которого равен заданному";
    }

}
