package com.mygroup.constructor;

import org.springframework.stereotype.Component;

/**
 * @ClassName: MorePlayImplFirstOne
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/27
 * @Version 1.0
 */
@Component
public class MorePlayDaoImplFirstOne implements MorePlayDao {
    @Override
    public void someOnePlay() {
        System.out.println("First one play.");
    }
}
