package commands;

import collection.CollectionManager;
import collection.HumanBeingCollectionManager;
//import commands.instructions.Add;
//import commands.instructions.Help;
//import commands.instructions.Show;
import data.HumanBeing;
import exceptions.*;
import file.ReadWriteAble;
import inout.ConsoleInputManager;
import inout.FileInputManager;
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
        running=false;
        scriptName="";
        map = new HashMap<String, Command>();
        //Info info = new Info();

        addCommand("info", (a)-> System.out.println(this.collectionManager.getInfo()));
        addCommand("help", (a)-> getHelp());
        addCommand("show", (a)->{
            if (this.collectionManager.getCollection().isEmpty()) System.out.println("Коллекция пустая");
            else System.out.println(this.collectionManager.toJsonCollection());
        });
        addCommand("add", (a)-> this.collectionManager.add(this.inputManager.readHumanBeing()));
            //boolean check=this.collectionManager.add(this.inputManager.readHumanBeing());
            //System.out.println(check);});//Add.go(collectionManager, inputManager));
        addCommand("update", (arg)-> {
            int id=0;
            if (arg == null || arg.equals("")){
                throw new WrongCommandArgumentException("Аргумент не указан или указан неверно");
            }
            try{
                id = Integer.parseInt(arg);
            } catch (NumberFormatException e){
                throw new WrongCommandArgumentException("id должен быть натуральным числом");
            }
            if (this.collectionManager.getCollection().isEmpty()) throw new EmptyCollectionException();
            if (!this.collectionManager.checkID(id)) throw new WrongCommandArgumentException("Указанного id не существует");
            this.collectionManager.updateByID(id, this.inputManager.readHumanBeing());
        });

        addCommand("remove_by_id", (arg)->{
            int id = 0;
            if (arg == null || arg.equals("")){
                throw new WrongCommandArgumentException("Аргумент не указан или указан неверно");
            }
            try{
                id = Integer.parseInt(arg);
            } catch (NumberFormatException e){
                throw new WrongCommandArgumentException("id должен быть натуральным числом");
            }
            if (this.collectionManager.getCollection().isEmpty()) throw new EmptyCollectionException();
            if (!this.collectionManager.checkID(id)) throw new WrongCommandArgumentException("Указанного id не существует");

            this.collectionManager.removeByID(id);

        });
        addCommand("clear", (a)->{
            this.collectionManager.clear();
        });

        addCommand("save", (arg)->{
            if (!(arg == null ||arg.equals(""))) this.fileManager.setPath(arg);
            if (this.collectionManager.getCollection().isEmpty()) System.out.println("Коллекция пустая");
            if(!this.fileManager.write(this.collectionManager.toJsonCollection())) throw new CommandException("Неудалось сохранить коллекцию");

        });
        addCommand("execute_script",(arg)->{
            if (arg == null || arg.equals("")){
                throw new WrongCommandArgumentException("Не указан аргумент");
            }

            if (callStack.contains(scriptName)) throw new RecursiveException();

            callStack.push(scriptName);
            CommandManager process = new CommandManager(this.collectionManager, this.inputManager, this.fileManager);
            process.fileMode(arg);
            callStack.pop();
            System.out.println("Скрипт успешно выполнен " + arg);

        });
        addCommand("exit", (a)->running=false);
        addCommand("add_if_min", (a)->this.collectionManager.addIfMin(this.inputManager.readHumanBeing()));
        addCommand("filter_contains_name", (arg)-> {
            if (arg==null||arg.equals("")){
                throw new WrongCommandArgumentException("Не указан аргумент");
            } else{
                if (this.collectionManager.getCollection().isEmpty()) throw new EmptyCollectionException();
                this.collectionManager.printElementsWithName(arg);
            }
        });
        addCommand("filter_by_soundtrack_name", (arg)-> {
            if (arg==null||arg.equals("")){
                throw new WrongCommandArgumentException("Не указан аргумент");
            } else{
                if (this.collectionManager.getCollection().isEmpty()) throw new EmptyCollectionException();
                this.collectionManager.printElementsWithSoundtrackName(arg);
            }
        });
        addCommand("print_field_descending_weapon_type", (a)->{
            if (this.collectionManager.getCollection().isEmpty()) throw new EmptyCollectionException();
            this.collectionManager.printFieldDescendingWeaponType();
        });
        addCommand("remove_lower", (a)-> {
            if (this.collectionManager.getCollection().isEmpty()) throw new EmptyCollectionException();
            this.collectionManager.removeLower(this.inputManager.readHumanBeing());
        });
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
        inputManager = new ConsoleInputManager();
        running = true;
        while(running) {
            System.out.print("Введите команду (введите help чтобы увидеть список команд) ");
            Wrap pair = inputManager.readCommand();
            runCommand(pair.getCommand(), pair.getArg());
        }
    }


    @Override
    public void fileMode(String path) {
            scriptName = path;
            running = true;
            inputManager = new FileInputManager(path);
            running = true;
            while(running && inputManager.getScanner().hasNextLine()){
                Wrap pair = inputManager.readCommand();
                runCommand(pair.getCommand(), pair.getArg());
            }
    }

    public void getHelp(){
        System.out.println("\r\nhelp : вывести справку по доступным командам\r\n\r\ninfo : вывести в стандартный поток вывода информацию о коллекции (тип,\r\nдата инициализации, количество элементов и т.д.)\r\n\r\nshow : вывести в стандартный поток вывода все элементы коллекции в \r\nстроковом представлении\r\n\r\nadd {element} : добавить новый элемент в коллекцию\r\n\r\nupdate id {element} : обновить значение элемента коллекции, id которого\r\nравен заданному\r\n\r\nremove_by_id id : удалить элемент из коллекции по его id\r\n\r\nclear : очистить коллекцию\r\n\r\nsave [имя_файла] : сохранить коллекцию в файл\r\n\r\nload [имя_файла] : загрузить коллекцию из файла\r\n\r\nexecute_script file_name : считать и исполнить скрипт из указанного файла.\r\nВ скрипте содержатся команды в таком же виде, в котором их вводит\r\nпользователь в интерактивном режиме.\r\n\r\nexit : завершить программу (без сохранения в файл)\r\n\r\nadd_if_min {element} : добавить новый элемент в коллекцию, \r\nесли его значение меньше, чем у наименьшего элемента этой коллекции\r\n\r\nremove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\r\n\r\nhistory : вывести последние 14 команд (без их аргументов)\r\n\r\nfilter_by_soundtrack_name soundtrackName : вывести элементы,\r\nзначение поля soundtrackName которых равно заданному\r\n\r\nfilter_contains_name name : вывести элементы, значение \r\nполя name которых содержит заданную подстроку\r\n\r\nprint_field_descending_weapon_type : вывести значения поля\r\nweaponType всех элементов в порядке убывания\r\n");
    }

}

