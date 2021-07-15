package mock_final_exam.extra.q2;

public abstract class VisitorChain implements Visitor {
    private Visitor nextVisitor;

    public Visitor getNextVisitor() {
        return nextVisitor;
    }

    public VisitorChain(Visitor nextVisitor) {
        super();
        this.nextVisitor = nextVisitor;
    }
    public void visit(Composite composite) {
        performVisit(composite);
        //TODO
        nextVisitor.visit(composite);
    }
    public void visit(Leaf leaf) {
        performVisit(leaf);
        // TODO
        nextVisitor.visit(leaf);
    }
    protected abstract void performVisit(Leaf leaf);
    protected abstract void performVisit(Composite composite);
}
