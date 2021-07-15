package assignments.lab9_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ComplexClassInvocationHandler implements InvocationHandler {

    ComplexClass complexClass;

    public ComplexClassInvocationHandler(ComplexClass complexClass){
        this.complexClass = complexClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        try {
            if(method.getName().startsWith("veryComplicatedTask"))
                return method.invoke(complexClass,args);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
