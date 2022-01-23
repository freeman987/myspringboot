package com.mygroup.testimport;

/**
 * @ClassName: Why
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/26
 * @Version 1.0
 */
public class Why {

/*
1，如果自己写了2个构造函数，因为spring无法决定用哪一个，认为没有构造函数。
2，如果自己提供1个有参的构造函数，则有构造函数。
3，其他情况待验证。
else if (rawCandidates.length == 1 && rawCandidates[0].getParameterCount() > 0) {
*/
    public Why() {
        System.out.println("whyconstructor");
    }



    public void hello(){
        System.out.println("hello");
    }
}
