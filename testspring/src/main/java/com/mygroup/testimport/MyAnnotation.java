package com.mygroup.testimport;

/**
 * @ClassName: MyAnnotation
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/24
 * @Version 1.0
 */

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Import(MyImportSelector.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//这个MyAnnotation可以当普通注解使用了
public @interface MyAnnotation {
}
