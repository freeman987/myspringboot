package com.mygroup.myproject.client;

import com.mygroup.myproject.common.PersonOutput;
import lombok.Data;

/**
 * @ClassName: TestModule
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/10
 * @Version 1.0
 */
@Data
public class TestModule {
    PersonOutput personOutput;
    //测试，果然client模块可以引用common模块里定义的PersonOutput。
    //因为在client模块pom文件里依赖引用了common。
}
