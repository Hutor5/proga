package commands;

import transmission.Request;
import util.Valisender;

public class RemoveByID implements Command{
    private final Valisender valisender;

    public RemoveByID(Valisender valisender){
        this.valisender = valisender;
    }


    @Override
    public Request check(String argument) {
        if (argument == null){
            System.out.println("Команда remove_by_id требует аргумент id.");
            return null;
        }
        return valisender.removeByID(argument);
    }
}
