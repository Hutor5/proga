package inout;

import data.Car;
import data.Coordinates;
import data.HumanBeing;
import data.WeaponType;
import exceptions.EmptyStringException;
import exceptions.WrongDataException;
import exceptions.WrongEnumValueException;
import exceptions.WrongNumberException;

import java.util.Scanner;

public interface InputManager {

    String readName() throws EmptyStringException;

    long readCoordX() throws WrongNumberException;

    int readCoordY() throws WrongNumberException;

    Coordinates readCoordinates() throws WrongNumberException;

    Boolean readRealHero() throws WrongDataException;

    boolean readHasToothpick() throws WrongDataException;

    Double readImpactSpeed() throws WrongDataException;

    String readSoundtrackName() throws WrongDataException;

    Integer readMinutesOfWaiting() throws WrongDataException;

    WeaponType readWeaponType() throws WrongEnumValueException;

    String readCarName() throws WrongDataException;

    Boolean readCarCool() throws WrongDataException;

    Car readCar() throws WrongDataException;

    HumanBeing readHumanBeing() throws WrongDataException;

    public Scanner getScanner();

    public void readCommand();
}
