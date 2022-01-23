package com.mygroup.myproject.myr4j.service;

import com.mygroup.myproject.entity.Person;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: CircuitBreakerRemoteService
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/19
 * @Version 1.0
 */
public interface CircuitBreakerService {
    List<Person> getpersons() throws TimeoutException, InterruptedException;
}
