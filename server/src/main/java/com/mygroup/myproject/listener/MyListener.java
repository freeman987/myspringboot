package com.mygroup.myproject.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.GenericApplicationListener;
import org.springframework.core.ResolvableType;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * @ClassName: MyListener
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/29
 * @Version 1.0
 */
public class MyListener implements GenericApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("-----hahaha,mylistener------");//接受到事件后的处理逻辑
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return true;
//        return GenericApplicationListener.super.supportsSourceType(sourceType);
    }

    @Override
    public boolean supportsEventType(ResolvableType eventType) {
        return true;
    }

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return GenericApplicationListener.super.supportsEventType(eventType);
    }



    @Override
    public int getOrder() {
        return GenericApplicationListener.super.getOrder();
    }

    @Override
    public String getListenerId() {
        return GenericApplicationListener.super.getListenerId();
    }


}
