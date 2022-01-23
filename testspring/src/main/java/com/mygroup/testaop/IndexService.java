package com.mygroup.testaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @ClassName: IndexService
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/21
 * @Version 1.0
 */
//@Lazy
//@Scope("singleton")//默认单例，IndexService单例
//@Scope("prototype")
@Service
public class IndexService{
    @Autowired
    @Qualifier("myindexdao")
    private IndexDao indexDao;

    public void service(){
        indexDao.test();
        indexDao.nnnn("aaa");
    }

}
