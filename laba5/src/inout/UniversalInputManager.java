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

public abstract class UniversalInputManager implements InputManager{
    private Scanner scanner;

    public UniversalInputManager(Scanner scanner){
        this.scanner=scanner;
        scanner.useDelimiter("\n");
    }

    @Override
    public String readName() throws EmptyStringException {
        String s = scanner.nextLine().trim();
        if (s.equals("")){
            throw new EmptyStringException();
        }
        return s;
    }

    @Override
    public long readCoordX() throws WrongNumberException {
        long x;
        try{
            x = Long.parseLong(scanner.nextLine());
        }catch(NumberFormatException e){
            throw new WrongNumberException();
        }
        if (Float.isInfinite(x) || Float.isNaN(x)) throw new WrongNumberException("Неправильное значение x");
        return x;
    }

    @Override
    public int readCoordY() throws WrongNumberException {
        int y;
        try{
            y = Integer.parseInt(scanner.nextLine());
        }catch(NumberFormatException e){
            throw new WrongNumberException();
        }
        if (y>168) throw new WrongNumberException("y не может быть больше 168");
        return y;
    }

    @Override
    public Coordinates readCoordinates() throws WrongNumberException {
        long x = readCoordX();
        int y = readCoordY();
        Coordinates coordinates = new Coordinates(x, y);
        return coordinates;
    }

    @Override
    public Boolean readRealHero() throws WrongDataException {
        Boolean realHero;
        try{
            realHero = Boolean.parseBoolean(scanner.nextLine());
        }catch (NullPointerException e){
            throw new WrongDataException("неправильный формат данных");
        }
        return realHero;
    }

    @Override
    public boolean readHasToothpick() throws WrongDataException {
        boolean hasToothpick;
        try{
            hasToothpick = Boolean.parseBoolean(scanner.nextLine());
        }catch (NullPointerException e){
            throw new WrongDataException("неправильный формат данных");
        }
        return hasToothpick;
    }

    @Override
    public Double readImpactSpeed() throws WrongDataException {
        Double impactSpeed;
        try{
            impactSpeed = Double.parseDouble(scanner.nextLine());
        }catch (NumberFormatException e){
            throw new WrongDataException("неправильный формат данных");
        }
        if (Double.isInfinite(impactSpeed) || Double.isNaN(impactSpeed)) throw new WrongNumberException("Неправильное значение impactSpeed");
        return impactSpeed;
    }

    @Override
    public String readSoundtrackName() throws WrongDataException {
        String soundtrackName = scanner.nextLine().trim();
        if (soundtrackName==null) throw new WrongDataException("неправильный формат данных");
        return soundtrackName;
    }

    @Override
    public Integer readMinutesOfWaiting() throws WrongDataException {
        Integer minutesOfWaiting;
        try {
            minutesOfWaiting = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e){
            throw new WrongDataException("неправильный формат данных");
        }
        if (Float.isInfinite(minutesOfWaiting) || Float.isNaN(minutesOfWaiting)) throw new WrongNumberException("Неправильное значение minutesOfWaiting");
        return minutesOfWaiting;
    }

    @Override
    public WeaponType readWeaponType() throws WrongEnumValueException {
        String s = scanner.nextLine().trim();
        if (s.equals("")){
            throw new WrongEnumValueException();
        }
        try{
            return WeaponType.valueOf(s);
        }catch(IllegalArgumentException e){
            throw new WrongEnumValueException();
        }
    }

    @Override
    public String readCarName() throws WrongDataException {
        String name = scanner.nextLine().trim();
        if (name==null) throw new WrongDataException("неправильный формат данных");
        return name;
    }

    @Override
    public Boolean readCarCool() throws WrongDataException {
        Boolean cool;
        try{
            cool = Boolean.parseBoolean(scanner.nextLine());
        }catch (NullPointerException e){
            throw new WrongDataException("неправильный формат данных");
        }
        return cool;
    }

    @Override
    public Car readCar() throws WrongDataException {
        String name = readCarName();
        Boolean cool = readCarCool();
        Car car = new Car(name, cool);
        return car;
    }

    @Override
    public HumanBeing readHumanBeing() throws WrongDataException {
        HumanBeing humanBeing = null;
        String name = readName();
        Coordinates coordinates = readCoordinates();
        Boolean realHero = readRealHero();
        boolean hasToothpick = readHasToothpick();
        Double impactSpeed = readImpactSpeed();
        String soundtrackName = readSoundtrackName();
        Integer minutesOfWaiting = readMinutesOfWaiting();
        WeaponType weaponType = readWeaponType();
        Car car = readCar();
        humanBeing=new HumanBeing(name, coordinates, realHero, hasToothpick, impactSpeed, soundtrackName, minutesOfWaiting, weaponType, car);
        return humanBeing;
    }

    @Override
    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner){
        this.scanner=scanner;
    }

    public void readCommand(){}

}
