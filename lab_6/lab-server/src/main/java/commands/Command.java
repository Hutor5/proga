package commands;

import transmission.Request;
import transmission.Response;

public interface Command {
    Response execute(Request request);

    String getHelp();

}
