package commands;

import transmission.Request;

public class Info implements Command{
    @Override
    public Request check(String argument) {
        if (argument != null){
            System.out.println("Команда info не принимает аргументы.");
            return null;
        }
        return new Request("info", null);
    }
}
