package collection;


import data.HumanBeing;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.TreeSet;
import data.HumanBeing;

public class HumanBeingCollectionManager implements CollectionManager<HumanBeing> {
    private TreeSet<HumanBeing> collection;
    private LocalDateTime initTime;
    private HashSet<Integer> uniqIDs;

    public HumanBeingCollectionManager(){
        collection = new TreeSet<>();
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

    }

    @Override
    public TreeSet<HumanBeing> getCollection() {
        return collection;
    }

    @Override
    public void add(HumanBeing humanBeing) {
        humanBeing.setId(generateID());
        collection.add(humanBeing);
        System.out.println("Добавленный элемент:");
        System.out.println(humanBeing.toString());
    }

    @Override
    public boolean checkID(Integer ID) {
        for (HumanBeing humanBeing : collection) if (humanBeing.getId() == ID) return true;
        return false;
    }

    @Override
    public void removeByID(Integer id) {

    }

    @Override
    public void updateByID(Integer id, HumanBeing newHumanBeing) {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public void removeLower(HumanBeing humanBeing) {

    }

    @Override
    public void addIfMin(HumanBeing humanBeing) {

    }

    @Override
    public void printElementsWithSoundtrackName(String soundtrackName) {

    }

    @Override
    public void printElementsWithName(String name) {

    }

    @Override
    public void printFieldDescendingWeaponType() {

    }

    @Override
    public boolean fromJsonCollection(String json) {
        return false;
    }

    @Override
    public String toJsonCollection() {
        return null;
    }
}
