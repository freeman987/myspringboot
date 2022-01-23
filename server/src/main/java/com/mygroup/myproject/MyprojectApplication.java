package com.mygroup.myproject;

import com.mygroup.myproject.config.MoneyConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import java.math.BigDecimal;

@SpringBootApplication
@EnableAsync
//@EnableCaching
@EnableDiscoveryClient
@EnableFeignClients
public class MyprojectApplication {
    //mysql.server start&
    //rabbitmq-server start&
    //java -jar zipkin.jar
    //eureka
//-Dserver.port=8081 -Dspring.application.name=myeurekaclient1 -Dserver.servlet.context-path=/hello11
    public static void main(String[] args) {
        //这个是mybatis生成了一个org.apache.ibatis.logging.slf4j.Slf4jImpl.class构造方法logConstructor。
        //后面mybatis再获取这个构造方法生成log对象。而不是用springboot容器生成bean的方法。
        //在SqlSessionFactoryBean里LogFactory.getLog()，获得logConstructor。
        org.apache.ibatis.logging.LogFactory.useSlf4jLogging();

        ConfigurableApplicationContext configurableApplicationContext=
                SpringApplication.run(MyprojectApplication.class, args);

        MoneyConfig moneyConfig = (MoneyConfig)configurableApplicationContext.getBean("moneyConfig");
        BigDecimal bigDecimal= moneyConfig.getMoney();
        System.out.println(bigDecimal);

    }

}
