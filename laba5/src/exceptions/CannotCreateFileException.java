package exceptions;

public class CannotCreateFileException extends FileException {
    public CannotCreateFileException(){
        super("Невозможно создать файл");
    }
}