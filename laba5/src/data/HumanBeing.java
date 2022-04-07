package data;

import java.time.*;
import java.util.Date;

public class HumanBeing implements Collectionable{
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Boolean realHero; //Поле не может быть null
    private boolean hasToothpick;
    private Double impactSpeed; //Поле не может быть null
    private String soundtrackName; //Поле не может быть null
    private Integer minutesOfWaiting; //Поле может быть null
    private WeaponType weaponType; //Поле не может быть null
    private Car car; //Поле не может быть null


    public HumanBeing(String name, Coordinates coordinates, Boolean realHero, boolean hasToothpick, Double impactSpeed, String soundtrackName, Integer minutesOfWaiting, WeaponType weaponType, Car car) {
        this.name = name;
        this.coordinates = coordinates;
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime creationDate = now.atZone(ZoneId.systemDefault());
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.soundtrackName = soundtrackName;
        this.minutesOfWaiting = minutesOfWaiting;
        this.weaponType = weaponType;
        this.car = car;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id=id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSoundtrackName() {
        return soundtrackName;
    }

    @Override
    public int compareTo(Collectionable humanBeing) {
        return 0;
    }

    @Override
    public boolean validate() {
        return (name!=null && !name.equals("")&&
        coordinates!=null && coordinates.validate() &&
        creationDate!=null &&
        realHero!=null &&
        impactSpeed!=null &&
        soundtrackName!=null &&
        minutesOfWaiting!=null &&
        weaponType!=null &&
        car!=null);
    }
}
