package book.strategy;

public class DuckModel extends Duck{

    public DuckModel() {
        super(new FlyNoWay(), new Quack());
    }

    @Override
    void display() {
        System.out.println("I'm a Model Duck");
    }
}
