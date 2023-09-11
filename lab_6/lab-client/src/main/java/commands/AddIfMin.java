package commands;

import transmission.Request;
import util.Valisender;

public class AddIfMin implements Command{
    private final Valisender valisender;

    public AddIfMin(Valisender valisender){
        this.valisender = valisender;
    }

    @Override
    public Request check(String argument) {
        if (argument != null){
            System.out.println("Команда add_if_min не принимает аргументы.");
            return null;
        }
        return valisender.addIfMin();
    }
}
