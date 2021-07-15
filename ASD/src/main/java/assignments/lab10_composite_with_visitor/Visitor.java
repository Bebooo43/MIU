package assignments.lab10_composite_with_visitor;

public interface Visitor {
    void visit(Employee employee);
    void visit(Manager manager);
}
