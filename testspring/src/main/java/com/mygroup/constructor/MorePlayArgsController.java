package com.mygroup.constructor;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @ClassName: PlayMoreArgsController
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/27
 * @Version 1.0
 */
@Component
public class MorePlayArgsController {
    private GoPlayDao goPlayDao;
    private MorePlayDao morePlayDao;

    public MorePlayArgsController(GoPlayDao goPlayDao, @Qualifier("morePlayDaoImplSecondOne") MorePlayDao morePlayDao) {
        this.goPlayDao = goPlayDao;
        this.morePlayDao = morePlayDao;
    }

    public void playAll() {
        goPlayDao.havePlay();
        morePlayDao.someOnePlay();
    }
}