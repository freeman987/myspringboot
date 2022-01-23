package com.mygroup.constructor;

import org.springframework.stereotype.Component;

/**
 * @ClassName: GoPlayImpl
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/27
 * @Version 1.0
 */
@Component
public class GoPlayDaoImpl implements GoPlayDao {
    @Override
    public void havePlay() {
        System.out.println("single play");
    }
}