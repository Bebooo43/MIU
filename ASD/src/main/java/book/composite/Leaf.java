package book.composite;

import java.util.function.Consumer;

public class Leaf extends Component{

    public Leaf(String name) {
        super(name);
    }
    @Override
    public void print() {
        System.out.println(getName());
    }

    @Override
    public void forEach(Consumer<Component> action) {//visitor design pattern
        action.accept(this);
    }
}
