package com.mygroup.myproject.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MoneyConfig2
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/8
 * @Version 1.0
 */
@Data
@Configuration
public class MoneyConfig2 {//MoneyConfig2引用了MoneyConfig，MoneyConfig引用了配置文件里的值。
    @Autowired
    MoneyConfig moneyConfig;

    @Bean
    String moneydes(){
        return moneyConfig.getMoneydes();
    }

    @Bean
    String moneydes2(){
        return "aaa";
    }
}
