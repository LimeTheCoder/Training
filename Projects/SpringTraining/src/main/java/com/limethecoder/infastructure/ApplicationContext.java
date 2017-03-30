package com.limethecoder.infastructure;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;


public class ApplicationContext implements Context {
    private final Config config;
    private final Map<String, Object> cache = new HashMap<>();

    public ApplicationContext(Config config) {
        this.config = config;
    }

    @Override
    public <T> T getBean(String beanName) {
        if(cache.containsKey(beanName)) {
            return (T) cache.get(beanName);
        }

        T bean = (T)createBean(beanName);

        callInitMethod(bean);
        callAnnotatedInit(bean);

        cache.put(beanName, bean);

        return bean;
    }

    private Object createBean(String beanName) {
        try {
            return createProxy(config.getImpl(beanName).newInstance());
        } catch (InstantiationException|IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /* TODO */
    private Object createProxy(Object bean) {
        bean.getClass().getMethods();
        return Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                bean.getClass().getInterfaces(),
                (proxy, method, args) -> {
                   return method.invoke(bean, args);
                });
    }

    private <T> void callAnnotatedInit(T bean) {
        Method[] methods = bean.getClass().getMethods();
        for(Method method : methods) {
            if(method.isAnnotationPresent(PostConstructBean.class)) {
                try {
                    method.invoke(bean);
                } catch (InvocationTargetException|IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private <T> void callInitMethod(T bean) {
        try {
            Method method = bean.getClass().getMethod("init");
            method.invoke(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
