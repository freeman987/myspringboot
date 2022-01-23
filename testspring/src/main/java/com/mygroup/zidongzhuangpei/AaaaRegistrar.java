package com.mygroup.zidongzhuangpei;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName: AaaaRegistar
 * @Description:
 * @Author 吴小田
 * @Date 2022/1/12
 */
public class AaaaRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                        BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {

        GenericBeanDefinition genericBeanDefinition = (GenericBeanDefinition)registry.getBeanDefinition("aaaa");
        genericBeanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_NO);
//        genericBeanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

        registry.registerBeanDefinition("aaaa",genericBeanDefinition);
    }
}
