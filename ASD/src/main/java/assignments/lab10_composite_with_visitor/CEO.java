package assignments.lab10_composite_with_visitor;

public class CEO {
    protected String name;
    protected HireComponent manager;

    public CEO(String name) {
        this.name = name;
        manager = new Manager(name);
    }

    public void addHire(HireComponent hire) {
        this.manager.addHire(hire);
    }
    public void visit(Visitor action) {
        manager.accept(action);
    }
}
