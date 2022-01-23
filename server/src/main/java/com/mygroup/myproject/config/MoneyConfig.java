package com.mygroup.myproject.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Conditional(MyCondition.class)
@Component
@ConfigurationProperties(prefix = "moneyconfig")//从配置文件里读取
public class MoneyConfig {
    private BigDecimal money;
    private String moneydes;

//    public MoneyConfig(BigDecimal money, String moneydes) {
//        this.money = money;
//        this.moneydes = moneydes;
//    }


    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getMoneydes() {
        return moneydes;
    }

    public void setMoneydes(String moneydes) {
        this.moneydes = moneydes;
    }
}


