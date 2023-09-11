package commands;

import transmission.Request;

public class FilterContainsName implements Command{
    public Request check(String argument) {
        if (argument == null){
            System.out.println("Команда filter_contains_name требует аргумент name.");
            return null;
        }
        return new Request("filter_contains_name", argument);
    }
}
