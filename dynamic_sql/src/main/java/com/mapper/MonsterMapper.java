package com.mapper;

import com.entity.Monster;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface MonsterMapper {
 public List<Monster> findMonsterByAge(@Param(value = "age") Integer age);
 public List<Monster> findMonsterByIdAndName(Monster monster);

 public List<Monster> findMonsterByIdOrName_choose(Map<String,Object> map);

 public List<Monster> findMonsterById_forEach(Map<String,Object> map);
 public List<Monster> findMonsterById_Trim(Map<String,Object> map);
}
