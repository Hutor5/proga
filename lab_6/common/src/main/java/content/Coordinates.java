package content;

public class Coordinates {
    private long x;
    private int y; //Максимальное значение поля: 168
    public Coordinates(long x, int y){
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString(){
        String s = "";
        s += "{\"x\" : " + Long.toString(x) + ", ";
        s += "\"y\" : " + Integer.toString(y) + "}";
        return s;
    }

    public boolean validate(){
        return !(y<=168);
    }
}
