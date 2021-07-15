package mock_final_exam.extra.q1;

public class TestDrive {
    public static void main(String[] args) {
        Composite c1 = new Composite();
        Composite c2 = new Composite();
        Composite c3 = new Composite();

        Leaf l1 = new Leaf();
        Leaf l2 = new Leaf();
        Leaf l3 = new Leaf();
        Leaf l4 = new Leaf();

        c1.addComponent(c2);
        c2.addComponent(c3);

        c3.addComponent(l1);
        c3.addComponent(l2);
        c3.addComponent(l3);
        c3.addComponent(l4);

        ComponentCollector action = new ComponentCollector();
        c1.accept(action);
        action.getComponents().forEach(System.out::println);
    }
}
