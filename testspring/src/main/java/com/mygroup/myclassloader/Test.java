package com.mygroup.myclassloader;

/**
 * @ClassName: Test
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/30
 * @Version 1.0
 */
public class Test {

    public void test(){
        System.out.println("testtttttttt");
        System.out.println(this.getClass().getClassLoader()+"\n");
    }
}
