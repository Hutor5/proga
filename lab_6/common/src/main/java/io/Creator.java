package io;

import content.Car;
import content.Coordinates;
import content.HumanBeing;
import content.WeaponType;

import java.time.ZonedDateTime;

public class Creator {
    public static HumanBeing createHumanBeing(){
        Typer typer = new Typer();
        String name = typer.nameInput();
        Coordinates coordinates = typer.coordinatesInput();
        Boolean realHero = typer.realHeroInput();
        boolean hasToothpick = typer.hasToothpickInput();
        Double impactSpeed = typer.impactSpeedInput();
        String soundtrackName = typer.soundtrackNameInput();
        Integer minutesOfWaiting = typer.minutesOfWaitingInput();
        WeaponType weaponType = typer.weaponTypeInput();
        Car car = typer.carInput();
        return new HumanBeing(name, coordinates, realHero, hasToothpick, impactSpeed, soundtrackName, minutesOfWaiting, weaponType, car);
    }

    public static HumanBeing createByArray(String [] line, long i){

        if (line.length != 11){
            return null;
        }

        Validator validator = new Validator();
        Integer id = validator.checkIdValid(line[0]);
        String name = validator.checkNameValid(line[1]);
        Coordinates coordinates = validator.checkCoordinatesValid(line[2]);
        ZonedDateTime creationDate = validator.checkDataValid(line[3]);
        Boolean realHero = validator.checkRealHeroValid(line[4]);
        Boolean hasToothPick = validator.checkHasToothpickValid(line[5]);
        Double impactSpeed = validator.checkImpactSpeedValid(line[6]);
        String soundtrackName = validator.checkSoundtrackNameValid(line[7]);
        Integer minutesOfWaiting = validator.checkMinutesOfWaitingValid(line[8]);
        WeaponType weaponType = validator.checkWeaponTypeByNameValid(line[9]);
        String carName = validator.checkCarNameValid(line[11]);
        Boolean carCool = validator.checkCarCoolValid(line[10]);

        if (id == null || name == null || coordinates == null || creationDate == null || realHero == null || hasToothPick == null
                || impactSpeed == null || soundtrackName == null || minutesOfWaiting == null || weaponType == null || carCool == null || carName == null)
            return null;
        Car car = new Car(carName, carCool);

        return new HumanBeing(id, name, coordinates, creationDate, realHero, hasToothPick, impactSpeed, soundtrackName, minutesOfWaiting, weaponType,
                car);

    }

}
