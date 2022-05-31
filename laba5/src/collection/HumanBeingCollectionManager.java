package collection;


import com.google.gson.reflect.TypeToken;
import data.HumanBeing;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;
import com.google.gson.*;

import data.WeaponType;
import json.*;

public class HumanBeingCollectionManager implements CollectionManager<HumanBeing> {
    private TreeSet<HumanBeing> collection;
    private LocalDateTime initTime;
    private HashSet<Integer> uniqIDs;

    public HumanBeingCollectionManager(){
        collection = new TreeSet<HumanBeing>();
        initTime = java.time.LocalDateTime.now();
        uniqIDs = new HashSet<>();
    }

    @Override
    public int generateID() {
        if (collection.isEmpty()) return 1;
        else{
             Integer id = collection.last().getId() + 1;
            if (uniqIDs.contains(id)) while (uniqIDs.contains(id)) id += 1;
            uniqIDs.add(id);
            return id;
        }
    }

    @Override
    public String getInfo() {
        return "TreeSet из HumanBeing, размер: " + Integer.toString(collection.size()) + ", время инициализации: " + initTime.toString();
    }

    @Override
    public void sort() {
        //Collections.sort(collection);
    }

    @Override
    public TreeSet<HumanBeing> getCollection() {
        return collection;
    }

    @Override
    public void add(HumanBeing humanBeing) {
        humanBeing.setId(generateID());
        collection.add(humanBeing);
        //boolean ok = collection.add(humanBeing);
        System.out.println("Добавленный элемент:"); //+ ok);
        System.out.println(humanBeing.toString());
        //System.out.println(toJsonCollection());
        //return ok;
    }

    @Override
    public boolean checkID(Integer ID) {
        for (HumanBeing humanBeing : collection) if (humanBeing.getId() == ID) return true;
        return false;
    }

    @Override
    public void removeByID(Integer id) {
        for (HumanBeing humanBeing : collection){
            if (humanBeing.getId() == id){
                collection.remove(humanBeing);
                uniqIDs.remove(id);
                System.out.println("Элемент №"+Integer.toString(id)+" успешно удалён");
            }
        }
    }

    @Override
    public void updateByID(Integer id, HumanBeing newHumanBeing) {
        int idx = 0;
        for (HumanBeing humanBeing : collection){
            if (humanBeing.getId() == id){
                humanBeing.setId(id);
                //collection.put(idx);
                System.out.println("Элемент №"+Integer.toString(id)+" успешно обновлён");
            }
            idx += 1;
        }
    }

    @Override
    public int getSize() {
        return collection.size();
    }

    @Override
    public void clear() {
        collection.clear();
        uniqIDs.clear();
    }

    @Override
    public void removeLower(HumanBeing humanBeing) {
        for (HumanBeing humanBeing1: collection){
            if (humanBeing.getImpactSpeed()>humanBeing1.getImpactSpeed()) removeByID(humanBeing.getId());
        }
    }

    @Override
    public void addIfMin(HumanBeing humanBeing) {
        for (HumanBeing humanBeing1: collection){
            if (humanBeing.compareTo(humanBeing1)==1){
                System.out.println("Невозможно добавить");
                return;
            }
        }
        add(humanBeing);
    }

    @Override
    public void printElementsWithSoundtrackName(String soundtrackName) {
        LinkedList<HumanBeing> list = new LinkedList<>();
        for (HumanBeing humanBeing : collection){
            if (humanBeing.getSoundtrackName().equals(soundtrackName.trim())){
                list.add(humanBeing);
            }
        }
        if (list.isEmpty()) System.out.println("Нет элементов, содержащих " + soundtrackName);
        else{
            System.out.println("Содержит: " + soundtrackName);
            for (HumanBeing humanBeing: list){
                System.out.println(humanBeing.toString());
            }
        }
    }

    @Override
    public void printElementsWithName(String name) {
        LinkedList<HumanBeing> list = new LinkedList<>();
        for (HumanBeing humanBeing : collection){
            if (humanBeing.getName().contains(name.trim())){
                list.add(humanBeing);
            }
        }
        if (list.isEmpty()) System.out.println("Нет элементов, содержащих " + name);
        else{
            System.out.println("Содержит: " + name);
            for (HumanBeing humanBeing: list){
                System.out.println(humanBeing.toString());
            }
        }
    }

    @Override
    public void printFieldDescendingWeaponType() {
        //LinkedList<WeaponType> list = new LinkedList<>();
        for (HumanBeing humanBeing: collection){
            System.out.println(humanBeing.getWeaponType());
        }
        //list.sort();
    }

    @Override
    public boolean fromJsonCollection(String json) {
        boolean luck = true;
        try {
            if (json == null || json.equals("")){
                collection =  new TreeSet<HumanBeing>();
            } else {
                Type collectionType = new TypeToken<TreeSet<HumanBeing>>(){}.getType();
                Gson gson = new GsonBuilder()
                        .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
                        .registerTypeAdapter(Date.class, new DateDeserializer())
                        .registerTypeAdapter(collectionType, new CollectionDeserializer(uniqIDs))
                        .create();
                collection = gson.fromJson(json.trim(), collectionType);
            }
        } catch (JsonParseException e){
            luck = false;
            System.err.println("Неправильный json файл");
        }
        return luck;
    }

    @Override
    public String toJsonCollection() {
        if (collection == null || collection.isEmpty()) return "";
        Gson gson = new GsonBuilder()
                //.registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
                .registerTypeAdapter(ZonedDateTime.class, new DateSerializer())
                .setPrettyPrinting().create();
        String json = gson.toJson(collection);
        return json;
    }

}
