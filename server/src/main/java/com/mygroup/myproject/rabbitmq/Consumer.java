package com.mygroup.myproject.rabbitmq;
import  com.rabbitmq.client.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Consumer {
    public static void main(String[] args) throws Exception {
        //1 创建一个ConnectionFactory, 并进行配置
        ConnectionFactory factory = new ConnectionFactory();
        //factory.setHost("192.168.0.130");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("root");
        factory.setPassword("123456");
        factory.setAutomaticRecoveryEnabled(true);
        factory.setNetworkRecoveryInterval(3000);
        //2 通过连接工厂创建连接
        //Connection connection = factory.newConnection();

        //https://www.jianshu.com/p/7e54d636a5a1
        //重要！！！！镜像多主模式用下面的多地址，创建连接。就不用setHost了
        //镜像模式，试试消费者131，生产者130，照样能收到消息。
        Connection connection = factory.newConnection(new Address[]{
                //new Address("192.168.0.130"),
                new Address("127.0.0.1")});

        //3 通过connection创建一个Channel
        Channel channel = connection.createChannel(20);


        //4 声明（创建）一个队列
        String queueName = "order-queue";
        //1队列名称 2持久化 3独占 4queue不绑定会自动删 5扩展参数
//        Map<String, Object> arguments = new HashMap<String , Object>();
//        arguments.put("x-message-ttl" , 30*1000);//设置队列里消息的ttl的时间30s，设置到arguments里面。
//        消息的过期时间,目前有两种方法可以设置消息的TTL 。
//        第一种方法是通过队列属性设置，队列中所有消息都有相同的过期时间。
//        第二种方法是对消息本身进行单独设置，每条消息的TTL可以不同。如果两种方法一起使用，则消息的TTL以两者之间较小的那个数值为准。
//        对于第一种设置队列属性的方法，一旦消息过期，就会从队列中抹去，
//        而在第二种方法中，即使消息过期，也不会马上从队列中抹去，因为每条消息是否过期是在即将投递到消费者之前判定的。
//        为什么这两种方法处理的方式不一样?
//        因为第一种方法里，队列中己过期的消息肯定在队列头部，RabbitMQ只要定期从队头开始扫描是否有过期的消息即可。
//        而第二种方法里，每条消息的过期时间不同，如果要删除所有过期消息势必要扫描整个队列，所以不如等到此消息即将被消费时再判定是否过期,如果过期再进行删除即可。

        Map<String, Object> arguments = new HashMap<String , Object>();
        arguments.put("x-max-length", 10);//队列满了（生产者发送时发现满了，消费者消费时发现满了），过期了，nack给mq，发到死信队列。
        arguments.put("x-dead-letter-exchange","my-dead-exchange");//x-dead-letter-exchange和x-dead-letter-routing-key
        arguments.put("alternate-exchange","backup-exchange");

        channel.queueDeclare(queueName, true, false, false, arguments);
        channel.exchangeDeclare("order-exchange", "topic", true, false, null);
        channel.queueBind(queueName, "order-exchange", "order.#");

        channel.queueDeclare("my-dead-queue", true, false, false, null);
        channel.exchangeDeclare("my-dead-exchange", "topic", true, false, null);
        channel.queueBind("my-dead-queue", "my-dead-exchange", "#");

        channel.queueDeclare("backup-queue", true, false, false, null);
        channel.exchangeDeclare("backup-exchange", "fanout", true, false, null);
        channel.queueBind("backup-queue", "backup-exchange", "#");



        channel.basicQos(0,1,false);
        //autoAck=false时，这个设置才有效果。 消费端限流，自动应答情况下，是不生效的。必须手动签收模式下。
        //真正工作中autoAck设置为false，都是手动签收。
        //channel.basicAck(envelope.getDeliveryTag(),false);
        //注释掉这句了，因为后面改用自定义得defaultConsumer了。

        //5 创建消费者
        DefaultConsumer defaultConsumer = new MyConsumer(channel);
        //6 设置Channel。
        channel.basicConsume(queueName, false, defaultConsumer);//推模式


//        //拉模式。下面代码是一次拉取一条消息。
//        GetResponse response = channel.basicGet(queueName, false);
//        if (response == null) {
//            // No message retrieved.
//        } else {
//            AMQP.BasicProperties props = response.getProps();
//            byte[] body = response.getBody();
//            long deliveryTag = response.getEnvelope().getDeliveryTag();
//            System.err.println("-----------consume message----------");
//            System.err.println("envelope: " +  response.getEnvelope());
//            System.err.println("properties: " + props);
//            System.err.println("body: " + new String(body, "UTF-8"));
//            channel.basicAck(deliveryTag, false); // acknowledge receipt of the message
//        }

    }
}



class MyConsumer extends DefaultConsumer {
    private Channel channel;

    public MyConsumer(Channel channel){
        super(channel);
        this.channel=channel;
    }
    @Override
    public void handleDelivery(String consumerTag,Envelope envelope,
                               AMQP.BasicProperties properties,byte[] body) throws IOException
    {
        System.err.println("-----------consume message----------");
        System.err.println("consumerTag: " + consumerTag);
        System.err.println("envelope: " + envelope);
        System.err.println("properties: " + properties);
        System.err.println("body: " + new String(body, "UTF-8"));
        try{
            Thread.sleep(1000);//让消费者慢点消费。
        }catch (Exception ex){
        }
        //autoAck=false情况下，才会basicAck，basicNack，basicReject，才会限流。
        //根据具体业务逻辑条件调用basicAck还是basicNack。
        //某条消息消费完不签收的话，队列中的消息会一直在等待消费者ack签收这条消息，不会删除。
        //只有这条消息ack完，队列才会给消费者发送下一条消息。ready，unacked，total
        //multiple=false不批量签收。前面的basicQos的prefechCount被设置为1，如果>1，可以设置为批量签收。
        channel.basicAck(envelope.getDeliveryTag(),false);
        //channel.basicReject(envelope.getDeliveryTag(),false);
        //当requeue=false，nack和reject可以进入死信队列当中，超时也会进入死信队列。
        //当requeue=true，nack和reject有requeue参数，可以重回队列。ack没有requeue参数。
        //重回队列和死信队列二选一。如果是死信队列，必须把这个requeue参数设置为false。实际上工作中千万不要去用重回队列。
        // https://blog.csdn.net/zlt995768025/article/details/81938449
        //channel.basicNack(envelope.getDeliveryTag(),false,false);


    }
}

