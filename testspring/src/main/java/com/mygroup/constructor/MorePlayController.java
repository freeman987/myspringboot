package com.mygroup.constructor;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MorePlayController
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/27
 * @Version 1.0
 */
@Component

public class MorePlayController {

    private MorePlayDao morePlayDao;

    public MorePlayController(@Qualifier("morePlayDaoImplFirstOne") MorePlayDao morePlayDao) {
        this.morePlayDao = morePlayDao;
    }

    public void play() {
        morePlayDao.someOnePlay();
    }

}
