package com.mygroup.myproject.testlog;

/**
 * @ClassName: MyLog4j
 * @Description:
 * @Author 吴小田
 * @Date 2022/1/12
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySlf4j {
    public static void main(String[] args) {
        Logger logger= LoggerFactory.getLogger("myslf4j");
        logger.info("myslf4j");
    }

}
