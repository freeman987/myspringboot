package com.mygroup.registrar;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName: MyInvocationHandler
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/23
 * @Version 1.0
 */
public class MyMyInvocationHandler implements InvocationHandler {
//    Object target;
//
//    public MyMyInvocationHandler(Object target) {
//        this.target = target;
//    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy");
        return null;
        //return method.invoke(target,args);

    }
}
