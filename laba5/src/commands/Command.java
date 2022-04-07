package commands;

import exceptions.CommandException;
import exceptions.WrongDataException;

@FunctionalInterface

public interface Command {
    void run(String arg) throws CommandException, WrongDataException;
}
