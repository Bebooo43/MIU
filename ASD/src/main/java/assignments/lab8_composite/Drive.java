package assignments.lab8_composite;

public class Drive {
    protected String name;
    protected DriveComponent driveComponent;

    public Drive(String name) {
        this.name = name;
        driveComponent = new Directory(name);
    }

    public void addDir(DriveComponent directory) {
        driveComponent.add(directory);
    }

    public int computeSize(){
        return driveComponent.getSizeInBytes();
    }
    public void print(){
        System.out.println("- drive " + name);
        driveComponent.print();
    }
}
