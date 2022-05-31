package main;

import collection.CollectionManager;
import collection.HumanBeingCollectionManager;
import commands.CommandManager;
import data.HumanBeing;
import file.FileManager;
import inout.ConsoleInputManager;
import inout.InputManager;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        CollectionManager<HumanBeing> collectionManager = new HumanBeingCollectionManager();
        if (args.length != 0) {
            fileManager.setPath(args[0]);
            collectionManager.fromJsonCollection(fileManager.read());
        } else {
            System.out.println("Указанный файл не существует. Вы можете загрузить файл с помощью команды загрузки");
        }

        InputManager consoleManager = new ConsoleInputManager();
        CommandManager commandManager = new CommandManager(collectionManager, consoleManager, fileManager);
        commandManager.consoleMode();
    }
}
