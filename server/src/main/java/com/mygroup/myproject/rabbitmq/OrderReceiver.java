package com.mygroup.myproject.rabbitmq;
import com.mygroup.myproject.entity.Order;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import java.util.Map;


@Component
public class OrderReceiver {


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value="order-queue",durable ="true"),
            exchange = @Exchange(name = "order-exchange",durable = "true",type="topic"),
            key="order.#"))
    @RabbitHandler
    public void receive(@Payload Order order,
                        @Headers Map<String,Object> headers,
                        Channel channel)throws Exception{
        System.out.println("-----收到消息----");
        System.out.println("订单id："+order.getId());
        Long deliveryTag= (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        System.out.println("deliveryTag:"+deliveryTag);
        channel.basicAck(deliveryTag,false);//手工签收，不批量接收
        //channel.basicNack(deliveryTag,false,false);//手工签收，不批量接收
    }



//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(value = "queue-1",durable="true"),
//            exchange = @Exchange(value = "exchange-1",durable="true",type= "topic",ignoreDeclarationExceptions = "true"),
//            key = "springboot.*"))
//    @RabbitHandler
//    public void receive2(Message message, Channel channel) throws Exception {
//        System.err.println("--------------------------------------");
//        System.err.println("消费端Payload: " + message.getPayload());
//        Long deliveryTag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
//        //手工ACK
//        channel.basicAck(deliveryTag, false);
//    }

}

