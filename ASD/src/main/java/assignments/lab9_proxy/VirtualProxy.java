package assignments.lab9_proxy;

/**
 * Controls access to an object that is expensive to instantiate.
 */
public class VirtualProxy implements ComplexClass{
    volatile RealComplexClass complexClass;
    boolean retrieving = false;
    Thread retrievalThread;

    @Override
    public void veryComplicatedTask() {
        if(complexClass != null)
            complexClass.veryComplicatedTask();
        else{
            System.out.println("Loading complexClass, please wait...");
            if(!retrieving){
                retrieving = true;
                retrievalThread = new Thread(() -> {
                    try {
                        setComplexClass(new RealComplexClass());
                        complexClass.veryComplicatedTask();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                retrievalThread.start();
            }
        }
    }

    synchronized void setComplexClass(RealComplexClass complexClass) {
        this.complexClass = complexClass;
    }
}
