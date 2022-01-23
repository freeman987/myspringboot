package com.mygroup.testimport;

import org.springframework.stereotype.Component;

/**
 * @ClassName: Dao1Impl
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/25
 * @Version 1.0
 */
@Component
public class Dao1Impl implements Dao1{
    public void hi(){
        System.out.println("hi");
    }
}
