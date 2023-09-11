package commands;

import transmission.Request;
import util.Valisender;

public class Update implements Command{

    private final Valisender valisender;

    public Update(Valisender valisender){
        this.valisender = valisender;
    }

    @Override
    public Request check(String argument) {
        if (argument == null){
            System.out.println("Команда update требует аргумент id.");
            return null;
        }
        return valisender.updateId(argument);
    }
}
