package com.mygroup.observer;

/**
 * @ClassName: MyObserver
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/28
 * @Version 1.0
 */
public class MyObserver1 implements Observer{
    public void iGotIt(MyEvent myEvent){
        if(myEvent.getContext().equals("a")){
            System.out.println("Yes!MyObserver1 get it! Hahaha!");
        }
    }
}
