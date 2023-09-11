package commands;

import transmission.Request;

public class ExecuteScript implements Command{
    public Request check(String argument) {

        if (argument == null){
            System.out.println("Команда execute_script требует аргуемент - filename.");
            return null;
        }

        return new Request("execute_script", argument);
    }
}
