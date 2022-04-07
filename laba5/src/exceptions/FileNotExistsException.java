package exceptions;

import exceptions.FileException;

public class FileNotExistsException extends FileException {
    public FileNotExistsException(){
        super("Невозможно найти такой файл");
    }
}
