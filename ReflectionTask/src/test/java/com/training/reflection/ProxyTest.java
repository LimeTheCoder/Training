package com.training.reflection;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

public class ProxyTest {
    private IStudent proxy;
    private Student original;

    @Before
    public void init() {
        original = new Student(12, "Jessy", "Lu", Course.FRESHMAN);
        proxy = (IStudent) Proxy.newProxyInstance(Student.class.getClassLoader(),
                new Class[] {IStudent.class},
                new ImmutabilityHandler(original));
    }

    @Test(expected = UndeclaredThrowableException.class)
    public void testImmutability() {
        assertEquals(original.getId(), proxy.getId());
        proxy.setId(21);
    }
}
