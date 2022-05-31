package exceptions;

public class WrongDateFormatException extends WrongDataException{
    public WrongDateFormatException(){super("формат даты должен быть ГГГГ-ММ-ДД");}
}
