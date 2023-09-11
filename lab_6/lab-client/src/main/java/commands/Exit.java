package commands;

import transmission.Request;

public class Exit implements Command{

    @Override
    public Request check(String argument) {
        if (argument != null){
            System.out.println("Команда exit не принимает аргументы.");
            return null;
        }
        System.out.println("Спасибо за работу. До свидания.");
        System.exit(0);
        return null;
    }
}
