package mock_final_exam.extra.q2;

import java.util.Iterator;

public abstract class Component implements Iterable<Component> {

    public abstract void accept(Visitor v);
    public Iterator<Component> iterator() {
        throw new UnsupportedOperationException();
    }
}
