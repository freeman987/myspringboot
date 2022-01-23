package com.mygroup.myproject.myr4j.controller;

import com.mygroup.myproject.entity.Person;
import com.mygroup.myproject.myr4j.service.CircuitBreakerService;
import com.mygroup.myproject.myr4j.servicefeignr4j.FeignR4jService;
import com.mygroup.myproject.myr4j.util.CircuitBreakerUtil;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: CircuitBreakerConnector
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/19
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/hello2")
public class CircuitBreakerController {
    @Autowired
    private CircuitBreakerRegistry circuitBreakerRegistry;

    @Autowired
    private CircuitBreakerService circuitBreakerService;

    @Autowired
    private FeignR4jService feignR4jService;

    @CircuitBreaker(name = "backendA", fallbackMethod = "fallBack")
    @GetMapping("/getpersons")
    public List<Person> getpersons() throws TimeoutException, InterruptedException {
//        Thread.sleep(2000);
        List<Person> Persons;
        Persons = circuitBreakerService.getpersons();
        return Persons;
    }

    //降级
    private List<Person> fallBack(Throwable throwable){
        log.info(throwable.getLocalizedMessage() + ",方法被降级了~~");
        CircuitBreakerUtil.getCircuitBreakerStatus("降级方法中:", circuitBreakerRegistry.circuitBreaker("backendA"));
        List<Person> Persons = new ArrayList();
        return Persons;
    }

    //熔断
    private List<Person> fallBack(CallNotPermittedException e){
        log.info("熔断器已经打开，拒绝访问被保护方法~");
        CircuitBreakerUtil.getCircuitBreakerStatus("熔断器打开中:", circuitBreakerRegistry.circuitBreaker("backendA"));
        List<Person> Persons = new ArrayList();
        return Persons;
    }



    @CircuitBreaker(name = "backendA", fallbackMethod = "fallBack")
    @GetMapping("/getpersonsyyy")
    public List<Person> getpersonsyyy() throws TimeoutException, InterruptedException {
        System.out.println("-----！！！！-----");
        List<Person> Persons;
        Persons = feignR4jService.getPersonsxxxx();
        return Persons;
    }

} 
