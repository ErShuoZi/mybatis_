package com.mapper;

import com.entity.Monster;

import java.util.List;
import java.util.Map;


public interface MonsterMapper {
    public List<Monster> findMonsterByNameORId(Monster monster);
    public List<Monster> findMonsterByName(String name);

    public List<Monster> findMonsterByIdAndSalary_PrameterHashMap(Map<String, Object> map);

    public List<Map<String ,Object>> findMonsterByIdAndSalary_PrameterHashMap_ReturnHashMap(Map<String, Object> map);
}
