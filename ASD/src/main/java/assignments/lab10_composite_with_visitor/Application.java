package assignments.lab10_composite_with_visitor;

public class Application {
    public static void main(String[] args) {
        CEO ceo = new CEO("CEO");

        Manager manager1 = new Manager("manager1");
        Manager manager2 = new Manager("manager2");
        Manager manager3 = new Manager("manager3");

        Employee employee1 = new Employee("employee1");
        Employee employee2 = new Employee("employee2");
        Employee employee3 = new Employee("employee3");

        ceo.addHire(manager1);
        ceo.addHire(manager2);

        manager1.addHire(employee1);
        manager1.addHire(employee2);

        manager2.addHire(manager3);
        manager3.addHire(employee3);

        HireCounterAction visitor = new HireCounterAction();
        ceo.visit(visitor);
        System.out.println(visitor.getCount());

    }
}
