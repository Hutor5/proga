package util;

import content.HumanBeing;
import io.Creator;
import transmission.Request;

public class Valisender {
    public Request add(){
        HumanBeing humanBeing = Creator.createHumanBeing();
        return new Request("add", null, humanBeing);
    }

    public Request addIfMin(){
        HumanBeing humanBeing = Creator.createHumanBeing();
        return new Request("add_if_min", null, humanBeing);
    }

    public Request removeLower(){
        HumanBeing humanBeing = Creator.createHumanBeing();
        return new Request("remove_lower", null, humanBeing);
    }

    public Request removeByID(String argument){
        try{
            int id = Integer.parseInt(argument);
        } catch (NumberFormatException e) {
            System.out.println("Аргумент id должен быть типа int.");
            return null;
        }
        return new Request("remove_by_id", argument);
    }

    public Request updateId(String argument){
        try{
            int id = Integer.parseInt(argument);
        } catch (NumberFormatException e) {
            System.out.println("Аргумент id должен быть типа int");
            return null;
        }
        System.out.println("Создайте человеческое существо, которое заменит человеческое существо с выбранным вами значением поля id:");
        HumanBeing humanBeing = Creator.createHumanBeing();
        return new Request("update", argument, humanBeing);
    }


}
