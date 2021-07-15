package assignments.lab10_composite_with_visitor;

public class HireCounterAction implements Visitor {

    int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public void visit(Employee employee) {
        System.out.println("-"+ employee.getName());
        count++;
    }

    @Override
    public void visit(Manager manager) {
        System.out.println(manager.getName());
        count++;
    }
}
