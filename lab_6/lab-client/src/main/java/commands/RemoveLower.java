package commands;

import transmission.Request;
import util.Valisender;

public class RemoveLower implements Command{
    private final Valisender valisender;

    public RemoveLower(Valisender valisender){
        this.valisender = valisender;
    }


    @Override
    public Request check(String argument) {
        if (argument != null){
            System.out.println("Команда remove_lower не принимает аргумент.");
            return null;
        }
        return valisender.removeLower();
    }
}
