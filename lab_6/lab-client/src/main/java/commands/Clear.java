package commands;

import transmission.Request;

public class Clear implements Command{
    @Override
    public Request check(String argument) {
        if(argument != null){
            System.out.println("Команда clear не принимает аргументы.");
            return null;
        }
        return new Request("clear", null);
    }
}
