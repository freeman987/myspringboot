package com.mygroup.registrar;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CarDao {
    @Select("Select * from testtable where id=#{id,jdbcType=INTEGER}")
    public void list(Integer hi);
}
