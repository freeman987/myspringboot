package com.mygroup.testaop;

import com.mygroup.registrar.CarDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Proxy;

/**
 * @ClassName: TestSpring
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/21
 * @Version 1.0
 */
public class TestSpring {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext  annotationConfigApplicationContext =
            new AnnotationConfigApplicationContext(Config.class);

        IndexService indexService= (IndexService)annotationConfigApplicationContext.getBean("indexService");

        IndexDao indexDao =(IndexDao) annotationConfigApplicationContext.getBean("myindexdao");
        IndexDao indexDao2 =(IndexDao) annotationConfigApplicationContext.getBean("indexDaoImpl2");
        IndexDao indexDao3 =(IndexDao) annotationConfigApplicationContext.getBean(IndexDao.class);
        indexDao3.nnnn("123");

//        Service2 service2 =(Service2)annotationConfigApplicationContext.getBean("service2");
//        service2.service();
//
//        Service2 service3 =(Service2)annotationConfigApplicationContext.getBean("service2");
//        service3.service();

//        Service3 service4 =(Service3)annotationConfigApplicationContext.getBean("service3");
//        service4.service();
//
//        Service3 service5 =(Service3)annotationConfigApplicationContext.getBean("service3");
//        service5.service();

//如果是JDK，则不能用getBean(IndexDaoImpl2.class);
//        IndexDao indexDao4 =(IndexDao) annotationConfigApplicationContext.getBean(IndexDaoImpl2.class);
//        indexDao4.nnnn("123");

        System.out.println(indexDao instanceof IndexDaoImpl1);
        System.out.println(indexDao instanceof IndexDao);
        System.out.println(indexDao instanceof Proxy);

//        Class<?>[] myclass = new Class[]{IndexDao.class};
//        byte[]bytes= ProxyGenerator.generateProxyClass("aaa",myclass);
//        File file = new File("/Users/wuxiaotian/aaa.class");
//        try{
//            FileOutputStream fileOutputStream = new FileOutputStream(file);
//            fileOutputStream.write(bytes);
//            fileOutputStream.flush();
//            fileOutputStream.close();
//        }catch (IOException e){
//        }

//        CarDao carDao =(CarDao) annotationConfigApplicationContext.getBean(CarDao.class);
//        carDao.list();

        CarDao carDao2 =(CarDao) annotationConfigApplicationContext.getBean("com.mygroup.registrar.CarDao");
        //CarDao carDao2 =(CarDao) annotationConfigApplicationContext.getBean("abc");

        carDao2.list(123);


/*
有3种方法：
1，AnnotationConfigApplicationContext  annotationConfigApplicationContext =
            new AnnotationConfigApplicationContext(Config.class);
2，annotationConfigApplicationContext.register(IndexDaoImpl1.class);
3，annotationConfigApplicationContext.scan("com.mygroup");
 */

//        AnnotationConfigApplicationContext  annotationConfigApplicationContext =
//            new AnnotationConfigApplicationContext();
//        annotationConfigApplicationContext.getEnvironment().setActiveProfiles("dao1");
////        annotationConfigApplicationContext.register(IndexDaoImpl1.class);
//        annotationConfigApplicationContext.scan("com.mygroup");
//        annotationConfigApplicationContext.refresh();
//
//        annotationConfigApplicationContext.getBean(MyImport.class);







//        InitDestroyAnnotationBeanPostProcessor
//        InstantiationAwareBeanPostProcessor
//        CommonAnnotationBeanPostProcessor
//        AutowiredAnnotationBeanPostProcessor
//        BeanValidationPostProcessor
//        AbstractAutoProxyCreator

    }
}
