package com.mygroup.testproxy;

/**
 * @ClassName: Proxy1
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/23
 * @Version 1.0
 */
public class Proxy1 implements TargetDao{
    TargetDao targetDao;

    public Proxy1(TargetDao targetDao) {
        this.targetDao = targetDao;
    }

    @Override
    public void log() {
        targetDao.log();
        System.out.println("proxy1");
    }
}
