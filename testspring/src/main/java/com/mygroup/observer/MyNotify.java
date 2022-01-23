package com.mygroup.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MyNotify
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/28
 * @Version 1.0
 */
public class MyNotify implements Runnable{

    List<Observer> observerList= new ArrayList<>();

    public void addObservers(List<Observer> observerList){
        this.observerList =observerList;
    }

    @Override
    public void run(){
        try {
            System.out.println("Hi,observers! I'm running!");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hi,observers! I'm Ok! I notify you now!");
        MyEvent myEvent = new MyEvent("a","b");
        observerList.forEach((o)->o.iGotIt(myEvent));
    }
}
