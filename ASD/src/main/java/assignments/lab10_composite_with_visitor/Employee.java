package assignments.lab10_composite_with_visitor;

public class Employee implements HireComponent {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }
}
