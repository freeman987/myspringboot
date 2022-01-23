package com.mygroup.myproject.serviceimpl;

import com.mygroup.myproject.repository.PersonRepository;
import com.mygroup.myproject.serviceinterface.PersonService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Slf4j
@Service
public class PersonServiceImpl2 implements PersonService2 {
    @Autowired
    PersonRepository personRepository;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public Integer updatePerson2(Integer id){
        String name = "jingjing";
        Integer num = personRepository.updatePersonById2(name,2);
        int i= 1/0;
        return num;
    }

}
