package assignments.lab10_composite_with_visitor;

public interface HireComponent {
    void accept(Visitor action);
    default void addHire(HireComponent component){
        throw new UnsupportedOperationException();
    }
}
