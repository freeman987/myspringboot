package com.mygroup.myproject.hystric;

import com.mygroup.myproject.entity.Person;
import com.mygroup.myproject.servicefeign.FeignPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @ClassName: PersonServiceFallbackFactory
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/9
 * @Version 1.0
 */
@Slf4j
@Component
public class FeignPersonServiceFallbackFactory implements FallbackFactory<FeignPersonService> {

    @Override
    public FeignPersonService create(Throwable cause) {
        return new FeignPersonService() {
            @Override
            public Person findpersonxxx(Integer id){
                log.info("服务降级了");
                return null;
            }

//            @Override
//            public ResponseBase getUseridsAndMobiles(List<Integer> id) {
//                return ResponseBase.failed(ApiCode.SERVICE_EXCEPTION, cause.getMessage());

        };
    }
}
