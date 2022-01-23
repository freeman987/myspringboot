package com.mygroup.registrar;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MyRegistrar
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/24
 * @Version 1.0
 */
public class MyRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
/*
        //通过BeanDeinition生成一个Bean，而不是之前的@Component等
        BeanDefinitionBuilder builder =BeanDefinitionBuilder.genericBeanDefinition(CarDao.class);
        GenericBeanDefinition genericBeanDefinition=(GenericBeanDefinition) builder.getBeanDefinition();
        //有下面这条语句，MyMyFactoryBean就不需要加@Component了
        genericBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.mygroup.registrar.CarDao");
        genericBeanDefinition.setBeanClass(MyMyFactoryBean.class);
        registry.registerBeanDefinition("abc",genericBeanDefinition);
*/

        List<Class> mapperList= new ArrayList<>();
        mapperList.add(CarDao.class);
        //这个地方每次还可以优化，每次都要手动add添加。后面可以用实现@MapperScan功能。
        //还可以写很多mapper，mybatis里..................
        for(Class mapper:mapperList){
            AbstractBeanDefinition abstractBeanDefinition =
                    BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();

            //name必须不一样，class类型可以一样。
            abstractBeanDefinition.setBeanClass(MyMyFactoryBean.class);
            abstractBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue(mapper);

            registry.registerBeanDefinition(mapper.getName(),abstractBeanDefinition);

        }





    }

}
