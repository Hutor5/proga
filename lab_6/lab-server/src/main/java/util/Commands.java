package util;

import commands.*;
import transmission.Request;
import transmission.Response;

import java.util.HashMap;

public class Commands {

    private static Commands commands;

    private final HashMap<String, Command> commandMap = new HashMap<>();

    public void register(String commandName, Command command){
        commandMap.put(commandName, command);
    }

    public Commands(Receiver receiver){

        commandMap.put("save", new Save(receiver));
        commandMap.put("add", new Add(receiver));
        commandMap.put("addIfMin", new AddIfMin(receiver));
        commandMap.put("clear", new Clear(receiver));
        commandMap.put("execute_script", new ExecuteScript(receiver));
        commandMap.put("filter_by_soundtrack_name", new FilterBySoundtrackName(receiver));
        commandMap.put("filter_contains_name", new FilterContainsName(receiver));
        commandMap.put("help", new Help(receiver, commandMap));
        commandMap.put("info", new Info(receiver));
        commandMap.put("print_fields_descending_weapon_type", new PrintFieldDescendingWeaponType(receiver));
        commandMap.put("remove_by_id", new RemoveByID(receiver));
        commandMap.put("remove_lower", new RemoveLower(receiver));
        commandMap.put("show", new Show(receiver));
        commandMap.put("update_id", new Update(receiver));
        commandMap.put("exit", new Exit());

    }

    public Response execute(Request request){
        String commandName = request.getCommandName();
        return this.commandMap.get(commandName).execute(request);
    }

    public HashMap<String, Command> getCommandMap(){
        return this.commandMap;
    }

    public static Commands getInstance(Receiver receiver){
        if (commands == null){
            commands = new Commands(receiver);
        }
        return commands;
    }

}
