package com.mapper;

import com.entity.Person;

public interface PersonMapper {
    //通过Person的id获取到Person，包括这个Person关联的IdenCard对象[级联查询]
    public Person getPersonById(Integer id);
}
