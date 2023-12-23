package com;

import com.entity.Monster;
import com.mapper.MonsterMapper;
import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicSqlTest {

    private SqlSession sqlSession;
    private MonsterMapper monsterMapper;

    @Before
    public void init() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
         monsterMapper = sqlSession.getMapper(MonsterMapper.class);
    }

    @Test
    public void findMonsterByAge() {
        List<Monster> monsters = monsterMapper.findMonsterByAge(-1);
        for (Monster monster : monsters) {
            System.out.println(monster);
        }
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void findMonsterByIdAndName() {
        Monster monster = new Monster();
        monster.setName("xx");
        monster.setId(-1);
        List<Monster> monsters = monsterMapper.findMonsterByIdAndName(monster);
        for (Monster monster1 : monsters) {
            System.out.println(monster1);
        }
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }


    @Test
    public void findMonsterByIdOrName_choose() {
        Map<String , Object> map = new HashMap<>();
//        map.put("id",21);
//        map.put("name","xx");
        List<Monster> monsters = monsterMapper.findMonsterByIdOrName_choose(map);
        for (Monster monster1 : monsters) {
            System.out.println(monster1);
        }
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }
    @Test
    public void findMonsterById_forEach() {
        Map<String , Object> map = new HashMap<>();

        List<Integer> integers = Arrays.asList(11, 12, 13);
        map.put("ids", integers);
//        map.put("name","xx");
        List<Monster> monsters = monsterMapper.findMonsterById_forEach(map);
        for (Monster monster1 : monsters) {
            System.out.println(monster1);
        }
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
