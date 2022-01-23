package com.mygroup.testaop;

import org.springframework.beans.factory.DisposableBean;
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
//@Profile("dao2")
@Component//("myindexdao")
public class IndexDaoImpl2 implements IndexDao, DisposableBean {

    public IndexDaoImpl2() {
        System.out.println("constructor2");
    }

    @Override
    public void test() {
        System.out.println("hhhhhh2");
    }

    @Override
    public void nnnn(String a) {
        System.out.println("nnnn2");
    }

    //, InitializingBean
//    @Override
//    public void afterPropertiesSet() throws Exception {
//            System.out.println("init2");
//    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy2");
    }

    @PostConstruct
    public void init(){
        System.out.println("init2");
    }

//    @PreDestroy
//    public void predestroy(){
//        System.out.println("predestroy2");
//    }


}
