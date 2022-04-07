package commands;

public interface Commandable {

        void addCommand(String key, Command cmd);

        void runCommand(String key, String arg);

        void runCommand(String key);

        boolean hasCommand(String s);

        void consoleMode();

        void fileMode(String path);
}


