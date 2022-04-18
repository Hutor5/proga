package inout;

import file.FileManager;

import java.util.Scanner;

public class FileInputManager extends UniversalInputManager{
    public FileInputManager(String path){
        super(new Scanner(new FileManager(path).read()));
        getScanner().useDelimiter("\n");
    }
}
