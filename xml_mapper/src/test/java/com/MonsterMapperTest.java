package com;

import com.entity.Monster;
import com.mapper.MonsterMapper;
import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MonsterMapperTest {
    private SqlSession sqlSession;
    private MonsterMapper monsterMapper;
    @Before
    public void init() {
        sqlSession = MybatisUtils.getSqlSession();
        monsterMapper = sqlSession.getMapper(MonsterMapper.class);
    }

    @Test
    public void findMonsterByNameORId() {
        Monster monster = new Monster();
        monster.setName("xx");
        monster.setId(1);
       List<Monster> monsters =monsterMapper.findMonsterByNameORId(monster);
        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println(monsters);
    }



    @Test
    public void findMonsterByName() {

       List<Monster> monsters = monsterMapper.findMonsterByName("ha");
        for (Monster monster : monsters) {
            System.out.println(monster);
        }
        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }

    }


    @Test
    public void findMonsterByIdAndSalary_PrameterHashMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id",10);
        map.put("salary",40);
        System.out.println(map);
        List<Monster> monsters =monsterMapper.findMonsterByIdAndSalary_PrameterHashMap(map);
        for (Monster monster : monsters) {
            System.out.println(monster);
        }
        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void findMonsterByIdAndSalary_PrameterHashMap_ReturnHashMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id",10);
        map.put("salary",40);
        List<Map<String,Object>> monstersList =monsterMapper.findMonsterByIdAndSalary_PrameterHashMap_ReturnHashMap(map);
        for (Map<String, Object> monsterMap : monstersList) {
//            Set<String> keys = monsterMap.keySet();
//            for (String key : keys) {
//                System.out.println(key + "-" + monsterMap.get(key));
//            }
            for (Map.Entry<String, Object> entry : monsterMap.entrySet()) {
                System.out.println(entry.getKey() + entry.getValue());
            }
        }

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
