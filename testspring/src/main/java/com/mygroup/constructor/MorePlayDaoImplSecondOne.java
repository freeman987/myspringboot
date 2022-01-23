package com.mygroup.constructor;

import org.springframework.stereotype.Component;

/**
 * @ClassName: MorePlayImplSecondOne
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/27
 * @Version 1.0
 */
@Component
public class MorePlayDaoImplSecondOne implements MorePlayDao {
    @Override
    public void someOnePlay() {
        System.out.println("Second one play.");
    }
}