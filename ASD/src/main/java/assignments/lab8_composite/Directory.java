package assignments.lab8_composite;

import java.util.ArrayList;
import java.util.Collection;

public class Directory extends DriveComponent{
    protected String name;
    protected Collection<DriveComponent> driveComponents;

    public Directory(String name) {
        this.name = name;
        this.driveComponents = new ArrayList<>();
    }
    public void print(){
        System.out.println("-- dir "+name+" size="+getSizeInBytes()+" bytes");
        for (DriveComponent component : driveComponents) {
            component.print();
        }
    }

    public void add(DriveComponent driveComponent) {
        driveComponents.add(driveComponent);
    }

    @Override
    public int getSizeInBytes() {
        int sizeInBytes=0;
        for (DriveComponent driveComponent : driveComponents){
            sizeInBytes+= driveComponent.getSizeInBytes();
        }
        return sizeInBytes;
    }
}
