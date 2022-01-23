package com.mygroup.factorybean;

import com.mygroup.testaop.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: TestFactoryMain
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/23
 * @Version 1.0
 */
public class TestFactoryMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(Config.class);

        //如果没有手动写名称tttt，就用这个。
//        MyFactroyBean myFactroyBeanxxx =(MyFactroyBean) annotationConfigApplicationContext.getBean("&myFactroyBean");

        //获取getobject返回的Bean。
        MyTestBean myTestBean =(MyTestBean) annotationConfigApplicationContext.getBean("tttt");
        myTestBean.log();
//        myTestBean.getMsg1();

        //获取MyFactroyBean自身。
        MyFactroyBean myFactroyBean =(MyFactroyBean) annotationConfigApplicationContext.getBean("&tttt");
        myFactroyBean.factorybeanlog();

    }
}
