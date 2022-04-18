package exceptions;

public class NoSuchCommandException extends CommandException{
    public NoSuchCommandException() {
        super("Введённой команды не существует или она введена неправильно");
    }
}