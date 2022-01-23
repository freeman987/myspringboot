package com.mygroup.myproject.servicefeign;

import com.mygroup.myproject.entity.Person;
import com.mygroup.myproject.hystric.FeignPersonServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//因为不能绑定2个同样的myeurekaclient，所以把这个地方改成555555，方便另外一个地方的测试。
@FeignClient(value = "myeurekaclient555555",fallbackFactory = FeignPersonServiceFallbackFactory.class)
public interface FeignPersonService {

    //@Cacheable(value="getBusinessDetail",key = "#root.args[0]", unless="#result == null")
    //注意要写全url路径，这个服务查找是通过url路径匹配的，而不是方法名。
    //最终url的路径是http://myeurekaclient/hello1/hello2/findperson?id=1
    @GetMapping("/hello1/hello2/findperson")
    public Person findpersonxxx(@RequestParam(value="id",required = false,defaultValue = "1")Integer id);


}
