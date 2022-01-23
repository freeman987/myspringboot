package com.mygroup.myproject.serviceinterface;

import com.mygroup.myproject.entity.Person;

public interface PersonService {
    public Integer insertPerson();
    public Integer insertPerson2();
    public Person findPerson(Integer id);
    public Person getPerson(Integer id);
    public Integer updatePerson (Integer id);
    public Integer addMoney3(Integer id);
    public Integer addMoney(Integer id);
    public Integer addMoney2(Integer id);
    public Integer updatePerson2(Integer id);


}
