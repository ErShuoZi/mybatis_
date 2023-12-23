package com;

import com.entity.Monster;
import com.mapper.MonsterMapper;
import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
}
