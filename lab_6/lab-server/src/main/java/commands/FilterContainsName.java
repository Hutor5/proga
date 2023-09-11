package commands;

import transmission.Request;
import transmission.Response;
import util.Receiver;

public class FilterContainsName implements Command{

    private final Receiver receiver;

    public FilterContainsName(Receiver receiver) {
        this.receiver = receiver;

    }

    @Override
    public Response execute(Request request) {
        receiver.clearResponse();
        return receiver.filterContainsName(request.getArgument());
    }

    @Override
    public String getHelp() {
        return "Введите filter_contains_name name, чтобы вывести элементы, значение поля name которых содержит " +
                "заданную подстроку";
    }
}
