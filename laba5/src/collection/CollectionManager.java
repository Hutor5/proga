package collection;

import java.util.TreeSet;

public interface CollectionManager<T> {
    int generateID();

    String getInfo();

    void sort();

    TreeSet<T> getCollection();

    void add(T element);

    boolean checkID(Integer ID);

    void removeByID(Integer id);

    void updateByID(Integer id, T newElement);

    int getSize();

    void clear();

    void removeLower(T element);

    void addIfMin(T element);

    void printElementsWithSoundtrackName(String soundtrackName);

    void printElementsWithName(String name);

    void printFieldDescendingWeaponType();

    boolean fromJsonCollection(String json);

    String toJsonCollection();


}
