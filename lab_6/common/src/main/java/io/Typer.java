package io;

import content.Car;
import content.Coordinates;
import content.WeaponType;

import java.util.Scanner;

public class Typer {
    private final Scanner scanner = new Scanner(System.in);
    private final Validator validator = new Validator();

    protected String nameInput() {

        System.out.print("Введите имя человеческого существа:" + "\n>");

        String name = validator.checkNameValid(scanner.nextLine());

        if (name == null){
            System.out.println("Пустая строка не может быть именем");
            return nameInput();
        }

        return name;
    }

    protected Coordinates coordinatesInput(){

        System.out.print("Введите координаты x и y через точку с запятой:"  + "\n>");

        Coordinates coordinates = validator.checkCoordinatesValid(scanner.nextLine());

        if (coordinates == null){
            System.out.println("Координат должно быть две. Координата x должна быть типа long, а y - int. Координата y должна превышать 168.");
            return coordinatesInput();
        }

        return coordinates;

    }

    protected Boolean realHeroInput(){

        System.out.print("Введите параметр realHero (0 или 1) :" + "\n>");

        Boolean realHero = validator.checkRealHeroValid(scanner.nextLine());

        if (realHero == null){
            System.out.println("Параметр realHero должен быть типа Boolean");
            return realHeroInput();
        }

        return realHero;

    }

    protected boolean hasToothpickInput(){

        System.out.print("Введите параметр hasToothpick (0 или 1):" + "\n>");

        boolean hasToothpick = validator.checkHasToothpickValid(scanner.nextLine());

//        if (hasToothpick == null){
//            System.out.println("Значение параметра hasToothpick должно быть типа boolean");
//            return hasToothpickInput();
//        }

        return hasToothpick;

    }

    protected Double impactSpeedInput(){

        System.out.print("Введите параметр impactSpeed:" + "\n>");

        Double impactSpeed= validator.checkImpactSpeedValid(scanner.nextLine());

        if (impactSpeed == null){
            System.out.println("Значение параметра impactSpeed должно быть типа Double");
            return impactSpeedInput();
        }

        return impactSpeed;

    }

    protected String soundtrackNameInput(){
        System.out.println("Введите параметр soundtrackName:"+"\n>");
        String soundtrackName = validator.checkSoundtrackNameValid(scanner.nextLine());

        if (soundtrackName == null){
            System.out.println("Значение параметра soundtrackName должно быть типа String. Пустая строка не является корректным значением");
            return soundtrackNameInput();
        }

        return soundtrackName;
    }

    protected Integer minutesOfWaitingInput(){
        System.out.println("Введите параметр minutesOfWaiting:"+"\n>");
        Integer minutesOfWaiting = validator.checkMinutesOfWaitingValid(scanner.nextLine());

        if (minutesOfWaiting == null){
            System.out.println("Значение параметра impactSpeed должно быть типа Integer");
            return minutesOfWaitingInput();
        }

        return minutesOfWaiting;
    }


    protected WeaponType weaponTypeInput(){

        System.out.println("Выберите тип оружия (цифра) :");

        int i = 1;

        for (WeaponType weaponType : WeaponType.values()){
            System.out.println(i++ + ") " + weaponType.toString());
        }
        System.out.print(">");

        WeaponType weaponType = validator.checkWeaponTypeByNumValid(scanner.nextLine());

        if (weaponType == null){
            System.out.println("Выберите одну из предложенных цифр.");
            return weaponTypeInput();
        }

        return weaponType;

    }

    protected Car carInput(){
        System.out.println("Введите данные о машине:");
        String name = carNameInput();
        Boolean cool = coolInput();
        Car car = new Car(name, cool);
        return car;
    }

    private Boolean coolInput(){

        System.out.println("Введите параметр cool машины (0 или 1) :"+"\n>");
        Boolean cool = validator.checkCarCoolValid(scanner.nextLine());
        if (cool == null){
            System.out.println("Параметр cool должен быть типа Boolean");
            return coolInput();
        }
        return cool;
    }

    private String carNameInput(){

        System.out.println("Введите имя машины:"+"\n>");
        String carName = validator.checkCarNameValid(scanner.nextLine());
        if (carName == null){
            System.out.println("Имя машины не может быть пустой строкой");
            return carNameInput();
        }
        return carName;
    }
}
