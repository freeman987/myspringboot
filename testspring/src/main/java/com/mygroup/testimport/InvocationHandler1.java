package com.mygroup.testimport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName: InvocationHandler1
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/25
 * @Version 1.0
 */
public class InvocationHandler1 implements InvocationHandler {
    Object target;

    public InvocationHandler1(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是代理方法");
        return  method.invoke(target,args);
    }
}
