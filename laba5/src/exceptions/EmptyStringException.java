package exceptions;

public class EmptyStringException extends WrongDataException {
    public EmptyStringException(){
        super("Строка не может быть пустой");
    }
}
