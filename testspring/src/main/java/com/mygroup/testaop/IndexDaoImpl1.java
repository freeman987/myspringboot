package com.mygroup.testaop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName: IndexDaoImpl
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/21
 * @Version 1.0
 */
//@Lazy
@Primary
//@Profile("dao1")
@Component("myindexdao")
public class IndexDaoImpl1 implements IndexDao, DisposableBean {

    public IndexDaoImpl1() {
        System.out.println("constructor1");
    }

    @Override
    public void test() {
        System.out.println("hhhhhh1");
    }

    @Override
    public void nnnn(String a) {
        System.out.println("nnnn1");
    }

    //, InitializingBean
//    @Override
//    public void afterPropertiesSet() throws Exception {
//            System.out.println("init1");
//    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy1");
    }

    @PostConstruct
    public void init(){
        System.out.println("init1");
    }

//    @PreDestroy
//    public void predestroy(){
//        System.out.println("predestroy1");
//    }


}
