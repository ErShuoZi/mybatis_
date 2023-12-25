package com.mapper;

import com.entity.IdenCard;
import org.apache.ibatis.annotations.Select;

/**
 * 使用注解方式实现一对一映射
 */

public interface IdenCardMapperAnnotation {
    @Select("SELECT * FROM `idencard` WHERE id = #{id}")
    public IdenCard getIdenCardByIdAnnotation(Integer id);
}
