package com.mygroup.zidongzhuangpei;

import com.mygroup.testaop.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: TestAaaa
 * @Description:
 * @Author 吴小田
 * @Date 2022/1/12
 */
public class TestAaaa {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(Config.class);

        Aaaa aaaa =(Aaaa)annotationConfigApplicationContext.getBean(Aaaa.class);
        System.out.println(aaaa.getBbbb()+"======");

//        Bbbb bbbb =(Bbbb) annotationConfigApplicationContext.getBean(Bbbb.class);
//        System.out.println(bbbb+"==b===");
    }
}
