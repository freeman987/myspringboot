package com.mygroup.testimport;

import com.mygroup.testaop.Config;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @ClassName: TestImport
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/25
 * @Version 1.0
 */
public class TestImport {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Config.class);
        Config config = (Config) annotationConfigApplicationContext.getBean("config");
        Dao1 dao1=(Dao1)annotationConfigApplicationContext.getBean("dao1Impl");
        dao1.hi();
        //尝试把Config.class文件里的@MyAnnotation注解注销掉看看，
        //那么代理类没有通过注解MyAnnotation注册到spring容器，代理类不受spring容器托管，那么代理类又没有被调用。
        //所以代理不起作用。此时dao1Impl将作为平常的bean注册到spring容器，而不是通过代理类。


        //为什么用cglib动态代理，因为jdk需要接口。而Config.class不一定有接口。
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(WhatDaoImpl.class);
        enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
        enhancer.setCallback(new MyMethodCallBack());
        WhatDaoImpl whatDao = (WhatDaoImpl)enhancer.create();
        whatDao.hello();

        //sudo java -classpath  "/Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/lib/sa-jdi.jar" sun.jvm.hotspot.HSDB
//        try{
//            System.in.read();
//        }catch (IOException e){
//
//        }


    }
}
