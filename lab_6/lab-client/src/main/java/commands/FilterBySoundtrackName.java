package commands;

import transmission.Request;

public class FilterBySoundtrackName implements Command{
    public Request check(String argument) {
        if (argument == null){
            System.out.println("Команда filter_by_soundtrack_name требует аргумент name.");
            return null;
        }
        return new Request("filter_by_soundtrack_name", argument);
    }
}
