package com.mygroup.testaop;

import com.mygroup.registrar.MyAnno;
import com.mygroup.testimport.*;
import com.mygroup.zidongzhuangpei.AaaaRegistrar;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.*;

/**
 * @ClassName: Config
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/21
 * @Version 1.0
 */

//----注解的写法：
//key=value
//成员(,)类似于函数参数
//数组{}
//嵌套注解@
//加了这个注解，就会进行CGlib代理。Full全注解和lite
@EnableAspectJAutoProxy(proxyTargetClass = true)
//@Import(MyFirstImport.class)
//@Import(MyImportSelector.class)
//@Import(MyRegistrar.class)
@Import(AaaaRegistrar.class)
@MyAnno
@MyAnnotation
@Configuration
@ComponentScan(value="com.mygroup",
        excludeFilters = {@ComponentScan.Filter(type= FilterType.REGEX,pattern ={"com.mygroupxxxx.*"})})
public class Config {
    @Bean
    public Why getWhy(){//如果加上static也会执行两边，即使加了@Configuration
        return new Why();
    }

    @Bean
    public WhatDaoImpl getWhatDaoImpl(){
        getWhy();
        //如果不加Configuration，Why的构造函数会执行2遍。
        //加Configuration，只会调用代理对象的构造方法。
        return new WhatDaoImpl();
    }


////mybatis下的@MapperScan的替代方案
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer(){
//        MapperScannerConfigurer mapperScannerConfigurer =new MapperScannerConfigurer();
//        mapperScannerConfigurer.setBasePackage("com.mygroup");
//        return  mapperScannerConfigurer;
//    }


}
