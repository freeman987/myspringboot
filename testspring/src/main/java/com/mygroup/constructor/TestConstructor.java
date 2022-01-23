package com.mygroup.constructor;

import com.mygroup.testaop.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: TestConstructor
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/27
 * @Version 1.0
 */
public class TestConstructor {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(Config.class);


        ConService conService = (ConService) annotationConfigApplicationContext.getBean("conservice");
        conService.query();

        ConService conService2 = (ConService) annotationConfigApplicationContext.getBean("conservice");
        conService2.query();

        JingJing jingJing = (JingJing) annotationConfigApplicationContext.getBean("jingJing");
        System.out.println(jingJing.hashCode());


        TN xxx = (TN) annotationConfigApplicationContext.getBean("TN");
        System.out.println(xxx.hashCode());

        WhatTn whatTn = (WhatTn) annotationConfigApplicationContext.getBean("whatTn");
        System.out.println(whatTn.hashCode());

        TypeAndName typeAndName = (TypeAndName) annotationConfigApplicationContext.getBean("typeAndName");
        System.out.println(typeAndName.hashCode());
//        PlayController playController = (PlayController) annotationConfigApplicationContext.getBean("playController");
//        playController.play();
//
//        PlayController playController2 = (PlayController) annotationConfigApplicationContext.getBean("playController");
//        playController2.play();


//        MorePlayController morePlayController = (MorePlayController) annotationConfigApplicationContext.getBean("morePlayController");
//        morePlayController.play();
//
//        ListPlayController listPlayController = (ListPlayController) annotationConfigApplicationContext.getBean("listPlayController");
//        listPlayController.listPlay();
//
//        MorePlayArgsController morePlayArgsController = (MorePlayArgsController) annotationConfigApplicationContext.getBean("morePlayArgsController");
//        morePlayArgsController.playAll();

    }
}
