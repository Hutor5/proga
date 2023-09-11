package content;

public class Car {
    private String name; //Поле может быть null
    private Boolean cool; //Поле может быть null

    public Car(String name, Boolean cool){
        this.name=name;
        this.cool=cool;
    }



    public String getName() {
        return name;
    }

    public Boolean getCool() {
        return cool;
    }

    public boolean validate() {
        return name!=null && cool!=null;
    }
}
