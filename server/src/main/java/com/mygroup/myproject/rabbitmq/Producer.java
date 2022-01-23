package com.mygroup.myproject.rabbitmq;

/**
 * @ClassName: Producer
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/11
 * @Version 1.0
 */

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Producer {

    public static void main(String[] args) throws Exception {
        //1 创建一个ConnectionFactory, 并进行配置

        ConnectionFactory factory = new ConnectionFactory();
        //connectionFactory.setHost("192.168.0.130");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("root");
        factory.setPassword("123456");
        //2 通过连接工厂创建连接
        //Connection connection = factory.newConnection();

        //https://www.jianshu.com/p/7e54d636a5a1
        //重要！！！！镜像多主模式用下面的多地址，创建连接。就不用setHost了。
        //镜像模式，试试消费者131，生产者130，照样能收到消息。
        //用户如果自己设置了线程池，像本小节第一段代码写的那样，那么当连接关闭的时候，不会自动关闭用户自定义的线程池，
        //所以用户必须自己手动关闭，通过调用shutdown()方法，否则可能会阻止JVM的终止。
        //ExecutorService es = Executors.newFixedThreadPool(20);
        Connection connection = factory.newConnection(new Address[]{
                //new Address("192.168.0.131"),
                new Address("127.0.0.1")});
        //3 通过connection创建一个Channel
        Channel channel = connection.createChannel(20);


        //4 指定我们的消息投递模式: 消息的确认模式。只有开启这个参数时候，addConfirmListener才生效。
        channel.confirmSelect();
        // 未确认的消息标识
        final SortedSet<Long> confirmSet = Collections.synchronizedSortedSet(new TreeSet<Long>());

        // 通道添加监听
        channel.addConfirmListener(new ConfirmListener() {

            // 没有问题的 handleAck
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                if (multiple) {
                    System.out.println("---handleAck---multiple");
                    confirmSet.headSet(deliveryTag + 1).clear();
                } else {
                    System.out.println("---handleAck---multiple false");
                    confirmSet.remove(deliveryTag);
                }
            }
            // handleNack 1s 3s 10s xxx...
            @Override
            public void handleNack(long l, boolean b) throws IOException {
                //queue出现异常或者到达queque上限了，会导致nack
                if (b) {
                    System.out.println("---handleNack---multiple");
                    confirmSet.headSet(l + 1).clear();
                } else {
                    System.out.println("---handleNack---multiple false");
                    confirmSet.remove(l);
                }
            }
        });


        channel.addReturnListener(new ReturnListener() {
            @Override
            public void handleReturn(int replyCode, String replyText, String exchange,
                                     String routingKey, AMQP.BasicProperties properties,
                                     byte[] body) throws IOException {
                System.err.println("---------handle  return----------");
                System.err.println("replyCode: " + replyCode);
                System.err.println("replyText: " + replyText);
                System.err.println("exchange: " + exchange);
                System.err.println("routingKey: " + routingKey);
                System.err.println("properties: " + properties);
                System.err.println("body: " + new String(body));
            }
        });


        Map<String, Object> headers = new HashMap<>();
        headers.put("my1", "111");
        headers.put("my2", "222");
        AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                .deliveryMode(2)
                .contentEncoding("UTF-8")
                .expiration("10000")
                .headers(headers)
                .build();
        //deliveryMode=2是持久化得消息，服务器重启后仍然存在。
        //这地方设置过期的的时间为10秒，在消费端设置了1秒消费一条消息，所以消费端只能消费10条消息，其他的放入死信队列中


        String msg = "Hello RabbitMQ!";
        //4 通过Channel发送数据
        for(int i=0; i < 30; i++){
            //1exchange   2routingKey 3附加数据 4消息体
            //channel.basicPublish("order-exchange", "order.abcd", properties, msg.getBytes());
            long seqNo = channel.getNextPublishSeqNo();

            /*
            备份交换机（alternate exchange） 简称AE, 在mandatory中 如果不设置，则会丢消息，
            如果不丢消息，则需要在客户端天津returnlistener的处理过程，监听失败的消息，
            如果不丢消息，又不增加处理程序的复杂性，可以使用备份交换机， 将未被路由的消息存放在rabbitmq中， 需要的时候再处理它
            备份交换机的几种特殊情形：
            备份交换机没有匹配的队列， 客户端和rabbitmq服务端不会有异常， 消息丢失
            备份交换机没有绑定的队列，客户端和rabbitmq也不会有异常， 消息丢失
            设置的交换机不存在，则也不会有异常，消息丢失
            如果与消息处理的机制，mandatory一起使用，那么mandatory无效
             */

            //mandatory为true时，上面的addReturnListener生效。路由不到时候监听。这个mandatory参数和return模式配合使用
            //mandatory为false时，会自动删除这消息，当着啥事也没发生。
            channel.basicPublish("order-exchange", "order.abcd",
                    true, properties, msg.getBytes());
            confirmSet.add(seqNo);
        }


        //5 记得要关闭相关的连接
        channel.close();
        connection.close();
    }
}