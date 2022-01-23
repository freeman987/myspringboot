package com.mygroup.testproxy;

/**
 * @ClassName: Proxy2
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/23
 * @Version 1.0
 */
public class Proxy2 implements TargetDao{
    TargetDao targetDao;

    public Proxy2(TargetDao targetDao) {
        this.targetDao = targetDao;
    }

    @Override
    public void log() {
        targetDao.log();
        System.out.println("proxy2");
    }
}
