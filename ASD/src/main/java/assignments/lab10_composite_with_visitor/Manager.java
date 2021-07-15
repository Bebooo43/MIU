package assignments.lab10_composite_with_visitor;

import java.util.ArrayList;
import java.util.Collection;

public class Manager implements HireComponent {
    protected String name;
    protected Collection<HireComponent> hires;

    public Manager(String name) {
        this.name = name;
        this.hires = new ArrayList<>();
    }

    public void addHire(HireComponent hire){
        hires.add(hire);
    }
    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        hires.forEach(h -> h.accept(visitor));
    }
}
