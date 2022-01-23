package com.mygroup.myproject.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ClassName: MyCondition
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/29
 * @Version 1.0
 */
public class MyCondition implements Condition {
    //metadata参数代表这个MyCondition被注解@Conditional(MyCondition.class)注解在那个类上，
    // 比如注解在类A上，就代表A的注解(元数据信息)
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        context.getEnvironment().getProperty("abc");
        return true;
        //如果返回false，那么MoneyConfig所有的注解无效，
        // 那么springboot容器中就没有这个MoneyConfig bean
        //会导致启动类无法get到MoneyConfig bean，导致空指针异常。
        //'com.mygroup.myproject.config.MoneyConfig' that could not be found.
    }
}
