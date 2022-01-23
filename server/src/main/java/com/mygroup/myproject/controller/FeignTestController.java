package com.mygroup.myproject.controller;

import com.mygroup.myproject.entity.Person;
import com.mygroup.myproject.servicefeign.FeignPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestFeignController
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/10
 * @Version 1.0
 */

@RestController
@RequestMapping("/hello2")
public class FeignTestController {

    @Autowired
    FeignPersonService feignPersonService;

    //http://127.0.0.1:8081/hello1/hello2/testfeign
    @GetMapping("/testfeign")
    public Person testfeign(){
        System.out.println("-----!!!-----");
        Person person = feignPersonService.findpersonxxx(1);
        if(person !=null){
            return person;
        }
        Person oneperson = new Person();
        oneperson.setName("降级了");
        return oneperson;

    }
}
