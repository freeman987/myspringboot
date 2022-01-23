package com.mygroup.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: ConService
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/27
 * @Version 1.0
 */
@Service("conservice")
public class ConService {

    /*
    CONFIGURATION_CLASS_LITE
小技巧：鼠标ctrl+左键点击这个变量或者方法，可以看到有多少个地方引用它。

@configuration里的方法即使是new出来的对象，也都是先从单例池里拿。

推断构造方法：
有atuowired
1，返回：一个required=true的构造方法。=true只能有一个。
2，返回：多个required=false，+无参构造方法。

没有autowried
3，返回：唯一一个有参构造方法
4，返回：如果只有一个无参，返回null。这个无参的无效。外层逻辑用无参进行实例化。
5，如果有多个有参，返回null。
6，同时有无参+有参，使用无参。

AUTO_CONSTRUCTOR---xml装配。
1，然后3个有参无参都要，然后选择参数最多且可用的第一个构造函数。

宽松模式：默认，计算分数。
严格模式：分数相等，父子类型。

如果匹配多个，spring最终无法判断选择哪个构造函数，就会报错。

     */


    @Autowired
    private GoPlayDao goPlayDao;

//    private JingJing jingJing;

    //自动装配有4种类型：BY_TYPE，BY_NAME，AUTOWIRED_NO,AUTOWIRE_CONSTRUCTOR

    //经过beanA构造函数的被引用的beanB，无论有没有加@Autowired等，还是存在于beanA构造函数参数里的beanB，都是属于同一个被spring容器管理的beanB。
    //这里beanB就是ggoPlayDao和jingjing。beanA就是conService。
    public ConService(JingJing jingjing) {
        System.out.println("Jingjinghashcode:"+jingjing.hashCode());
//        System.out.println("Jingjinghashcode2:"+jingJing.hashCode());//构造函数参数的JingJing和属性里的JingJing不能共存。
//        System.out.println("ConService-goPlayDao:"+this.goPlayDao.hashCode());
        //这个构造函数可以打印参数的hashcode，不带@Autowired的属性hashcode。
    }

    public void query(){
        System.out.println("conservice-query");
        System.out.println("ConService-goPlayDao-inquery:"+this.goPlayDao.hashCode());

    }
}
