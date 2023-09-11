package content;

public enum WeaponType {
    HAMMER("Молот"),
    AXE("Топор"),
    RIFLE("Винтовка"),
    KNIFE("Нож"),
    MACHINE_GUN("Пулемёт");

    private final String title;

    WeaponType(String title) { this.title = title;}

    @Override
    public String toString() {return title;}
}
