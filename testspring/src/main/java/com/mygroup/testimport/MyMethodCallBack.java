package com.mygroup.testimport;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName: MyMethodCallBack
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/26
 * @Version 1.0
 */
public class MyMethodCallBack implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("MyMethodCallBack-intercept");
        return methodProxy.invokeSuper(o,objects);//oobjects是参数。

    }
}
