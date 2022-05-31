package exceptions;

public class EmptyCollectionException extends CommandException{
    public EmptyCollectionException(){super("Коллекция пустая");}
}
