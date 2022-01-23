package com.mygroup.testaop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @ClassName: IndexService2
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/26
 * @Version 1.0
 */
@Service
public class Service2 implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    public void setDaoImpl2(DaoImpl2 daoImpl2) {
        this.daoImpl2 = daoImpl2;
    }

    DaoImpl2 daoImpl2;//如何获得不同的DaoImpl2？
    //因为DaoImpl2是原型的@Scope("prototype")
    //1，这地方不加@Autowired，applicationContext.getBean每次得到一个不同的DaoImpl2原型bean。
    //和自己直接new DaoImpl2()基本没啥区别。唯一不同的时候，别的模块可能需要这种实现。
    //2，如果加了@Autowired，因为Service2是singleton的，即使DaoImpl2是原型bean，
    // DaoImpl2 daoImpl2只被初始化一次，所以加了@Autowired后daoImpl2每次都是同一个。

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void service(){
        //如果用@Autowired测试，就把下面这一行代码注释掉。
        DaoImpl2 daoImpl2 = (DaoImpl2)applicationContext.getBean("daoImpl2");
        System.out.println("service2-hashcode:"+this.hashCode());
        daoImpl2.gethash();
    }



}
