package com.mygroup.myproject.repository;
import com.mygroup.myproject.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

    @Query(value="select * from testtable where id=:id", nativeQuery=true)
    Person getPersonById(@Param("id")Integer id);

    @Modifying
    @Transactional
    @Query(value="update testtable set money=:money where id=:id", nativeQuery=true)
    Integer updatePersonById(@Param("money")BigDecimal money,@Param("id")Integer id);

    @Modifying
    @Transactional
    @Query(value="update testtable set name=:name where id=:id", nativeQuery=true)
    Integer updatePersonById2(@Param("name")String name,@Param("id")Integer id);


    @Modifying
    @Transactional
    @Query(value="update testtable set money=:newmoney where id=:id and money=:oldmoney", nativeQuery=true)
    Integer addMoney3(@Param("newmoney")BigDecimal newmoney,@Param("oldmoney")BigDecimal oldmoney,@Param("id")Integer id);

    @Modifying
    @Transactional
    @Query(value="update testtable set money=:money where id=:id", nativeQuery=true)
    Integer addMoney(@Param("money")BigDecimal money,@Param("id")Integer id);

    @Modifying
    @Transactional
    @Query(value="update testtable set money=money+7 where id=:id and (money<=(401000.00-7.00))", nativeQuery=true)
    Integer addMoney2(@Param("id")Integer id);
}
