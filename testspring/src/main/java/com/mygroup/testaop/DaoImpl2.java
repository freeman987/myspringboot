package com.mygroup.testaop;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @ClassName: DaoImpl2
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/26
 * @Version 1.0
 */
@Component("daoImpl2")
@Scope("prototype")
public class DaoImpl2 {

    public void gethash(){
        System.out.println("hashcode:"+this.hashCode());
    }
}
