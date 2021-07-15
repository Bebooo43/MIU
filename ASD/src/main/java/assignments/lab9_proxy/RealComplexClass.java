package assignments.lab9_proxy;

public class RealComplexClass implements ComplexClass{

    public RealComplexClass() throws InterruptedException {
        super();
        Thread.sleep(10000);
    }

    public void veryComplicatedTask() {
        System.out.println("Very complicated task...");
    }
}
