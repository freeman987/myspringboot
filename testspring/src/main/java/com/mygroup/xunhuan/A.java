package com.mygroup.xunhuan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @ClassName: A
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/27
 * @Version 1.0
 */
@Component
public class A {
    @Autowired
    B b;
}
