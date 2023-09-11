package commands;

import transmission.Request;

public class Show implements Command{

    @Override
    public Request check(String argument) {
        if (argument != null){
            System.out.println("Команда show не принимает аргументы.");
            return null;
        }
        return new Request("show", null);
    }
}
