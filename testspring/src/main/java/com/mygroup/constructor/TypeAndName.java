package com.mygroup.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @ClassName: TypeAndName
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/28
 * @Version 1.0
 */
@Service
public class TypeAndName {

    @Autowired
    WhatTn whatTn1;

    //这地方@Postconstruct为什么不起作用？？？？
    //Constructor >> @Autowired >> @PostConstruct
    @PostConstruct
    public void abc(){
        System.out.println("-------"+whatTn1.getClass().getName());
    }

}
