package com.mygroup.observer;

import org.springframework.context.ApplicationEvent;

/**
 * @ClassName: SendMailEvent
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/28
 * @Version 1.0
 */
public class MailEvent extends ApplicationEvent {
    String Content;

    public MailEvent(Object source) {
        super(source);
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
