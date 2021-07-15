package book.strategy;

public class RubberDuck extends Duck{

    public RubberDuck() {
        super(new FlyNoWay(), new Squeak());
    }

    @Override
    void display() {
        System.out.println("Printing Rubber Duck");
    }
}
