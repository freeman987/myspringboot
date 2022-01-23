package com.mygroup.registrar;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: MyMyFactoryBean
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/24
 * @Version 1.0
 */
//@Component
public class MyMyFactoryBean implements FactoryBean, InvocationHandler {
    private Class clazz;

    public MyMyFactoryBean(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object getObject() throws Exception {
        Object proxy= Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{clazz},
                this
                );
        return proxy;
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy");
        Method method1 =proxy.getClass().getInterfaces()[0].getMethod(method.getName(),Integer.class);
        org.apache.ibatis.annotations.Select select= method1.getDeclaredAnnotation(org.apache.ibatis.annotations.Select.class);
        System.out.println(select.value()[0]);

        return null;
    }
}
