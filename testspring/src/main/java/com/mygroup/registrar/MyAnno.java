package com.mygroup.registrar;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @ClassName: MyAnno
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/25
 * @Version 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Import(MyRegistrar.class)
public @interface MyAnno {
}
