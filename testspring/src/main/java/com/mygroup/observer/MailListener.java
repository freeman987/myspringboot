package com.mygroup.observer;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MailObserver
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/28
 * @Version 1.0
 */
@Component
public class MailListener implements ApplicationListener<MailEvent> {
    @Override
    public void onApplicationEvent(MailEvent event) {
        System.out.println("get mail");
    }
}
