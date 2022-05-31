package inout;

import data.Car;
import data.Coordinates;
import data.HumanBeing;
import data.WeaponType;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleInputManager extends UniversalInputManager{
    public ConsoleInputManager() {
        super(new Scanner(System.in));
        getScanner().useDelimiter("\n");
    }

    @Override
    public String readName(){
        return new Question<String>("Введите name:", super::readName).getAnswer();
    }

    @Override
    public long readCoordX(){
        return new Question<Long>("Введите x:", super::readCoordX).getAnswer();
    }

    @Override
    public int readCoordY(){
        return new Question<Integer>("Введите y:", super::readCoordY).getAnswer();
    }

    public Boolean readRealHero(){return new Question<Boolean>("Введите realHero: ", super::readRealHero).getAnswer();}

    public boolean readHasToothpick(){return new Question<Boolean>("Введите hasToothpick: ", super::readHasToothpick).getAnswer();}

    public Double readImpactSpeed(){return new Question<Double>("Введите impactSpeed: ", super::readImpactSpeed).getAnswer();}

    public String readSoundtrackName(){return new Question<String>("Введите soundtrackName: ", super::readSoundtrackName).getAnswer();}

    public Integer readMinutesOfWaiting(){return new Question<Integer>("Введите minutesOfWaiting: ", super::readMinutesOfWaiting).getAnswer();}

    public WeaponType readWeaponType(){return new Question<WeaponType>("Введите WeaponType: ", super::readWeaponType).getAnswer();}

    public String readCarName(){return new Question<String>("Введите carName: ", super::readCarName).getAnswer();}

    public Boolean readCarCool(){return new Question<Boolean>("Введите cool: ", super::readCarCool).getAnswer();}

    @Override
    public Coordinates readCoordinates(){
        System.out.println("Введите координаты");
        long x = readCoordX();
        int y = readCoordY();
        Coordinates coord = new Coordinates(x,y);
        return coord;
    }

    public Car readCar(){
        System.out.println("Введите данные о машине");
        String name = readCarName();
        Boolean cool = readCarCool();
        Car car = new Car(name, cool);
        return car;
    }

    @Override
    public HumanBeing readHumanBeing(){
        String name = readName();
        Coordinates coords = readCoordinates();
        Boolean realHero = readRealHero();
        boolean hasToothpick = readHasToothpick();
        Double impactSpeed = readImpactSpeed();
        String soundtrackName = readSoundtrackName();
        Integer minutesOfWaiting = readMinutesOfWaiting();
        WeaponType weaponType = readWeaponType();
        Car car = readCar();
        return new HumanBeing(name, coords, realHero, hasToothpick, impactSpeed, soundtrackName, minutesOfWaiting, weaponType, car);
    }
}

