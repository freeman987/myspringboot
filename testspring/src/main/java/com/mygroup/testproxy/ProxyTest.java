package com.mygroup.testproxy;

import java.lang.reflect.Proxy;

/**
 * @ClassName: Test
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/23
 * @Version 1.0
 */
public class ProxyTest {
    public static void main(String[] args) {
//        TargetDao targetDao =new TargeDaoImpl();
//        TargetDao proxy1 =new Proxy1(targetDao);
//        TargetDao proxy2 =new Proxy2(proxy1);
//        proxy2.log();

        TargetDao targetDao = (TargetDao) Proxy.newProxyInstance(
                ProxyTest.class.getClassLoader(),
                new Class[]{TargetDao.class},
                new MyInvocationHandler(new TargeDaoImpl())
                );

        targetDao.log();
        System.out.println("---"+targetDao.hashCode());



    }

}
