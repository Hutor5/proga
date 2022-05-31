package exceptions;

public class RecursiveException extends CommandException{
    public RecursiveException(){
        super("Выполнение скрипта приведёт к рекурсии");
    }}

