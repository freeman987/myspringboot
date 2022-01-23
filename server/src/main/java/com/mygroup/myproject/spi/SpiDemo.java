package com.mygroup.myproject.spi;

import java.util.ServiceLoader;

/**
 * @ClassName: SpiDemo
 * @Description:
 * @Author 吴小田
 * @Date 2022/1/3
 */
public class SpiDemo {
    public static void main(String[] args) {
        String a= "./elasticsearch ‐E node.name=node‐1";//横杠。

        String b= "./elasticsearch -E node.name=node‐1";
        String c ="./elasticsearch -E node.name=node‐1";

        System.out.println(a.equals(b));
        System.out.println(c.equals(b));


        ServiceLoader<Animal> animals = ServiceLoader.load(Animal.class);
        animals.forEach((o)->o.noise());
    }
}
