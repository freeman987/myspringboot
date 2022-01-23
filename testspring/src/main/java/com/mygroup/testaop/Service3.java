package com.mygroup.testaop;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

/**
 * @ClassName: Service3
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/26
 * @Version 1.0
 */
@Service
public class Service3 {

    @Lookup
    public DaoImpl2 getddd() {
        return null;
    }
    //Spring提供了一个名为@Lookup的注解，这是一个作用在方法上的注解，
    //被其标注的方法会被重写，然后根据其返回值的类型，容器调用BeanFactory的getBean()方法来返回一个bean。
    //被标注的方法的返回值不再重要，因为容器会动态生成一个子类然后将这个被注解的方法重写/实现，最终调用的是子类的方法。


    public void service(){
        System.out.println("service3-hashcode:"+this.hashCode());
        getddd().gethash();
    }

}
