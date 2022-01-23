package com.mygroup.myproject;

/**
 * @ClassName: OrderSenderTest
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/11
 * @Version 1.0
 */
import com.mygroup.myproject.entity.Order;
import com.mygroup.myproject.rabbitmq.OrderSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;


@SpringBootTest
class OrderSenderTest {

    @Autowired
    private OrderSender orderSender;

    @Test
    public void testSend() throws Exception{
        Order order= new Order();
        order.setId("123");
        order.setName("myname");
        order.setMessageId(System.currentTimeMillis()+"-"+ UUID.randomUUID().toString());
        orderSender.send(order);
    }

}