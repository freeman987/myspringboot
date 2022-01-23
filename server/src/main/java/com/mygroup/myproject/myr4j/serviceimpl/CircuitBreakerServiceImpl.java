package com.mygroup.myproject.myr4j.serviceimpl;

import com.mygroup.myproject.entity.Person;
import com.mygroup.myproject.exception.BusinessAException;
import com.mygroup.myproject.exception.BusinessBException;
import com.mygroup.myproject.mapper.PersonMapper;
import com.mygroup.myproject.myr4j.service.CircuitBreakerService;
import com.mygroup.myproject.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: CircuitBreakerServiceImpl
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/19
 * @Version 1.0
 */
@Slf4j
@Service
public class CircuitBreakerServiceImpl implements CircuitBreakerService {
    @Autowired
    PersonRepository personRepository;

    private static AtomicInteger count = new AtomicInteger(0);

    @Override
    public List<Person> getpersons() {
        int num = count.getAndIncrement();
        log.info("count的值 = " + num);
        if (num % 4 == 1){
            throw new BusinessAException("异常A，不需要被记录");
        }
        if (num % 4 == 2 || num % 4 == 3){
            throw new BusinessBException("异常B，需要被记录");
        }
        log.info("服务正常运行，获取用户列表");
        // 模拟数据库的正常查询
        return personRepository.findAll();
    }
}
/*
执行开始前：state=CLOSED , metrics[ failureRate=-1.0, bufferedCalls=0, failedCalls=0, successCalls=0, maxBufferCalls=5, notPermittedCalls=0 ]
count的值 = 0
服务正常运行，获取用户列表
执行结束后：state=CLOSED , metrics[ failureRate=-1.0, bufferedCalls=1, failedCalls=0, successCalls=1,

执行开始前：state=CLOSED , metrics[ failureRate=-1.0, bufferedCalls=1, failedCalls=0, successCalls=1, maxBufferCalls=5, notPermittedCalls=0 ]
count的值 = 1
异常A，不需要被记录,方法被降级了~~
降级方法中:state=CLOSED , metrics[ failureRate=-1.0, bufferedCalls=1, failedCalls=0, successCalls=1, maxBufferCalls=5, notPermittedCalls=0 ]
执行结束后：state=CLOSED , metrics[ failureRate=-1.0, bufferedCalls=1, failedCalls=0, successCalls=1, maxBufferCalls=5, notPermittedCalls=0 ]

执行开始前：state=CLOSED , metrics[ failureRate=-1.0, bufferedCalls=1, failedCalls=0, successCalls=1, maxBufferCalls=5, notPermittedCalls=0 ]
count的值 = 2
异常B，需要被记录,方法被降级了~~
降级方法中:state=CLOSED , metrics[ failureRate=-1.0, bufferedCalls=2, failedCalls=1, successCalls=1, maxBufferCalls=5, notPermittedCalls=0 ]
执行结束后：state=CLOSED , metrics[ failureRate=-1.0, bufferedCalls=2, failedCalls=1, successCalls=1, maxBufferCalls=5, notPermittedCalls=0 ]

执行开始前：state=CLOSED , metrics[ failureRate=-1.0, bufferedCalls=2, failedCalls=1, successCalls=1, maxBufferCalls=5, notPermittedCalls=0 ]
count的值 = 3
异常B，需要被记录,方法被降级了~~
降级方法中:state=CLOSED , metrics[ failureRate=-1.0, bufferedCalls=3, failedCalls=2, successCalls=1, maxBufferCalls=5, notPermittedCalls=0 ]
执行结束后：state=CLOSED , metrics[ failureRate=-1.0, bufferedCalls=3, failedCalls=2, successCalls=1, maxBufferCalls=5, notPermittedCalls=0 ]

执行开始前：state=CLOSED , metrics[ failureRate=-1.0, bufferedCalls=3, failedCalls=2, successCalls=1, maxBufferCalls=5, notPermittedCalls=0 ]
count的值 = 4
服务正常运行，获取用户列表
执行结束后：state=CLOSED , metrics[ failureRate=-1.0, bufferedCalls=4, failedCalls=2, successCalls=2, maxBufferCalls=5, notPermittedCalls=0 ]

执行开始前：state=CLOSED , metrics[ failureRate=-1.0, bufferedCalls=4, failedCalls=2, successCalls=2, maxBufferCalls=5, notPermittedCalls=0 ]
count的值 = 5
异常A，不需要被记录,方法被降级了~~
降级方法中:state=CLOSED , metrics[ failureRate=-1.0, bufferedCalls=4, failedCalls=2, successCalls=2, maxBufferCalls=5, notPermittedCalls=0 ]
执行结束后：state=CLOSED , metrics[ failureRate=-1.0, bufferedCalls=4, failedCalls=2, successCalls=2, maxBufferCalls=5, notPermittedCalls=0 ]

执行开始前：state=CLOSED , metrics[ failureRate=-1.0, bufferedCalls=4, failedCalls=2, successCalls=2, maxBufferCalls=5, notPermittedCalls=0 ]
count的值 = 6
异常B，需要被记录,方法被降级了~~
降级方法中:state=OPEN , metrics[ failureRate=60.0, bufferedCalls=5, failedCalls=3, successCalls=2, maxBufferCalls=5, notPermittedCalls=0 ]
执行结束后：state=OPEN , metrics[ failureRate=60.0, bufferedCalls=5, failedCalls=3, successCalls=2, maxBufferCalls=5, notPermittedCalls=0 ]

执行开始前：state=OPEN , metrics[ failureRate=60.0, bufferedCalls=5, failedCalls=3, successCalls=2, maxBufferCalls=5, notPermittedCalls=0 ]
熔断器已经打开，拒绝访问被保护方法~
熔断器打开中:state=OPEN , metrics[ failureRate=60.0, bufferedCalls=5, failedCalls=3, successCalls=2, maxBufferCalls=5, notPermittedCalls=1 ]
执行结束后：state=OPEN , metrics[ failureRate=60.0, bufferedCalls=5, failedCalls=3, successCalls=2, maxBufferCalls=5, notPermittedCalls=1 ]
 */