package com.mygroup.myproject;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@EnableFeignClients在别的地方加过了，这个地方就不要加了，不然打包失败。
//#允许存在多个Feign调用相同Service的接口
//spring.main.allow-bean-definition-overriding=true
class MyprojectApplicationTests {

    @Test
    void contextLoads() {
    }



    @Test
    void testmethod(){
        log.debug("xxxxxxsssss");
    }


}
