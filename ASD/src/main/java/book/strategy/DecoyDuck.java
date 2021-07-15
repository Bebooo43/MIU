package book.strategy;

public class DecoyDuck extends Duck{

    public DecoyDuck() {
        super(new FlyNoWay(), new MuteQuack());
    }

    @Override
    void display() {
        System.out.println("Printing Decoy Duck");
    }
}
