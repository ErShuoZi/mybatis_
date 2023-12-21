package com.mapper;

import com.entity.Monster;

/**
 * 该接口用于声明操作Monster表的方法，这些方法通过注解或者xml文件来实现
 */
public interface MonsterMapper {
    //添加Monster
    public void addMonster(Monster monster);

    //删除Monster
    public void delMonster(Integer id);
}
