package commands;

import transmission.Request;
import util.Valisender;

public class Add implements Command{

    private final Valisender valisender;

    public Add(Valisender valisender){
        this.valisender = valisender;
    }


    @Override
    public Request check(String argument) {
        if (argument != null) {
            System.out.println("Команда add не принимает аргументы.");
            return null;
        }
        return valisender.add();
    }
}
