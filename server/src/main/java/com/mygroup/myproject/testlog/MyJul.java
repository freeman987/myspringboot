package com.mygroup.myproject.testlog;

import java.util.logging.Logger;

/**
 * @ClassName: MyJul
 * @Description:
 * @Author 吴小田
 * @Date 2022/1/12
 */

public class MyJul {
    public static void main(String[] args) {
        Logger logger= Logger.getLogger("myjul");
        logger.info("myjul");
    }
}
