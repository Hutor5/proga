package data;

public class Car implements Validateable{
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

    @Override
    public boolean validate() {
        return name!=null && cool!=null;
    }
}
