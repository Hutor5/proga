package commands;

import transmission.Request;
import transmission.Response;
import util.Receiver;

public class FilterBySoundtrackName implements Command{

    private final Receiver receiver;

    public FilterBySoundtrackName(Receiver receiver) {
        this.receiver = receiver;

    }

    @Override
    public Response execute(Request request) {
        receiver.clearResponse();
        return receiver.filterBySoundtrackName(request.getArgument());
    }

    @Override
    public String getHelp() {
        return "Введите filter_by_soundtrack_name name, чтобы вывести элементы, значение поля soundtrackName которых равно " +
                "заданной подстроке";
    }

}
