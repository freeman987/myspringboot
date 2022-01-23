package com.mygroup.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MailBean
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/28
 * @Version 1.0
 */
@Component
public class MailBean {

    @Autowired
    ApplicationContext applicationContext;

    public void sendMail(){
        applicationContext.publishEvent(new MailEvent(applicationContext));
    }

}
