package exceptions;

public class WrongEnumValueException extends WrongDataException{
    public WrongEnumValueException(){
        super("Неправильное значение константы");
    }
}
