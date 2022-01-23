package com.mygroup.myproject.rabbitmq;

import com.mygroup.myproject.entity.Order;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

//    @Autowired
//    private AmqpTemplate amqpTemplate;

    final RabbitTemplate.ConfirmCallback confirmCallback =new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, java.lang.String cause) {
            System.out.println("----correlationData:" + correlationData);
            String messageId = correlationData.getId();
            if (ack) {
                System.out.println("----messageId:" + messageId);//exchange存在，queue也存在，无论消息有没有被消费。
            } else {
                System.out.println("异常");//投递的exchange不存在
            }
        }
    };


    //exchange存在，但是queue不存在。
    final RabbitTemplate.ReturnsCallback returnsCallback =new RabbitTemplate.ReturnsCallback() {
        @Override
        public void returnedMessage(ReturnedMessage returnedMessage) {
            System.out.println("消息主体 message : " + returnedMessage.getMessage());
            System.out.println("消息主体 message : " + returnedMessage.getReplyCode());
            System.out.println("描述：" + returnedMessage.getReplyText());
            System.out.println("消息使用的交换器 exchange : " + returnedMessage.getExchange());
            System.out.println("消息使用的路由键 routing : " + returnedMessage.getRoutingKey());
        }
    };


    public void send(Order order)throws Exception{
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnsCallback(returnsCallback);
        // JSON.toJSONString(order)
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(order.getMessageId());
        rabbitTemplate.convertAndSend(
                "order-exchange","order.abcd", order, correlationData
        );
    }



//    public void send2(Object payload, Map<String,Object> properties) throws Exception{
//        MessageHeaders messageHeaders= new MessageHeaders(properties);
//        org.springframework.messaging.Message message= MessageBuilder.createMessage(payload, messageHeaders);
//        rabbitTemplate.convertAndSend("order-exchangesss","order.abcd",message);
//    }

}

