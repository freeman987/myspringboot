package com.mygroup.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: PlayController
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/27
 * @Version 1.0
 */

@Component
public class PlayController {
    @Autowired
    private GoPlayDao goPlayDao;
    //经过beanA构造函数的被引用的beanB，无论有没有加@Autowired等，还是存在于beanA构造函数参数里的beanB，都是属于同一个被spring容器管理的beanB。
    //这里beanB就是goPlayDao。beanA就是playController。

    public PlayController(GoPlayDao goPlayDao) {
        this.goPlayDao = goPlayDao;
        System.out.println("PlayController-goPlayDao:"+this.goPlayDao.hashCode());
    }

    public void play() {
        goPlayDao.havePlay();
        System.out.println("PlayController-goPlayDao-inplay:"+this.goPlayDao.hashCode());

    }

}