package com.mygroup.myproject.myr4j.servicefeignr4j;

import com.mygroup.myproject.entity.Person;
import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "myeurekaclient", //url = "http://localhost:${server.port}/",
        fallbackFactory = FeignR4jService.FeignR4jServiceFallbackFactory.class)
public interface FeignR4jService {
    @RequestMapping(method = RequestMethod.GET, value = "/hello1/hello2/getpersons")
    List<Person> getPersonsxxxx();


    @Component
    static class FeignR4jServiceFallbackFactory implements FallbackFactory<FallbackWithFactory> {
        @Override
        public FallbackWithFactory create(Throwable cause) {
            System.out.println("----in create()----");
            return new FallbackWithFactory();
        }
    }


    static class FallbackWithFactory implements FeignR4jService {
        @Override
        public List<Person> getPersonsxxxx() {
            System.out.println("----in fallback()----");
            throw new NoFallbackAvailableException("Boom!", new RuntimeException());
        }
    }
}


