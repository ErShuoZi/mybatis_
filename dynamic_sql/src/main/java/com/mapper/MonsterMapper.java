package com.mapper;

import com.entity.Monster;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MonsterMapper {
 public List<Monster> findMonsterByAge(@Param(value = "age") Integer age);
 public List<Monster> findMonsterByIdAndName(Monster monster);
}
