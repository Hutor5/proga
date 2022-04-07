package file;

public interface ReadWriteAble {
    void setPath(String pth);
    String read();
    boolean write(String data);
}
