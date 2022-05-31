package commands;

public class Wrap {
    private final String argument;
    private final String command;
    public Wrap(String cmd, String arg){
        argument = arg;
        command = cmd;
    }
    public Wrap(String cmd){
        argument = null;
        command = cmd;
    }

    public String getCommand(){
        return command;
    }

    public String getArg(){
        return argument;
    }
}
