package content;

public interface Collectionable extends Comparable<Collectionable>{
    Integer getId();

    void setId(int ID);

    String getName();

    String getSoundtrackName();

    //String getWeaponType();

    int compareTo(Collectionable human);

    boolean validate();

    Double getImpactSpeed();
}