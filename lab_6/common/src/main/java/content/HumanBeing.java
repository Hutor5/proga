package content;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

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
        this.creationDate = creationDate;
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.soundtrackName = soundtrackName;
        this.minutesOfWaiting = minutesOfWaiting;
        this.weaponType = weaponType;
        this.car = car;
    }

    public HumanBeing(Integer id, String name, Coordinates coordinates, ZonedDateTime creationDate, Boolean realHero, boolean hasToothpick, Double impactSpeed, String soundtrackName, Integer minutesOfWaiting, WeaponType weaponType, Car car) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime creationDate1 = now.atZone(ZoneId.systemDefault());
        this.creationDate = creationDate1;
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.soundtrackName = soundtrackName;
        this.minutesOfWaiting = minutesOfWaiting;
        this.weaponType = weaponType;
        this.car = car;
    }

    @Override
    public Integer getId() {
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

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String getSoundtrackName() {
        return soundtrackName;
    }

    public WeaponType getWeaponType(){
        return weaponType;
    }

    @Override
    public int compareTo(Collectionable humanBeing) {
        int ok = Double.compare(this.impactSpeed, humanBeing.getImpactSpeed());
        return ok;
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
                car!=null && car.validate());
    }

    @Override
    public Double getImpactSpeed() {
        return impactSpeed;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss Z");
        String formattedDate = creationDate.format(formatter);
        String s = "";
        s += "{\n";
        s += "  \"id\" : " + Integer.toString(id) + ",\n";
        s += "  \"name\" : " + "\"" + name + "\"" + ",\n";
        s += "  \"coordinates\" : " + coordinates.toString() + ",\n";
        s += "  \"creationDate\" : " + "\"" + formattedDate + "\"" + ",\n";
        s += "  \"realHero\" : " + "\"" + Boolean.toString(realHero) + "\"" + ",\n";
        s += "  \"hasToothpick\" : " + "\"" + hasToothpick + "\"" + ",\n";
        s += "  \"impactSpeed\" : " + "\"" + Double.toString(impactSpeed) + "\"" + ",\n";
        s += "  \"soundtrackName\" : " + "\"" + soundtrackName + "\"" + ",\n";
        s += "  \"minutesOfWaiting\" : " + "\"" + Integer.toString(minutesOfWaiting) + "\"" + ",\n";
        s += "  \"weaponType\" : " + "\"" + weaponType.toString() + "\"" + ",\n";
        if (car!=null) s += "  \"car\" : " + "\"" + car.toString()+ "\"" + "\n";
        s += "}";
        return s;
    }

    public String toShow(){
        return "Человеческое существо: \"" + name + "\", id: " + id + ";";
    }
}
