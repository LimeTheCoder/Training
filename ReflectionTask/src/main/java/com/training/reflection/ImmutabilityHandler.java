package com.training.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Invocation handler that used to disallow setters methods
 * and keep original object immutable
 *
 * @version 09 Nov 2016
 * @author Taras Sakharchuk
 */
public class ImmutabilityHandler implements InvocationHandler {
    /** Original object that been proxied */
    private Object obj;

    public ImmutabilityHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().startsWith("set")) {
            throw new IllegalAccessException();
        }
        return method.invoke(obj, args);
    }
}
