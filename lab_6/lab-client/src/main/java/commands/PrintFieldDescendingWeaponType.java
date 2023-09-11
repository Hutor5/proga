package commands;

import transmission.Request;

public class PrintFieldDescendingWeaponType implements Command{
    @Override
    public Request check(String argument) {
        if (argument != null){
            System.out.println("Команда print_field_descending_weapon_type не принимает аргументы.");
            return null;
        }
        return new Request("print_field_descending_weapon_type", null);
    }
}
