package mock_final_exam.extra.q2;

public class TestDrive {
    public static void main(String[] args) {
        Component c1 = new Composite();
        Component c2 = new Composite();
        Component c3 = new Composite();

        Component l1 = new Leaf();
        Component l2 = new Leaf();
        Component l3 = new Leaf();
        Component l4 = new Leaf();

        ((Composite)c1).addComponent(c2);
        ((Composite)c2).addComponent(c3);

        ((Composite)c3).addComponent(l1);
        ((Composite)c3).addComponent(l2);
        ((Composite)c3).addComponent(l3);
        ((Composite)c3).addComponent(l4);

        Visitor collector = new ComponentCollector();
        Visitor counter = new ComponentCounter(collector);
        c1.accept(counter);

        System.out.println(((ComponentCounter)counter).getCount());
        System.out.println(((ComponentCounter)counter).getNextVisitor());
    }
}
