package com.mygroup.observer;

import com.mygroup.testaop.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: TestObserver
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/28
 * @Version 1.0
 */
public class TestMyObserver {
    public static void main(String[] args) {
//        List<Observer> observerList =new ArrayList<>();
//        observerList.add(new MyObserver1());
//        observerList.add(new MyObserver2());
//        MyNotify  myNotify =new MyNotify();
//        myNotify.addObservers(observerList);
//
//        Thread thread = new Thread(myNotify);
//        thread.start();


        AnnotationConfigApplicationContext annotationConfigApplicationContext=
                new AnnotationConfigApplicationContext(Config.class);

        MailBean mailBean= (MailBean)annotationConfigApplicationContext.getBean("mailBean");
        mailBean.sendMail();


    }

}
