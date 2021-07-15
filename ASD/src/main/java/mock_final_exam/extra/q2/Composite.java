package mock_final_exam.extra.q2;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Composite extends Component {
    private Collection<Component> components = new LinkedList<>();

    public void addComponent(Component c) {
        components.add(c);
    }
    public void removeComponent(Component c) {
        components.remove(c);
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
        for(Component c : components) {
            c.accept(v);
        }
    }

    @Override
    public Iterator<Component> iterator() {
        return components.iterator();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
