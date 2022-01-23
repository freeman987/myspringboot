package com.mygroup.beanprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MyFirstProcessor
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/24
 * @Version 1.0
 */
@Component
public class MyFirstProcessor1 implements BeanPostProcessor, PriorityOrdered {
    //在bean初始化之前执行。
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("myindexdao")){
            System.out.println("postProcessBeforeInitialization");
        }
        return bean;
//        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
    //在bean初始化之后执行。
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("myindexdao")){
            System.out.println("postProcessAfterInitialization");
        }
        return bean;
        //return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @Override
    public int getOrder() {
        return 101;
    }
}
