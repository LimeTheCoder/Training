package com.training.reflection;


import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ReflectionRunner {
    public static void main(String[] args) {
        Class c = Student.class;
        Student student = new Student(12, "Jessy", "Lu", Course.FRESHMAN);
        invokeAnnotated(student);
        printMethods(Student.class);
        printMethods(DiplomaStudent.class);
        printSuperClass(DiplomaStudent.class);

        IStudent proxy = (IStudent) Proxy.newProxyInstance(Student.class.getClassLoader(),
                new Class[] {IStudent.class},
                new ImmutabilityHandler(student));
        System.out.println(proxy.getName());
        proxy.setName("Andrew");
    }

    /**
     * Display information about all methods in given class.
     *
     * @param clazz class, which methods need to describe
     */
    public static void printMethods(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("Class name: " + clazz.getName());
        for (Method method : methods) {
            System.out.println("Method name: " + method.getName());
            System.out.println("Return type: " + method.getReturnType().getName());

            Class[] paramTypes = method.getParameterTypes();

            if(paramTypes.length != 0) {
                System.out.println("List of parameters:");

                for (Class paramType : paramTypes) {
                    System.out.println(paramType.getName());
                }
            }
        }
    }

    /**
     * Display superclass for given as argument class.
     *
     * @param clazz
     */
    public static void printSuperClass(Class clazz) {
        Class c = clazz.getSuperclass();

        if(c != null) {
            System.out.println(c.getSimpleName());
        }
    }

    /**
     * Invokes annotated with {@link CustomAnnotation} methods
     * of given as argument object
     *
     * @param obj object, which annotated methods need to call
     */
    public static void invokeAnnotated(Student obj) {
        Class clazz = obj.getClass();
        for(Method method : clazz.getDeclaredMethods()) {
            if(method.isAnnotationPresent(CustomAnnotation.class)) {
                try {
                    System.out.println(method.invoke(obj));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
