package exceptions;

import exceptions.FileException;

public class FileWrongPermissionsException extends FileException {
    public FileWrongPermissionsException(String s){
        super(s);
    }
}