package commands;

import collection.CollectionManager;
import collection.HumanBeingCollectionManager;
import data.HumanBeing;
import exceptions.CommandException;
import exceptions.NoSuchCommandException;
import exceptions.WrongDataException;
import file.ReadWriteAble;
import inout.ConsoleInputManager;
import inout.InputManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CommandManager implements Commandable{
    private Map<String, Command> map;
    private CollectionManager<HumanBeing> collectionManager;
    private InputManager inputManager;
    private ReadWriteAble fileManager;
    private boolean running;
    private String scriptName;
    private static Stack<String> callStack = new Stack<>();

    public CommandManager(CollectionManager<HumanBeing> collectionManager, InputManager inputManager, ReadWriteAble fileManager){
        this.collectionManager=collectionManager;
        this.fileManager=fileManager;
        this.inputManager=inputManager;
        scriptName="";
        map = new HashMap<String, Command>();

    }
    @Override
    public void addCommand(String key, Command cmd) {map.put(key, cmd);}

    @Override
    public void runCommand(String key, String arg) {
        try{
            if (! hasCommand(key)) throw new NoSuchCommandException();
            map.get(key).run(arg);
        }
        catch(CommandException | WrongDataException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void runCommand(String key) {runCommand(key,null);}

    @Override
    public boolean hasCommand(String s) {return map.containsKey(s);}

    @Override
    public void consoleMode() {

    }

    @Override
    public void fileMode(String path) {

    }
}
