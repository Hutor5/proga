package transmission;

import content.HumanBeing;

import java.net.SocketAddress;

public class Request {
    private static final long serialVersionUID = 666777666L;
    private String commandName;
    private String  argument;
    private HumanBeing humanBeing;
    private SocketAddress clientAdress = null;

    public Request(String commandName, String argument, HumanBeing humanBeing){
        this(commandName, argument);
        this.humanBeing = humanBeing;
    }

    public Request(String commandName, String argument){
        this.commandName = commandName;
        this.argument = argument;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    public HumanBeing getHumanBeing() {
        return humanBeing;
    }

    public void setHumanBeing(HumanBeing humanBeing) {
        this.humanBeing = humanBeing;
    }

    public SocketAddress getClientAdress() {
        return clientAdress;
    }

    public void setClientAdress(SocketAddress clientAdress) {
        this.clientAdress = clientAdress;
    }
}
