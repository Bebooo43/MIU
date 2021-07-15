package mock_final_exam.extra.q2;

public class ComponentCounter extends VisitorChain {

    // TODO
    private int count = 0;
    public int getCount() {
        return count;
    }

    public ComponentCounter(Visitor nextVisitor) {
        super(nextVisitor);
    }

    @Override
    protected void performVisit(Composite composite) {
        // TODO
        count++;
    }

    @Override
    protected void performVisit(Leaf leaf) {
        // TODO
        count++;
    }

}
