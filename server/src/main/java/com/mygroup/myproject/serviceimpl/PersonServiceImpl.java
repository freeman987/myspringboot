package com.mygroup.myproject.serviceimpl;

import com.mygroup.myproject.entity.Person;
import com.mygroup.myproject.mapper.PersonMapper;
import com.mygroup.myproject.repository.PersonRepository;
import com.mygroup.myproject.serviceinterface.PersonService;
import com.mygroup.myproject.serviceinterface.PersonService2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {
    //private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
    @Autowired
    PersonService2 personService2;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonMapper personMapper;

    @Autowired
    protected RedisTemplate redisTemplate;

    public Integer insertPerson(){
        LocalDateTime localDateTime = LocalDateTime.of(1993, 12, 17, 5, 20, 20);
        Map<String,Object> map = new HashMap<>();
        map.put("id",5);
        map.put("name","jingjing");
        map.put("sex",5);
        map.put("birthday",localDateTime);
        map.put("money",new BigDecimal(500000));
        int num =personMapper.insertPerson(map);
        return num;
    }

    public Integer insertPerson2(){
        LocalDateTime localDateTime = LocalDateTime.of(1993, 12, 17, 5, 20, 20);
        Person person = new Person();
        person.setId(5);
        person.setName("jingjing");
        person.setSex(5);
        person.setBirthday(localDateTime);
        person.setMoney(new BigDecimal(500000));
        int num =personMapper.insertPerson2(person);
        return num;
    }

    public Person findPerson(Integer id){
        Person person = personMapper.findPerson(id);
        person = personMapper.findPerson(id);//测试mybatis一级缓存失效。
        return person;
    }



    /*
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).orElse(null);
        if (orderMaster == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetailList)) {
            throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST);
        }
     */

    /*
        public ProductInfo findOne(String productId) {
        Optional<ProductInfo> productInfoOptional = repository.findById(productId);
//        if (productInfoOptional.isPresent()) {
//            return productInfoOptional.get().addImageHost(upYunConfig.getImageHost());
//        }
//        return null;

        productInfoOptional.ifPresent(e -> e.addImageHost(upYunConfig.getImageHost()));
        return productInfoOptional.orElse(null);
    }
     */



    @Override
    @Cacheable(cacheNames="person",key="#id")
    public Person getPerson(Integer id) {
        Person person = personRepository.getPersonById(id);
        return person;
    }



    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updatePerson(Integer id) {
        //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        BigDecimal money = new BigDecimal(500000);
        Integer num = personRepository.updatePersonById(money,id);
        try {
            //内部事务是REQUEST_NEW，如果不加try catch，外部事务会跟着内部事务一起回滚
            //内部事务是REQUEST_NEW，如果加try catch，外部事务不会跟着内部事务一起回滚。内部事务自己回滚，外部事务不回滚。
            //内部事务是REQUIRED，无论加不加try catch，外部事务会跟着内部事务一起会回滚（因为是同一个事务）
            personService2.updatePerson2(id);
        }catch (Exception e){
            System.out.println("----xxxxxx-----");
        }
//        this.updatePerson2(id);//用this调用仍然同时回滚，只要updatePerson，updatePerson2，同时加Transactional
        return num;
    }

//注意this.a和userservice.a()区别

//1，测试this.updatePerson2()用。
//只要updatePerson，updatePerson2，同时加Transactional，this调用仍然同时回滚。
//如果updatePerson里没有加Transactional，即使updatePerson2加Transactional，2个都不会回滚。说明都没有事务。

//2，如果通过personService2.updatePerson2调用，而不是通过this.updatePerson2()调用。
//如果updatePerson里没有加Transactional，personService2.updatePerson2加Transactional（REQUIRED）
//那么updatePerson成功，personService2.updatePerson2回滚。
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Integer updatePerson2(Integer id) {
        String name = "jingjing";
        Integer num = personRepository.updatePersonById2(name,2);
        int i= 1/0;
        return num;
    }






    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addMoney3(Integer id) {
        //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        Person person = personRepository.getPersonById(id);
        BigDecimal oldMoney=person.getMoney();
        BigDecimal newMoney =oldMoney.add(new BigDecimal(1));
        Integer num = personRepository.addMoney3(newMoney,oldMoney,id);
        if(num==1)
            System.out.println("----xxxxxx-----");
        if(num==0)
            System.out.println("----yyyyyy-----");
        return num;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addMoney(Integer id) {
        //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        Person person = personRepository.getPersonById(id);
        BigDecimal newMoney =person.getMoney().add(new BigDecimal(1));
        Integer num = personRepository.addMoney(newMoney,id);
        return num;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addMoney2(Integer id) {
        //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        Integer num = personRepository.addMoney2(id);
        return num;
    }
}
