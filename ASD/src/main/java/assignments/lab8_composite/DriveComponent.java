package assignments.lab8_composite;

public abstract class DriveComponent {

    public void add(DriveComponent component){
        throw new UnsupportedOperationException();
    }

    public void remove(DriveComponent component){
        throw new UnsupportedOperationException();
    }

    public int getSizeInBytes(){
        throw new UnsupportedOperationException();
    }

    public void print(){
        throw new UnsupportedOperationException();
    }
}
