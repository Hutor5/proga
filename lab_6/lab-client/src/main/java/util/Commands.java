package util;

import commands.*;
import transmission.Request;

import java.util.HashMap;

public class Commands {
    private final HashMap<String, Command> commandMap = new HashMap<>();

    public Commands(Valisender valisender){

        commandMap.put("add", new Add(valisender));
        commandMap.put("addIfMin", new AddIfMin(valisender));
        commandMap.put("clear", new Clear());
        commandMap.put("execute_script", new ExecuteScript());
        commandMap.put("exit", new Exit());
        commandMap.put("filter_by_soundtrack_name", new FilterBySoundtrackName());
        commandMap.put("filter_contains_name", new FilterContainsName());
        commandMap.put("help", new Help());
        commandMap.put("info", new Info());
        commandMap.put("print_field_descending_weapon_type", new PrintFieldDescendingWeaponType());
        commandMap.put("remove_by_id", new RemoveByID(valisender));
        commandMap.put("remove_lower", new RemoveLower(valisender));
        commandMap.put("show", new Show());
        commandMap.put("update", new Update(valisender));
    }

    public Request check(String commandName, String argument){
        if (this.commandMap.containsKey(commandName))
            return this.commandMap.get(commandName).check(argument);
        System.out.println("Введённой команды не существует. Повторите ввод.");
        return null;
    }
}
