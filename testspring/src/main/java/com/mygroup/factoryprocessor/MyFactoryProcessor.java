package com.mygroup.factoryprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

/**
 * @ClassName: MyFactoryProcessor
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/24
 * @Version 1.0
 */
@Component
public class MyFactoryProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        AnnotatedBeanDefinition annotatedBeanDefinition =
                (AnnotatedBeanDefinition) beanFactory.getBeanDefinition("myindexdao");

        annotatedBeanDefinition.setScope("prototype");

//        AbstractBeanDefinition abstractBeanDefinition =
//                (AbstractBeanDefinition) beanFactory.getBeanDefinition("xxxxxxxxxxxxx");
//        abstractBeanDefinition.setLenientConstructorResolution(false);//推断构造方法严格模式

    }
}
