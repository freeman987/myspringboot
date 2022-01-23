package com.mygroup.myproject.entity;
import lombok.Data;
import java.io.Serializable;

/**
 * @ClassName: Order
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/11
 * @Version 1.0
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 1628332740158772370L;
    private String id;
    private String name;
    private String messageId;

    public Order() {
    }

    public Order(String id, String name, String messageId) {
        this.id = id;
        this.name = name;
        this.messageId = messageId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}

