package com.mapper;

import com.entity.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface PersonMapperAnnotation {
    @Select("SELECT * FROM `person` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "card",column = "card_id",one = @One(select = "com.mapper.IdenCardMapper.getIdenCardById"))
    })
    public Person getPersonByIdAnnotation(Integer id);
}
