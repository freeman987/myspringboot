package com.mygroup.myproject.controller;

import com.mygroup.myproject.config.MoneyConfig;
import com.mygroup.myproject.entity.Person;
import com.mygroup.myproject.serviceinterface.PersonService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/hello2")
public class HelloController  implements InitializingBean {


    @Override
    public void afterPropertiesSet() throws Exception {
    }

//    @Value("${money}")
//    private BigDecimal money;
//
//    @Value("${moneydes}")
//    private String moneydes;

    @Autowired
    private PersonService personService;

    @Autowired
    private MoneyConfig moneyConfig;

    @Autowired
    private String moneydes2;//根据名称查找注入的Bean。如果名称不对，就根据类型，但是同类型的只能有一个。

    @GetMapping("/he")
    public String hello2()
    {
        return moneydes2;
    }

    //@GetMapping({"/hello3/hello4","/hello5"})
    //@PostMapping({"/hello3/hello4","/hello5"})
    //@RequestMapping({"/hello3/hello4/{id}","/hello5/{id}"})
    //public String hello(@PathVariable("id")Integer id)
    @PostMapping({"/hello3/hello4","/hello5"})
    public String hello(@RequestParam(value="id",required = false,defaultValue = "5")Integer id)
    {
        return "hello"+moneyConfig.getMoneydes()+id;
    }


    @GetMapping("/insertperson")
    public int insertperson()throws RuntimeException
    {
        int i= personService.insertPerson();
        return i;
    }

    @GetMapping("/insertperson2")
    public int insertperso2()throws RuntimeException
    {
        int i= personService.insertPerson2();
        return i;
    }

    @GetMapping("/findperson")
    public Person findperson(@RequestParam(value="id",required = false,defaultValue = "1")Integer id)
    {
        Person person= personService.findPerson(id);
        return person;
    }





    @GetMapping("/getperson")
    public Person getperson(@RequestParam(value="id",required = false,defaultValue = "1")Integer id)throws RuntimeException
    {
        Person person= personService.getPerson(id);
        return person;
    }
    /*
     用这个josn字符串作为参数postman模拟getperson2
     postman记得选上content-type，content-length，host,body---raw
        {
        id:1,
        name:xiaotian,
        sex:1,
        birthday:"2020-10-11 11:11:11",
        mondye:10000
        }
     */
    @PostMapping("/getperson2")
    public Person getperson2(@Valid @RequestBody Person myperson, @RequestHeader("userid") Integer userid,BindingResult br)throws RuntimeException
    {
        if(br.hasErrors()){
            return null;
        }
        int testuserid =userid;
        System.out.println(testuserid);
        int id= myperson.getId();
        Person person= personService.getPerson(id);
        return person;
    }



    @GetMapping("/updateperson")
    public Integer updateperson(@RequestParam(value="id",required = false,defaultValue = "1")Integer id)
    {
        Integer num= personService.updatePerson(id);
        return num;
    }



    @GetMapping("/addmoney3")
    public Integer addmoney3(@RequestParam(value="id",required = false,defaultValue = "1")Integer id)
    {
        Integer num= personService.addMoney3(id);
        return num;
    }

    @GetMapping("/addmoney")
    public Integer addmoney(@RequestParam(value="id",required = false,defaultValue = "1")Integer id)
    {
        Integer num= personService.addMoney(id);
        return num;
    }

    @GetMapping("/addmoney2")
    public Integer addmoney2(@RequestParam(value="id",required = false,defaultValue = "1")Integer id)
    {
        Integer num= personService.addMoney2(id);
        return num;
    }
}
