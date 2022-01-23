package com.mygroup.testproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName: MyInvocationHandler
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/23
 * @Version 1.0
 */
public class MyInvocationHandler implements InvocationHandler {
    Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("===proxy");
        System.out.println(this.hashCode());
        return method.invoke(target,args);

    }
}
