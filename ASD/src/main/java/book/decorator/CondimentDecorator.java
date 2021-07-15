package book.decorator;

public abstract class CondimentDecorator extends Beverage {
    Beverage beverage;

    public CondimentDecorator(){

    }
    public abstract String getDescription();

    public Size getSize() {
        return beverage.getSize();
    }
}
