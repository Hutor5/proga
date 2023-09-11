package commands;

import transmission.Request;
import transmission.Response;
import util.Receiver;

public class PrintFieldDescendingWeaponType implements Command{
    private final Receiver receiver;

    public PrintFieldDescendingWeaponType(Receiver receiver) {
        this.receiver = receiver;

    }

    @Override
    public Response execute(Request request) {
        receiver.clearResponse();
        return receiver.printFieldDescendingWeaponType();
    }

    @Override
    public String getHelp() {
        return "Введите print_field_descending_weapon_type, чтобы вывести значения поля weaponType всех элементов в порядке убывания";
    }
}
