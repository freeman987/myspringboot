package com.mygroup.observer;

/**
 * @ClassName: MyObserver
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/28
 * @Version 1.0
 */
public class MyObserver2 implements Observer{
    public void iGotIt(MyEvent myEvent){
        if(myEvent.getContext().equals("a")){
            System.out.println("Yes!MyObserver2 get it! Wuwuwu!");
        }
    }
}
