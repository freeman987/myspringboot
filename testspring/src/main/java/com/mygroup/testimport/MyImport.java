package com.mygroup.testimport;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;

/**
 * @ClassName: MyFirstImport
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/24
 * @Version 1.0
 */
public class MyImport implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Object newbean = null;
        if(beanName.equals("dao1Impl")){
            newbean = Proxy.newProxyInstance(this.getClass().getClassLoader(),
                    new Class[]{Dao1.class},new InvocationHandler1(bean));
        }
        return newbean;

    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
