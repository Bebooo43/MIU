package assignments.lab8_composite;

public class File extends DriveComponent{
    private String name;
    private int sizeInBytes;

    public File(String name, int sizeInBytes) {
        this.name = name;
        this.sizeInBytes = sizeInBytes;
    }

    public int getSizeInBytes() {
        return sizeInBytes;
    }
    public void print(){
        System.out.println("--- file "+name+" size="+getSizeInBytes()+" bytes");
    }
}
