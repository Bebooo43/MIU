package book.composite;

import java.util.List;
import java.util.function.Consumer;

public class Composite extends Component{

    private List<Component> components;

    public Composite(String name, List<Component> components) {
        super(name);
        this.components = components;
    }

    //INCOMPLETE - REVIEW CLASS JULY 1 THURSDAY
    @Override
    public void print() {
        System.out.println(getName());
        components.forEach(c -> c.print());
    }

    @Override
    public void forEach(Consumer<Component> action) {
        components.forEach(c -> action.accept(c));
    }
}
