package com.mygroup.myproject.mapper;

import com.mygroup.myproject.entity.Person;
import org.apache.ibatis.annotations.*;
import java.util.Map;

//@CacheNamespace//mybatis二级缓存
@Mapper
public interface PersonMapper {

    @Insert("insert into testtable(id,name,sex,birthday,money)values(#{id,jdbcType=INTEGER},#{name,jdbcType=VARCHAR},#{sex,jdbcType=TINYINT},#{birthday,jdbcType=DATE},#{money,jdbcType=DECIMAL})")
    int insertPerson(Map<String,Object>map);

    @Insert("insert into testtable(id,name,sex,birthday,money)values(#{id,jdbcType=INTEGER},#{name,jdbcType=VARCHAR},#{sex,jdbcType=TINYINT},#{birthday,jdbcType=DATE},#{money,jdbcType=DECIMAL})")
    int insertPerson2(Person person);

    @Select("Select * from testtable where id=#{id,jdbcType=INTEGER}")
//            @Results({@Result(property = "id", column = "id"),
//            @Result(property = "name", column = "name"),
//            @Result(property = "sex", column = "sex"),
//            @Result(property = "birthday", column = "birthday"),
//            @Result(property = "money", column = "money")
//            })
    Person findPerson(Integer id);
    /*
    传入多个参数的时候要加@Param，例如：
    Person findPerson(@Param("id")Integer id, @Param("name")String name);
    * */

//    @Select({"select * from relation_user ",
//            " where deleted = 0 and user_id = #{userId} and status <= 0 order by id desc limit 1"})
//    @Results({@Result(property = "userId", column = "user_id"),
//            @Result(property = "fromUserId", column = "from_user_id"),
//            @Result(property = "daysNoLogin", column = "days_no_login"),
//            @Result(property = "fromAmount", column = "from_amount"),
//            @Result(property = "createdAt", column = "created_at"),
//            @Result(property = "updatedAt", column = "updated_at")})
//    RelationUser selectByUserId(@Param("userId") Long userId);
//
//
//    @Insert({"insert into relation_user(user_id, from_user_id, `type`, `days_no_login`, `status`, `number`, deadline, amount, times)",
//            " values(#{ru.userId}, #{ru.fromUserId}, #{ru.type}, #{ru.daysNoLogin}, #{ru.status}, #{ru.number}, #{ru.deadline}, #{ru.amount}, #{ru.times})"})
//    int insert(@Param("ru") RelationUser relationUser);
//
//    @Update({"update relation_user set from_amount=#{relationUser.fromAmount}, updated_at=now()",
//            " where deleted=0 and user_id=#{relationUser.userId} and",
//            " type = #{relationUser.type} and from_user_id = #{relationUser.fromUserId} order by id desc limit 1"})
//    int updateFromAmount(@Param("relationUser") RelationUser relationUser);


}
