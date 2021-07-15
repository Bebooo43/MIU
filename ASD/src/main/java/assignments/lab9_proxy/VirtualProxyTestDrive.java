package assignments.lab9_proxy;

import java.lang.reflect.Proxy;

public class VirtualProxyTestDrive {
    public static void main(String[] args) throws InterruptedException {
        //dynamic proxy
        VirtualProxyTestDrive test = new VirtualProxyTestDrive();

        System.out.println("starting...");
        ComplexClass complexClass = test.getComplexClassProxy();
        complexClass.veryComplicatedTask();

        System.out.println("second call");
        complexClass.veryComplicatedTask();
    }

    ComplexClass getComplexClassProxy() throws InterruptedException {
        ComplexClass complexClass = new RealComplexClass();
        return (ComplexClass) Proxy.newProxyInstance(
                complexClass.getClass().getClassLoader(),
                complexClass.getClass().getInterfaces(),
                new ComplexClassInvocationHandler(complexClass));
    }
}
