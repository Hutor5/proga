package io;

import content.Car;
import content.Coordinates;
import content.WeaponType;

import java.time.ZonedDateTime;

public class Validator {

    protected Integer checkIdValid(String input){
        int id;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e){
            return null;
        }
        return id;
    }

    protected String checkNameValid(String name){
        if (name.isEmpty()){
            return null;
        } else {
            return name;
        }
    }

    protected Coordinates checkCoordinatesValid(String input){

        String[] coordinates = input.trim().split(";");

        if (coordinates.length != 2){
            return null;
        }

        String xstring = coordinates[0];
        String ystring = coordinates[1];
        long x;
        int y;

        try {
            x = Long.parseLong(xstring);
            y = Integer.parseInt(ystring);
            if (y >= 168){
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e){
            return null;
        }
        return new Coordinates(x, y);
    }

    protected ZonedDateTime checkDataValid(String input){
        ZonedDateTime dateTime;
        try {
            dateTime = ZonedDateTime.parse(input);
        } catch (Exception e){
            return null;
        }
        return dateTime;
    }

    protected Boolean checkRealHeroValid(String input){
        if (input.equals("1")){return true;}
        else if (input.equals("0")){return false;}
        else{return null;}
    }

    protected boolean checkHasToothpickValid(String input){
        if (input == "1"){return true;}
        else if (input == "0"){return false;}
        else{return false;}
    }

    protected Double checkImpactSpeedValid(String input){
        if (input.isEmpty()){return null;}
        else {return Double.parseDouble(input);}
    }

    protected String checkSoundtrackNameValid(String input){
        if (input.isEmpty()){return null;}
        else {return input;}
    }

    protected Integer checkMinutesOfWaitingValid(String input){
        if (input.isEmpty()){return null;}
        else {return Integer.parseInt(input);}
    }

    protected WeaponType checkWeaponTypeByNumValid(String input){
        for (WeaponType weaponType : WeaponType.values()){
            if (weaponType.toString().equals(input)){return weaponType;}
        }
        return null;
    }

    protected WeaponType checkWeaponTypeByNameValid(String input){

        for (WeaponType weaponType : WeaponType.values()){
            if (weaponType.toString().equals(input)){
                return weaponType;
            }
        }
        return null;
    }

    protected Boolean checkCarCoolValid(String input){
        if (input.equals("1")){return true;}
        else if (input.equals("0")){return false;}
        else{return null;}
    }

    protected String checkCarNameValid(String input){
        if (input.isEmpty()){return null;}
        else {return input;}
    }

}
