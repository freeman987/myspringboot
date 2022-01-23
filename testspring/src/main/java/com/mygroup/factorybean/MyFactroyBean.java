package com.mygroup.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MyFactroyBean
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/23
 * @Version 1.0
 */
@Component("tttt")
public class MyFactroyBean implements FactoryBean {
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void factorybeanlog(){
        System.out.println("factorybeanlog");
    }

    @Override
    public Object getObject() throws Exception {
        MyTestBean myTestBean= new MyTestBean();
        myTestBean.setMsg1(msg+"1");
        myTestBean.setMsg2(msg+"2");
        myTestBean.setMsg3(msg+"3");
        return myTestBean;
    }

    @Override
    public Class<?> getObjectType() {
        return MyFactroyBean.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
