package exceptions;

public class WrongNumberException extends WrongDataException{
    public WrongNumberException(){super("Неправильный формат числа");}
    public WrongNumberException(String msg){
        super(msg);
    }
}
