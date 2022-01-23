package com.mygroup.myproject.myr4j.controller;

import com.mygroup.myproject.entity.Person;
import com.mygroup.myproject.myr4j.util.CircuitBreakerUtil;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: CircuitBreakerConnectorTest
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/19
 * @Version 1.0
 */
public class CircuitBreakerControllerTest {
    @Autowired
    private CircuitBreakerController circuitBreakerController;

    @Autowired
    private CircuitBreakerRegistry circuitBreakerRegistry;

    public List<Person> circuitBreakerAOP() throws TimeoutException, InterruptedException {
        CircuitBreakerUtil.getCircuitBreakerStatus("执行开始前：",circuitBreakerRegistry.circuitBreaker("backendA"));
        List<Person> result = circuitBreakerController.getpersons();
        CircuitBreakerUtil.getCircuitBreakerStatus("执行结束后：", circuitBreakerRegistry.circuitBreaker("backendA"));
        return result;
    }

}
