package data;

public interface Collectionable extends Comparable<Collectionable>, Validateable{
    int getId();

    void setId(int ID);

    String getName();

    String getSoundtrackName();

    //String getWeaponType();

    int compareTo(Collectionable human);

    boolean validate();
}
