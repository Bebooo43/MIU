package mock_final_exam.extra.q2;

import java.util.Collection;
import java.util.LinkedList;

public class ComponentCollector implements Visitor {

    private Collection<Component> components;

    public ComponentCollector(){components = new LinkedList<>();}

    @Override
    public void visit(Composite composite) {
        components.add(composite);
    }

    @Override
    public void visit(Leaf leaf) {
        components.add(leaf);
    }

    public Collection<Component> getComponents() {
        return components;
    }
}
